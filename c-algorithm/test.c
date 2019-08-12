#include <stdio.h>

int main(void){
	
	int arr[10] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
	int i, j;
	
	for(i = 0 ; i < 10 ; i++){
//		printf("%d\n", i);
		for(j = 0 ; j < 10-1-i ; j++){
			
			printf("j : %d\n", j);
		}
	}
	return 0;
}
