# OOP 정리
## OOP는 재사용성
## 4대 개념
### 추상화
### 상속
- 상속: is-a -> The lion is a animal.
```
class Lion extends Animal{}
class Tiger extends Animal{}

Lion lionA = new Lion();
Tiger tigerA = new Tiger();
Animal animalA = lionA;
Animal animalB = tigerA;
// 오류가 없는 이유 Tiger랑 Lion은 결국 Animal 이기 때문.
```
- 컴포지션: has-a -> The lion has a mouth.

### 캡슐화
### 다형성
- 인터페이스: 순수 추상 클래스
