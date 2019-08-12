#include <stdio.h>
#define LEN 10

int main(void){
	
	int arr[LEN] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
	int len = sizeof(arr)/sizeof(int);
	int i, j, temp;
	
	for(i = 0 ; i < len ; i++);{
		printf("test : %d\n", i);
	
		for(j = 0 ; j < len-i-1 ; j++){
				printf("testtestestetsetset");
			if(arr[j] > arr[j+1]){
				printf("test");
//				swap(&arr[j], &arr[j+1]);
			}
		}
	
	}
	
//	for(i = 0 ; i < len ; i++){
//		printf("%d\n", arr[i]);
//	}
	return 0;
}

void swap(int *a, int *b){
	int t = *a;
	*a = *b;
	*b = t;
}
