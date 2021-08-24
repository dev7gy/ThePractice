# Chapter1 알고리즘의 소개
## 1-1. binary search
```
    log n, 정렬된 데이터에 대해서 사용 가능.
```

## 1-2. Big O
- 알고리즘의 속도는 시간이 아니라 연산 횟수가 어떻게 증가하는지로 측정합니다.
- 이렇게 하면 입력 데이터의 크기가 늘어날 때 알고리즘의 실행 속도가 얼마나 증가하는지 알 수 있습니다.
- 알고리즘의 실행 시간은 빅오 표기법을 나타냅니다.

```
    log n < n < n * log n < n^2 < n!
```

## 1-Practice (p23)
- 1-1. 128 List -> binary_search -> 2^7 = 128 따라서 7

- 1-2. 2배니까 2^8 따라서 8

- 1-3. 이름을 알고 있을 경우 이진 탐색을 통해 O(log n)

- 1-4. 전화번호만 아는 경우에는 색인 방법이 없으니 O(n)

- 1-5. 모든 사람의 전화번호를 알고 싶다 O(n)

- 1-6. 알파벳 A로 시작하는 사람들의 전화번호를 알고 싶습니다. -> hash map을 사용?

# Chapter2 선택 정렬
## 2-1. 배열과 리스트
### 배열 - 임의 접근이 가능
- 장점
```
배열 안의 어떤 원소든 바로 찾을 수 있다.
```
- 단점
```
배열은 사용할 데이터의 수만큼 미리 할당해야 함.
```

### 리스트 - 순차 접근만 가능
- 장점
```
사용할 데이터가 늘어들고 줄어들 떄 낭비 없이 할당 가능
```
- 단점
```
리스트의 데이터를 읽으려면 순서대로 탐색해야 데이터를 읽어올 수 있다.
```

### 배열- 리스트 비교

| |배열 |리스트|
|:---|:---|:---|
|읽기|O(1)|O(n)|
|삽입|O(n)|O(1)|
|삭제|O(n)|O(1)|

## 2-2. 선택 정렬
- 조건에 부합하는 하나를 선택해서 다른 배열에 차례대로 넣는 작업.

```
전체 목록 중 조건에 부합하는 하나를 선택한다. -> 전체 목록을 한번 훑어야 한다. O(n)

다른 배열에 순차적으로 넣어야 한다. ( n번 )

O(n) 을 n회 반복해야 한다. -> O(n^2)
```

## 2-Practice.
- 2-1. 자료를 읽는 것보다 삽입하는 일이 많음 -> 리스트를 사용

- 2-2. 큐를 만들땐 리스트를 사용하는 것이 더 좋다.

- 2-3. 임의 접근 -> 배열

- 2-4. 새로운 사용자를 등록하면 배열이기 때문에 데이터를 순서에 따라 밀고 나서 데이터를 넣어야합니다.

- 2-5. 검색시 삽입시 복합 자료구조가 더 빠르다.