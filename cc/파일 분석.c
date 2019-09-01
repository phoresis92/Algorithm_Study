#include <stdio.h>
#include <string.h>

FILE *fp;
char word[256];
char buffer[256];
char fname[256];


int main (void){

	scanfile();

	return 0;	
}

void scanfile(){
	
	int line = 0;
	char is = 'n';
		
	printf("input your file name : ");
	scanf("%s", fname);

	printf("input word to find : ");
	scanf("%s", word);
	
	if((fp = fopen(fname, "r")) == NULL){
		fprintf(stderr, "%s >>> fail to open the file\n", fname);
		scanfile();
		return 0;
	}
	
	while(fgets(buffer, 100, fp)){
		line++;
		printf("%s", buffer);
		if(strstr(buffer, word)){
			printf("your word is at line number : %d\n", line);
			is = 'y';
		}
	}
	if(is == 'n'){
		scanfile();
	}

	fclose(fp);	
}
