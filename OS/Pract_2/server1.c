#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <stdlib.h>
#include <time.h>
#include <errno.h>
#include <sys/stat.h>
#include <sys/times.h>
#include <sys/wait.h>

#define NAMED_PIPE          "input"     /* Named pipe used to communicate with the server */
#define MAX_DELAY           5           /* Max delay (seconds) */
#define MAX_REQUEST_SIZE    80          /* Max size of the request (bytes) */
#define WORKING_DIRECTORY   "working"   /* Server's working directory */
#define MAX_CONCURRENT      5           /* Max number of concurrent processes */

/* Color codes */
char *color_red = "\033[01;31m";
char *color_yellow = "\033[01;33m";
char *color_green = "\033[01;32m";
char *color_end = "\033[00m";

typedef char t_string[MAX_REQUEST_SIZE];

/* syscall error handling */
void
panic (char *str)
{
  t_string s;

  write (2, str, strlen (str));
  write (2, "\n", 1);
  if (errno != 0)
    {
      sprintf (s, "%d %s\n", errno, strerror (errno));
      write (2, s, strlen (s));
    }
  exit (0);
}

/* Implements a random delay */
void
delay ()
{
  struct timespec t;

  t.tv_sec = rand () % (MAX_DELAY + 1);
  t.tv_nsec = 0;
  nanosleep (&t, NULL);
}

/* Implements copy request */
int
do_copy (char *src, char *dst)
{
  t_string s;
  int pid, n;

  sprintf (s, "%s[%d] copy %s %s\n%s", color_green, getpid (), src, dst,
           color_end);
  if (write (1, s, strlen (s)) == -1)
    return -1;

  delay ();

  switch (pid = fork ())
  {
    case -1:
      /* In case of error, finish the process */
      panic ("Fork error");

    case 0:
      execlp ("cp", "cp", src, dst, NULL);
      /* In case of error, finish the process */
      panic ("Exec cp error");

    default:
      wait (&n);
  }

  if (WEXITSTATUS (st) == 0)
    return 0;
  else
    return -1;
}

/* Implements rename request */
int
do_rename (char *old, char *new)
{
  t_string s;
  int pid, n;

  sprintf (s, "%s[%d] rename %s %s\n%s", color_green, getpid (), old, new,
           color_end);
  if (write (1, s, strlen (s)) == -1)
    return -1;

  delay ();

  switch (pid = fork ()) {
    case -1:
      /* In case of error, finish the process */
      panic ("Fork error");

    case 0:
      execlp ("mv", "mv", old, new, NULL);
      /* In case of error, finish the process */
      panic ("Exec mv error");

    default:
      wait(&n);
  }

  if (WEXITSTATUS (st) == 0)
    return 0;
  else
    return -1;
}

/* Implements numfiles request */
int
do_numfiles (char *pattern)
{
  t_string s;

  sprintf (s, "%s[%d] numfiles %s (not yet implemented)\n%s", color_red,
           getpid (), pattern, color_end);
  if (write (1, s, strlen (s)) == -1)
    return -1;

  delay ();

  /* Must return the number of file names that satisfy the pattern */
  return 0;
}

/* Implements exit request */
int
do_exit ()
{
  t_string s;

  sprintf (s, "%s[%d] exiting\n%s", color_green, getpid (), color_end);
  if (write (1, s, strlen (s)) == -1)
    return -1;

  /* Removes named pipe */
  unlink (NAMED_PIPE);

  exit (0);
}

/* Init server */
int
init ()
{
  int ret, fd;

  /* Creating named pipe */
  unlink (NAMED_PIPE);
  ret = mknod (NAMED_PIPE, S_IFIFO | 0600, 0);
  if (ret == -1)
    panic ("creating named pipe");

  /* Opening named pipe */
  fd = open (NAMED_PIPE, O_RDWR);
  if (fd == -1)
    panic ("open named pipe");

  /* Moving to working directory */
  if (chdir (WORKING_DIRECTORY) == -1)
    panic ("changing directory");

  /* Init random generator */
  srand (getpid ());

  return (fd);
}

/* Read the request */
void
read_request (int fd, t_string request)
{
  int ret, i = -1;

  do
    {
      i++;
      ret = read (fd, &request[i], 1);
      if (ret <= 0)
        panic ("read");
    }
  while ((request[i] != '\n') && (i < MAX_REQUEST_SIZE));

  if (request[i] != '\n')
    panic ("too long request");

  /* Null terminate request */
  request[i] = '\0';
}

/* Serve the request */
void
serve_request (t_string request)
{
  int ret;
  t_string s, task, par1, par2, foo;

  /* Parse request */
  ret = sscanf (request, "%s %s %s %s\n", task, par1, par2, foo);

  if ((strcmp (task, "copy") == 0) && (ret == 3))
    ret = do_copy (par1, par2);
  else if ((strcmp (task, "rename") == 0) && (ret == 3))
    ret = do_rename (par1, par2);
  else if ((strcmp (task, "numfiles") == 0) && (ret == 2))
    ret = do_numfiles (par1);
  else if ((strcmp (task, "exit") == 0) && (ret == 1))
    ret = do_exit ();
  else
    {
      ret = -1;
      sprintf (s, "%s[%d] syntax error\n%s", color_red, getpid (), color_end);
      if (write (1, s, strlen (s)) == -1)
        panic ("write");
    }

  sprintf (s, "%s[%d] return code %d\n%s", color_green, getpid (), ret,
           color_end);
  if (write (1, s, strlen (s)) == -1)
    panic ("write");
}

int
main (int argc, char *argv[])
{
  int fd;

  /* Init server */
  fd = init ();

  while (1)
    {
      t_string request;

      read_request (fd, request);
      serve_request (request);
    }

  return 0;
}
