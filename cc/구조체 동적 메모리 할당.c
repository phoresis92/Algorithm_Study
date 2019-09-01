#include <stdio.h>
#include <stdlib.h>
#define MAX 2

struct Book{
	int number;
	char title[100];
};

int main(void){
	
	struct Book *p;
	p = (struct Book *) malloc(sizeof(struct Book) * MAX);
	
	p->number = 1;
	strcpy(p->title, "C Programing");
	
	(p + 1)->number = 2;
	strcpy((p + 1)->title, "Data Structure");
	
	showBook(p, MAX);
	
	free(p);
	return 0;
}

void showBook(struct Book *p, int n){
	int i;
	for(i = 0 ; i < n ; i++){
		printf("number : %d , title : %s\n", (p+i)->number, (p+i)->title);
	}
}
