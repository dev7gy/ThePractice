#include <stdio.h>
int main() {
	int fibo(int n) {
		if ( n < 1 ) {
			return 0;
		} 
		else if ( n < 3 ) {
			return 1;
		}	
	       	else {
			return (fibo(n-1) + fibo(n-2));
		}
	}

	int input = 0;
	scanf("%d", &input);
	printf("fibo: %d %d\n", input, fibo(input));
}
