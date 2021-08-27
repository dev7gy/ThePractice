# Coding Interview

## DataStructure
### ADT(Abstract Data Type)
- 추상 자료형
```
구체적인 기능의 완성과정을 언급하지 않고, 순수하게 기능이 무엇인지 나열한 것. 
출처: 윤성우의 열혈 자료구조.
```
### - SequentailList
#### List의 특성
- 데이터를 나란히 저장한다. 중복되는 데이터를 허용한다. 

#### SequentailList의 ADT - 특성을 기반으로 제공해야 할 기능
```
void ListInit();
void Insert(Data data);
Data Search(Data data);
Data Remove(Data data);
```
||평균||
|----|----|---|
|검색|삽입|삭제|
|O(N)|O(N)|O(N)|

### - LinkedList
#### List의 특성
- 데이터를 나란히 저장한다. 중복되는 데이터를 허용한다. 

||평균||
|----|----|---|
|검색|삽입|삭제|
|O(N)|O(1)|O(1)|


### - Stack
#### stack의 특성
- LIFO: Last In First Out

#### stack의 ADT
```
void StackInit();
boolean IsEmpty;
void Push(Data data);
Data Pop();
Data Peek(); // 마지막 요소를 반환하지만 삭제하지 않는다.
```
||평균||
|----|----|---|
|검색|삽입|삭제|
|O(N)|O(1)|O(1)|

### - Queue
#### queue 특성
- FIFO: First In First Out
#### queue의 ADT
```
void QueueInit();
boolean IsEmpty;
void Enqueue();
Data Dequeue();
```
||평균||
|----|----|---|
|검색|삽입|삭제|
|O(N)|O(1)|O(1)|

### - Hash Table
### - Tree
### - Graph
---
## Algorithm
## P 분류(class) - NP 분류(class)
- P분류: 판정 문제들을 분류하는 방법
```
판정문제: 입력 값에 대해 예/아니오 답을 내릴 수 있는 문제
결정론적 튜링 기계에서 다항식 시간 안에 풀 수 있는 모든 문제를 포함.
```
## - sort
 - selection sort
## - search
 - Binary Search 
 ```
 정렬된 배열에서 중간값과 비교하여 찾고자 하는 값을 찾는 알고리즘.
 log N
 ```
---
