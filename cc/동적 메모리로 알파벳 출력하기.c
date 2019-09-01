#include <stdio.h>
#include <stdlib.h>

int main(void){
	
	char *pc;
	int i;
	
	pc = (char *) malloc(sizeof(char) * 100);
	if(pc == 0){
		printf("fail to dynamic allocation !!!");
		exit(1);
	}
	
	for(i = 0 ; i < 26 ; i++){
		*(pc + i) = 'a' + i;
//		printf("%c\n", *(pc + i));
	}
	/* 아스키 코드에서 0은 NULL을 의미한다. */
	printf("%d\n", i);
	*(pc + i) = 0;
	/* %s 는 문자열을 반복문을 돌려 출력하다가 NULL 값을 만나면 중지함 */
	printf("|||%s|||\n", pc);
	
	free(pc);
	printf("|||%s|||\n", pc);
	
	return 0;
}
