#include <stdio.h>

int main(void){
	
	int arr[10] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
	int i, j, index;
	
	for(i = 1 ; i < 10 ; i++){
		j = i;
		while(arr[j-1] > arr[j] && j > 0){
			swap(&arr[j-1], &arr[j]);
			j--;
		}
	}

//	for(i = 0 ; i < 10 ; i++){
//		for(j = i+1 ; j > 0 ; j--){
//			if(arr[j-1] > arr[j]){
//				swap(&arr[j-1], &arr[j]);
//			}else{
//				break;
//			}
//		}
//	}
	
	for(i = 0 ; i < 10 ; i++){
		printf("%d  ", arr[i]);
	}
	
	return 0;
}

void swap(int *a, int *b){
	int t = *a;
	*a = *b;
	*b = t;
}

// 2 8 9 | 4 7 10
// 0 1 2   3 4 5

// 2 8 9 | 4
