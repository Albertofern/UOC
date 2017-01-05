#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define N 1000
	
int main(int argc, char *argv[])
{
	/* Matrix definition */  
	long long int **A, **B, **R;
	int x,y,z;
	char str[100];
	int i;

  /* Dynamic memory allocation */
  A = (long long int**) malloc(N*sizeof(long long int *));
  if(A == NULL)
    exit(1);
  for(i=0; i<N; i++)
  {
    A[i] = (long long int *)malloc(N*sizeof(long long int));
    if(A[i] == NULL)
      exit(1);
	}

  B = (long long int**) malloc(N*sizeof(long long int *));
  if(B == NULL)
    exit(1);
  for(i=0; i<N; i++)
  {
    B[i] = (long long int *)malloc(N*sizeof(long long int));
    if(B[i] == NULL)
      exit(1);
	}

  R = (long long int**) malloc(N*sizeof(long long int *));
  if(R == NULL)
    exit(1);
  for(i=0; i<N; i++)
  {
    R[i] = (long long int *)malloc(N*sizeof(long long int));
    if(R[i] == NULL)
      exit(1);
	}

	/* Matrix initialization */
	for(y=0; y<N; y++) 
		for(x=0; x<N; x++)
		{
			A[y][x] = x;
			B[y][x] = y;
			R[y][x] = 0;	
		}
		
	/* Matrix multiplication */
	for(y=0; y<N; y++)
		for(z=0; z<N; z++) 
			for(x=0; x<N; x++) 
			{
				R[y][x] += A[y][z] * B[z][x];
			}


	/* Free memory */
	for(i=0; i<N; i++)
  {
		free(A[i]);
		free(B[i]);
		free(R[i]);
	}
	free(A);
	free(B);
	free(R);

	exit(0);
}
