#include <stdio.h>

int num = 10;
int arr[10] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
	
void quickSort(int *arr, int start, int end){
	if(start >= end){ // ���Ұ� 1���� ��� 
		return;
	}	
	
	int key = start; // Ű�� ù��° ���� 
	int temp;
	int i = start+1;
	int j = end;
	
	while(i <= j){ // �������� ������ �ݺ��Ѵ� 
		while(arr[key] >= arr[i]){
			i++;
		}
		while(arr[key] <= arr[j] && j > start){
			j--;
		}
		
		if(i > j){
			temp = arr[key];
			arr[key] = arr[j];
			arr[j] = temp;
			
		} else {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
	} // outer while 

	quickSort(arr, start, j-1);
	quickSort(arr, j+1, end);
	
}

int main(void){
	
	quickSort(arr, 0 , num-1);
	
	int i;
	for(i = 0 ; i < 10 ; i++){
		printf("%d  ", arr[i]);
	}
	
	return 0;
}
