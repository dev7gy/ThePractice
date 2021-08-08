#include <stdio.h>
int main() {
	typedef struct test1{
		int i;
		double b;
	} te1;

	typedef union test2 {
		int i;
		double d;
		double c;
	} te2;


	te1 a;
	te2 b;
	a.i = 12;
	a.b = 1.1;

	b.i = 13;
	b.c = 1.3;

	printf("%d\n %ld", a.i, sizeof(te2));

}
