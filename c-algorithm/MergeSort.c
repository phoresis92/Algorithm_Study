#include <stdio.h>
	
int number = 10;
int temp[10];

void merge(int a[], int m, int middle, int n){
	
	int i = m;
	int j = middle+1;
	int k = m;
	int t;
	//작은 순서대로 삽입 
	while(i <= middle && j <= n){
		if(a[i] <= a[j]){
			temp[k] = a[i];
			i++;
		} else {
			temp[k] = a[j];
			j++;
		}
		k++;
	}
	if(i > middle){
		for(t = j ; t <= n ; t++){
			temp[k] = a[t];
			k++;
		}
	}
	if(j > n){
		for(t = i ; t <= middle; t++){
			temp[k] = a[t];
			k++;
		}
	}
	
	for(t = m ; t <= n ; t++){
		a[t] = temp[t];
	}
	
}

void mergeSort(int a[], int m, int n){
	
	if(m < n){
		int middle = (m + n) / 2;
		mergeSort(a, m, middle);
		mergeSort(a, middle+1, n);
		merge(a, m, middle, n);
	}
	
}

int main(void){
	
	int arr[10] = {9, 2, 8, 4, 7, 10, 1, 6, 5, 3};
	mergeSort(arr, 0, 9);
	
	int i;
	for(i = 0 ; i < 10 ; i++){
		printf("%d  ", arr[i]);
	}
	
	return 0;
}
