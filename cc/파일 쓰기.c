#include <stdio.h>

int main (void){
	
	FILE *size = NULL;
	size = fopen("size.c", "w");
	// w > ������(write), r > �б� ���(read)
	if(size == NULL){
		printf("fail to file io process\n");
		return 0;
	}else{
		printf("success to file io process\n");
	} 
	fputc('H', size);
	fputc('E', size);
	fputc('L', size);
	fputc('L', size);
	fputc('O', size);
	fclose(size);
	
	return 0;
}
