#include <stdio.h>
int main () {
	int input;
	int sum = 0;
	scanf("%d", &input);
	for ( int i = 1; i < input; i++) {
		if ( input%i == 0 ) {
			if ( i == 1) {
				printf("%d", i);
				continue;
			}
			printf(" + %d ", i);
			sum+=i;
		}	
	}
	printf("= %d", sum);
}
