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
	/* �ƽ�Ű �ڵ忡�� 0�� NULL�� �ǹ��Ѵ�. */
	printf("%d\n", i);
	*(pc + i) = 0;
	/* %s �� ���ڿ��� �ݺ����� ���� ����ϴٰ� NULL ���� ������ ������ */
	printf("|||%s|||\n", pc);
	
	free(pc);
	printf("|||%s|||\n", pc);
	
	return 0;
}
