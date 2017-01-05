#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define N 1000
	
int main(int argc, char *argv[])
{
  // Matrix 
  long long int A[N][N],B[N][N],R[N][N];
  int x,y,z;
  char str[100];

  /* Matrix inicialization */
  for(y=0;y<N;y++) 
    for(x=0;x<N;x++)
    {
      A[y][x]=x;
      B[y][x]=y;
      R[y][x]=0;	
    }
		
  /* Matrix multiplication */
  for(y=0;y<N;y++)
    for(z=0;z<N;z++) 
      for(x=0;x<N;x++) 
      {
        R[y][x]+= A[y][z] * B[z][x];	
      }       

   exit(0);
}
