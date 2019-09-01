#include <stdio.h>

int main(void){
	
	FILE *pointer = NULL;
	int c;
	
	pointer = fopen("∆˜¿Œ≈Õ!!!.c", "r");
	
	if(pointer == NULL){
		printf("fail to file io process!!!\n\n");
		return 0;
	}else{
		printf("success to file io process!!!!!!!!!!!!!!!!!!\n\n");
	}
	
	while((c = fgetc(pointer)) != EOF){
		putchar(c);
	}
	
	return 0;
}
