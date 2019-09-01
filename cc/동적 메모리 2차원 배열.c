#include <stdio.h>
#include <stdlib.h>
#define WIDTH 6
#define HEIGHT 8

int main(void){
	
	int **pptr, i, x, y;
	pptr = (int **) malloc(sizeof(int *) * HEIGHT);
	
	for(i = 0 ; i < HEIGHT; i++){
		*(pptr+i) = (int *) malloc(sizeof(int) * WIDTH);
	}
	
	for(y = 0 ; y < HEIGHT ; y++){
		for(x = 1 ; x <= WIDTH ; x++){
			*(*(pptr+y)+x) = 6 * y + x;
			printf("%3d", *(*(pptr+y)+x));
		}
		printf("\n");
	}
	
	for(y = 0 ; y < HEIGHT ; y++){
		free(*(pptr+y));
	}
	
	return 0;
}
