#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

#define N 1000

/* Matrix */ 
long long int A[N][N],B[N][N],R[N][N];
	
int main(int argc, char *argv[])
{
  int x,y,z;
  char str[100];

  /* Matrix initialization */
  for(y=0; y<N; y++) 
		for(x=0; x<N; x++)
		{
			A[y][x]=x;
			B[y][x]=y;
			R[y][x]=0;	
		}
		
	/* Matrix multiplication */
	for(y=0; y<N; y++)
		for(z=0; z<N; z++) 
			for(x=0; x<N; x++) 
			{
				R[y][x]+= A[y][z] * B[z][x];	
			}

	/* Print results */
    	for(y=0; y<N; y++)
    	{
    	  const char *space = "";
    	  for(x=0; x<N; x++)
    	  {
    	    sprintf(str, "%s%lli", space, R[y][x]);
    	    write(1, str, strlen(str));
    	    space = " ";
    	  }
    	  write(1, "\n", 1);
    	}     
      
	exit(0);
}
