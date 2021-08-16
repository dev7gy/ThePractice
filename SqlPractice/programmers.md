# programmers - https://programmers.co.kr/learn/challenges
## Mysql
### Select
#### LEVEL 1
- https://programmers.co.kr/learn/courses/30/lessons/59034
```
// order by
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID;
```

- https://programmers.co.kr/learn/courses/30/lessons/59035
```
// order by { } desc
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC;
```

- https://programmers.co.kr/learn/courses/30/lessons/59036
```
// where
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = 'SICK';
``` 

- https://programmers.co.kr/learn/courses/30/lessons/59037#fn1 
```
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS 
WHERE INTAKE_CONDITION != "Aged"
ORDER BY ANIMAL_ID ASC;
```

- https://programmers.co.kr/learn/courses/30/lessons/59403
```
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;
```

- https://programmers.co.kr/learn/courses/30/lessons/59404
```
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS 
ORDER BY NAME ASC, DATETIME DESC;
```

- https://programmers.co.kr/learn/courses/30/lessons/59405
```
SELECT NAME FROM ANIMAL_INS
WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS);
```

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


### SUM, MAX, MIN
### LEVEL 1
- https://programmers.co.kr/learn/courses/30/lessons/59415
```
SELECT MAX(DATETIME) AS DATETIME FROM ANIMAL_INS;
```

- https://programmers.co.kr/learn/courses/30/lessons/59038
```
SELECT MAX(DATETIME) AS DATETIME FROM ANIMAL_INS;
```

- https://programmers.co.kr/learn/courses/30/lessons/59406
```
SELECT COUNT(*) AS count FROM ANIMAL_INS;
SELECT COUNT(ANIMAL_ID) AS count FROM ANIMAL_INS;
```

- https://programmers.co.kr/learn/courses/30/lessons/59408
```
// 중복 제거
SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS;
// 중복 제거, COUNT, SubQuery
SELECT COUNT(P.NAME) FROM 
(
    SELECT * FROM ANIMAL_INS GROUP BY NAME
) AS P;
```

- https://programmers.co.kr/learn/courses/30/lessons/59042
```
SELECT AO.ANIMAL_ID, AO.NAME, AI.ANIMAL_ID FROM ANIMAL_OUTS AS AO
LEFT JOIN ANIMAL_INS AS AI
ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AI.ANIMAL_ID IS NULL
ORDER BY AO.ANIMAL_ID
```
