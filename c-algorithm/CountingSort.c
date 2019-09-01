#include <stdio.h>

int i, temp;

int main(void){

	int count[5];
	int array[30] = {1,3,2,4,3,2,5,3,1,2/*,
					 3,4,4,3,5,1,2,3,5,2,
					 3,1,4,3,5,1,2,1,1,1*/};
	
	for(i = 0 ; i < 5 ; i++){
		count[i] = 0;
	}
	
	for(i = 0 ; i < 30 ; i++){
		count[array[i]-1]++;
	}
	
	
	for(i = 0 ; i < 5 ; i++){
		if(count[i] != 0){
			for(temp = 1 ; temp <= count[i] ; temp++){
				printf("%d ", i+1);
			}
		}
	}

	return 0;
}
