#include <errno.h>
#include <stdio.h>
#include <unistd.h>

// system Call -- Success: 0, Fail: -1


extern int errno;
int main(void) {
	if (access("linux.txt", F_OK) == -1) {
		printf("errno=%d\n", errno);
	}

	return 0;
}
