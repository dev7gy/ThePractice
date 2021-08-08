#include <stdio.h>
int main() 
{
	int num1, num2;
	int sum = 0;
	scanf("%d %d", &num1, &num2);
	for (int i = num1; i <= num2; i++) 
	{
		if (i < num2) 
		{
			printf("%d + ", i);
		}
		else //(i == num2) 
		{
			printf("%d = ", i);
		}
		sum+=i;
	}
	printf("%d", sum);
}
