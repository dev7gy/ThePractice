# JavaScript 언어
## Ajax(Asynchronous JavaScript and XML) 
###  - 비동기화 데이터 처리 방식
 ### - 서버에서 모든 데이터를 구성하는 방식 대신에 브라우저가 서버를 호출하고, 데이터를 가져오는 방식으로 사용
 
 ---
 ### 기존 방식
 * Browser <-html-> server <--> storage
 ### Ajax 방식
 * Browser <--> Ajax <-XML, text-> server <--> storage
 #### Ajax 개념 - Ajax in Action 책 참조
 ##### - Ajax가 각광받는 이유
 * 리치 클라이언트: 클라이언트가 서버와 연동할 때 다양한 방법의 기능을 제공하는 클라이언트
 
---
## JS 패러다임 변화
* interpreter == javascript engine
* 브라우저와 서버측 차이는 API의 차이

## 자바스크립트의 언어적인 특징
### 변수에 대한 차이
* 기본 자료형(Primitive Type) & 참조 자료형(Reference Type) - 자바스크립트는 기본 자료형을 자동으로 참조형 변수로 변화시키는 특징 존재

* 변수의 범위 (ex: Hoisting)
  https://velog.io/@bathingape/JavaScript-var-let-const-%EC%B0%A8%EC%9D%B4%EC%A0%90

* 객체에 대한 개념
 일반적으로 객체지향 언어는 3가지 종류로 나누어진다.
  #### - Class Based: JAVA -- Object란 클래스에서부터 생산되는 복사본의 개념 
  #### - ProtoTyped Based: JavaScript 어떤 자료형 자체가 중요하기보다 현재의 객체가 어떤 기능이나 속성이 있는지를 더 중요시한다. 
  #### - Others: 

* 객체란 메모리를 차지하는 모든 것
  var num1 = 10; // 기본 자료형
  num1.doA = 100; // num1이라는 변수가 차지하는 메모리 공간에 doA라는 변수의 참조를 연결하는 형태

* 함수도 객체
  자바스크립트에서 작성되는 함수 역시 동일한 개념으로 특정한 메모리 공간을 차지하기 때문에 하나의 객체라는 개념으로 바라볼 수 있습니다.

* 연산자에 대한 차이
  동등 연산자(Equal ==), 일치 연산자(Strict Equal, ===)

### Function 객체
* 함수 선언과 함수 표현식의 차이
    ``` 
    함수 선언의 경우 자바스크립트가 자바스크립트 엔진에 전달되어서 해석되는 시점에 메모리 공간을 차지하게 됩니다.
    따라서 해석 이후에 실행될 때에는 함수의 위치에 관계없이 호출할 수 있습니다만 함수 표현식을 이용하는 경우는 변수만 선언되고 함수의 할당은 실행 과정에서 이루어지기 때문에 함수 표현식 이전의 코드에서 함수를 호출하게 되면 undefined 인 상태에서 호출이 이루어지므로 에러가 발생하게 됩니다. 
   
    <script>
    doA();
    doB(); // 선언 전에 호출했으므로 undefined 나타냄.
    function doA() {
        console.log('doA');
    }

    var doB = function() {
        console.log('doB');
    };
    </script>
    ```
* 즉시 실행 함수
 변수에 함수를 직접 할당하지 않고, 함수의 결과물을 할당하기 위해서 변수에 바로 즉시 실행 함수를 사용할 때가 있습니다.
 