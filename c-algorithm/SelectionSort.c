#include <stdio.h>
#define LEN 10

int main(void){
	
	int arr[LEN] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
		
//	selectionSort(arr, LEN);
	
	int i, j, min, index;
	int len = sizeof(arr)/sizeof(int);
	
	for(i = 0 ; i < len ; i++){
		min = 999999;
		
		for(j = i ; j < len ; j++){
			if(min > arr[j]){
				min = arr[j];
				index = j;
			}
		}
				
		swap(&arr[i], &arr[index]);
	}

//	int i = 0;
//	int len = sizeof(arr) / sizeof(int);
	
	for(i = 0 ; i < len ; i++){
		printf("%d\n",arr[i]);
	}
	
	return 0;
}

void swap(int *a, int *b){
	int t = *a;
	*a = *b;
	*b = t;
}

//void selectionSort(int arr[], int len){
//	int i, j, min, index;
//	
//	for(i = 0 ; i < len ; i++){
//		min = 999999;
//		
//		for(j = i ; j < len ; j++){
//			if(min > arr[j]){
//				min = arr[j];
//				index = j;
//			}
//		}
//				
//		swap(&arr[i], &arr[index]);
//		
//	}
////	printf("==%d\n", sizeof(arr)/sizeof(int));
//}

