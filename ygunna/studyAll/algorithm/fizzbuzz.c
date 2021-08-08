#include <stdio.h>
int main() {
	for (int i = 0; i < 100; i++) {
		if(i%3 == 0 && i%5 == 0) {
			printf("fizzbuzz: %d\n", i);
			continue;
		}
		else if(i%3 == 0) {
			printf("fizz: %d\n", i);
			continue;
		}
		else if(i%5 == 0) {
			printf("buzz: %d\n", i);
			continue;
		}
		else {
			continue;
		}
	}
}
