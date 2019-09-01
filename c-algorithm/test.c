#include <stdio.h>

int heap[10] = {9,5,1,6,8,4,7,2,3,0};
int num = 10;
int temp, i;

int tem[10];

void quickSort(int arr[], int start, int end){
	if(start >= end){
		return;
	}
	
	int lt = start + 1;
	int rt = end;
	int pi = start;
	
	while(lt <= rt){
		while(arr[lt] >= arr[pi]){
			lt++;
		}	
		while(arr[rt] <= arr[pi] && rt > start){
			rt--;
		}
		
		if(lt >= rt){
			
			temp = arr[rt];
			arr[rt] = arr[pi];
			arr[pi] = temp;
			
		}else{
			temp = arr[lt];
			arr[lt] = arr[rt];
			arr[rt] = temp;
		}
	}
	
	quickSort(arr, start, rt-1);
	quickSort(arr, rt+1, end);
	
	
	
}

int main(void){

	quickSort(heap, 0, 9);
	
	for(i = 0 ; i < num ; i++){
		printf("%d ", heap[i]);
	}
	
	return 0;
}
