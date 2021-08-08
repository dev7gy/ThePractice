#include <stdlib.h>
#include <errno.h>
#include <stdio.h>


// library function Fail: NULL, if return int-> -1
extern int errno;

int main(void) {
	FILE *fp;
	if ((fp = fopen("unix.txt", "r")) == NULL) {
		printf("errno=%d\n", errno);
		exit(1);
	}
	fclose(fp);

	return 0;
}
