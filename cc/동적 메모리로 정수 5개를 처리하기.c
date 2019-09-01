#include <stdio.h>
#include <stdlib.h>
#define SIZE 5

int main(void){
	
	int *pi, i;
	pi = (int *) malloc(sizeof(int) * SIZE);
	
	if(pi == NULL){
		printf("fail to dynamic memory allocation !!!");
		exit(1);
	}
	
	pi[0] = 100;
	pi[1] = 200;
	pi[2] = 300;
	pi[3] = 400;
	pi[4] = 500;
	
	for(i = 0 ; i < SIZE ; i++){
		printf("%d\n", *(pi + i));
	}
	
	free(pi);
	return 0;
} 
