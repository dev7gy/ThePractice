
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
	/*
	30: int parentA(int (*inputA)(int)) 
    31: {
00561850 55                   push        ebp  
00561851 8B EC                mov         ebp,esp  
00561853 81 EC CC 00 00 00    sub         esp,0CCh  
00561859 53                   push        ebx  
0056185A 56                   push        esi  
0056185B 57                   push        edi  
0056185C 8D 7D F4             lea         edi,[ebp-0Ch]  
0056185F B9 03 00 00 00       mov         ecx,3  
00561864 B8 CC CC CC CC       mov         eax,0CCCCCCCCh  
00561869 F3 AB                rep stos    dword ptr es:[edi]  
0056186B B9 03 C0 56 00       mov         ecx,offset _3956B57D_practiceLangC@c (056C003h)  
00561870 E8 9C FA FF FF       call        @__CheckForDebuggerJustMyCode@4 (0561311h)  
    32: 	int outputA = inputA;
00561875 8B 45 08             mov         eax,dword ptr [inputA]  
00561878 89 45 F8             mov         dword ptr [outputA],eax  
    33: 	return outputA;
0056187B 8B 45 F8             mov         eax,dword ptr [outputA]  
    34: }
	*/
	return outputA;
}

int parentB(int inputB)
{
	/*
	58: int parentB(int inputB)
    59: {
002F18B0 55                   push        ebp  
002F18B1 8B EC                mov         ebp,esp  
002F18B3 81 EC C0 00 00 00    sub         esp,0C0h  
002F18B9 53                   push        ebx  
002F18BA 56                   push        esi  
002F18BB 57                   push        edi  
002F18BC 8B FD                mov         edi,ebp  
002F18BE 33 C9                xor         ecx,ecx  
002F18C0 B8 CC CC CC CC       mov         eax,0CCCCCCCCh  
002F18C5 F3 AB                rep stos    dword ptr es:[edi]  
002F18C7 B9 03 C0 2F 00       mov         ecx,offset _3956B57D_practiceLangC@c (02FC003h)  
002F18CC E8 40 FA FF FF       call        @__CheckForDebuggerJustMyCode@4 (02F1311h)  
    60: 	return inputB;
002F18D1 8B 45 08             mov         eax,dword ptr [inputB]  
    61: }
	*/
	return inputB;
}

int main()
{
	int input = 3;
	int a = parentA(child(input));
	int b = parentB(child(input));
	return 0;
}