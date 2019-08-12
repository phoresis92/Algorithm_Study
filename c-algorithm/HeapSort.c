#include <stdio.h>

int number = 9;
int heap[9] = {7,6,5,8,3,5,9,1,6};

int main(void){
	
	int i;
	for(i = 1 ; i < number ; i++){
		int c = i;
		do{
			int root = (c - 1) / 2;
			if(heap[c] > heap[root]){
				int temp = heap[c];
				heap[c] = heap[root];
				heap[root] = temp;
			}
			c = root;
		}while(c != 0);
	}
	
	for(i = number-1 ; i >= 0 ; i--){
		int temp = heap[i];
		heap[i] = heap[0];
		heap[0] = temp;
		
		int root = 0;
		int c = 1;
		do{
			c = root * 2 + 1;
			if(heap[c] < heap[c+1] && c < i-1){
				c++;
			}
			if(heap[root] < heap[c] && c < i){
				temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;				
			}
			
			root = c;
			
		}while(c < i);
		
	} // for end
	
	for(i = 0 ; i < number ; i++){
		printf("%d ", heap[i]);
	}
	
	return 0;
}
