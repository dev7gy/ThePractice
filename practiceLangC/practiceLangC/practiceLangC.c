
#include <stdio.h>
/*
* register <-> memory
* 32bit - E가 붙음
* 범용 레지스터[A-D]
*	- EAX, EBX, ECX, EDX
* 주소지정 레지스터
*	- ESI, EDI
* Flags Register
*	- EFLAGS
* 프로그램 카운터
*	- EIP
* 스택 포인터
*	- ESP
* 스택 프레임 베이스 포인터
*	- EBP
*/
/* 
When we store the address of a vaiable i in the pointer variable p, we say that p "points to" i.
In other words, a pointer is nothing more than an adderss, and a pointer variable is just a variable that can store an address.

p might point to and area of memory that doesn't belong to a variable.
*/
int child(int num) 
{
	return num;
}

int parentA(int (*inputA)(int)) 
{
	int outputA = inputA;
	return outputA;
}

int parentB(int inputB)
{
	return inputB;
}

int main()
{
	int input = 3;
	int a = parentA(child(input));
	int b = parentB(child(input));
	return 0;
}