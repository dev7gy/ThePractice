#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

/*
 *	prices [ 1, 2, 3, 2, 3 ]
 *	return [ 4, 3, 1, 1, 0 ]
 *
 *	1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 *	2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 *	3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 *	4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 *	5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */

// prices_len은 배열 prices의 길이입니다.
int* solution(int prices[], size_t prices_len) {
// return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.		
	int* answer = (int*)malloc(prices_len);
	
	for (int i = (prices_len - 1); i >= 0; i--) {
		*(answer+i) = 0;
		if ( i < prices_len -1 ) {
			*(answer+i) +=1;
		} /*else if ( prices[i] < prices[i+1]) {
			*(answer+i) +=1;
		}*/
	}
	return answer;
}
int main() {
	int prices [] = { 1, 2, 3, 1, 3};
	//int return_n [] = { 4, 2, 1, 1, 0 };
	//int prices [] = {3,1,2};

	int* return_p = solution(prices, 5);
	for(int i =0; i< 5; i++) {
		printf("%d\n", *(return_p + i));
	}
}
