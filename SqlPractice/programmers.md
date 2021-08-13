# programmers - https://programmers.co.kr/learn/challenges
## Mysql

### IS NULL
#### LEVEL 1
- https://programmers.co.kr/learn/courses/30/lessons/59039
```
// if (name == null) && 오름차순
SELECT ANIMAL_ID FROM ANIMAL_INS 
WHERE NAME IS NULL
ORDER BY ANIMAL_ID ASC;
```


- https://programmers.co.kr/learn/courses/30/lessons/59407
```
SELECT ANIMAL_ID FROM ANIMAL_INS 
WHERE NAME is not null
ORDER BY ANIMAL_ID ASC;
```

#### LEVEL 2
- https://programmers.co.kr/learn/courses/30/lessons/59410
```
// ifnull (data1, data2) -> null이면 data2를 출력, 아니면 data1출력
SELECT ANIMAL_TYPE, ifnull(name, 'No name') as NAME, SEX_UPON_INTAKE 
FROM ANIMAL_INS
```
