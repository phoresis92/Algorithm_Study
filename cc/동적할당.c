#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void){
	
	int *pi;
	pi = (int *) malloc(sizeof(int));
//	printf("%d\n", sizeof(pi));
//	printf("%d", pi);

	printf("=======================\n");
	printf("%d\n\n", pi);
	printf("%d\n\n", *pi);
	printf("%d\n\n", &pi);
	printf("=======================\n\n\n");

	if(pi == NULL){
		printf("fail to dynamic allocation\n");
		exit(1);
	}
	
	*pi = 100;

	printf("=======================\n");
	printf("%d\n\n", pi);
	printf("%d\n\n", *pi);
	printf("%d\n\n", &pi);
	printf("=======================\n\n\n");

	free(pi);
	return 0;
}
