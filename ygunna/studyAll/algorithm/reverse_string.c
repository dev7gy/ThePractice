#include <stdio.h>
#include <string.h>
int main(void) {
	char arr[20];
	printf("input string\n");
	scanf("%s", arr);

	int len = strlen(arr);
	printf("strlen: %d\n", len);
	char temp;
	for (int i = 0; i < (len/2); i++) {
		printf("r: %d\n", i);
		temp = arr[len -i -1];

		arr[len -i -1] = arr[i];
		arr[i] = temp;
	}
	printf("reverse: %s\n", arr);

	return 0;
}
