# [HTTP 강의](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard) 정리
## 인터넷 네트워크
### 1. 인터넷 통신 
클라이언트 - 인터넷 - 서버

### 2. IP(Internet protocol)
- 지정한 IP 주소로 데이터 전달
- 패킷 단위로 데이터 전달
- 패킷 구성
```
IP packet
{
    출발지 IP: 100.100.100.1
    목적지 IP: 200.200.200.2
    메세지: Hello, World
}
```
- 한계
    - 비연결성: 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
    - 비신뢰성: 패킷이 사라지거나 순서대로 오지 않는 경우
    - 동일한 IP를 사용하는 서버에서 통신하는 APP이 2이상이면 IP만으로는 해결 불가능

### 3. TCP-UDP
- Internet Protocol 스택 4계층

|계층||
|-|-|
|애플리케이션 계층|HTTP, FTP|
|전송 계층|TCP, UDP|
|인터넷 계층|IP|
|네트워크 인터페이스 계층||


```
Ethernet frame
{ 네트워크 물리적인 정보
    IP
    { 출발지 IP, 도착지 IP
        TCP
        { 출발지 Port, 도착지 Port, 전송제어, 
        순서, 검증 정보
            HTTP{}
        }
    }
}
```

- TCP (Transmission Control Protocol)
    - 연결지향 - 3way handshake : client_syn -> server_syn_ack -> client_ack
    - 데이터 전달 보증
    - 순서 보장

- UDP (User Datagram Protocl)
    - 데이터 전달 및 순서가 보장되진 않지만 , 빠름
    - PORT, 체크섬 기능 제공

### 4. PORT
- 같은 IP내에서 프로세스를 구분하게 함.
    - 0 ~ 1023는 이미 잘 알려진 포트이므로 사용하지 않는 것이 좋음.
    - FTP: 20, 21
    - TELNET: 23
    - HTTP: 80
    - HTTPS: 443

### 5. DNS(Domain Name System)
- 도메인 명: IP주소
    - ex) google.com : 8.8.8.8

## URI와 웹 브라우저 요청 흐름
### 1. URI(Uniform Resource Identifier)
- URI > URL(Locator) + URN(Name)
- URL 문법

    |https|www.google.com|:443|/search|?q=hello|
    |-|-|-|-|-|
    |프로토콜|호스트명|포트번호|패스|쿼리 파라미터|


### 2. 웹 브라우저 요청 흐름
- Web Browser - Http 요청 메세지 생성 - SOCKET 라이브러리를 통해 전달 - TCP/IP 패킷 생성, HTTP메시지 포함 - 네트워크 인터페이스를 통과 - 인터넷을 통해 서버로 전달

## HTTP(HyperText Transfer Protocol)
### 1. 기본 
- 기반 프로토콜
    - TCP: HTTP/1.1, HTTP/2
    - UDP: HTTP/3
- 특징
    - 클라이언트-서버 구조, Request-Response 구조
    - 무상태 프로토콜(Stateless), 
        - 서버가 클라이언트의 상태를 보존X
        - 장점: 서버 확장성 높음
        - 단점: 클라이언트가 추가 데이터 전송
            ```
            !중요! Stateful, Stateless 차이
            - Stateful: 중간에 다른 점원으로 바뀌면 안된다.
            - Stateless: 클라이언트에서 요청할 때 필요한 모든 정보를 담아서 요청하기 때문에 다른 점원으로 바뀌어도 된다. -> 서버를 쉽게 증설 가능하다 
            - 모든 것을 무상태로 설계할 수 있는 경우도 있고 없는 경우도 있다. ex) 로그인
            ```
    - 비연결성(Connectionless)
        - 장점: 연결을 유지하지 않기 때문에 최소한의 자원 사용
        - 단점: TCP/IP 연결을 새로 맺음(3 Way HandShake), HTTP 지속 연결을 통해 해결
    - HTTP 메시지
        - HTTP헤더: HTTP 전송에 필요한 모든 부가 정보, 메타 데이터 정보
        - HTTP 메시지 바디: 실제 전송할 데이터
        - HTTP 요청 메세지 
            ```
            {
                GET /search?q=hello HTTP/1.1
                HOST: www.google.com
                // 필수 공백
            }
            {
                start-line = request-line / status-line
                request-line = 메서드 + request-target(절대 경로) + HTTP 버젼
                header-field = field-name: + field-value
            }
            ```
                       
        - HTTP 응답 메세지
            ```
            {
                HTTP/1.1 200 OK
                Content-Type: text/html;charset=UTF-8
                Content-Length: 3423
                // 필수 공백
                <html>
                    <body></body>
                </html>
            }
            {
               start-line = request-line / status-line
               status-line = HTTP버젼 + 상태코드 + reason-phrase 
               header-field = field-name: + field-value
            }
            ```
    - 단순하고 확장 가능함.

### 2. HTTP 메서드

- API 설계에서 가장 중요한 것
    - 리소스 식별
    - ex) 회원 조회, 등록, 삭제 기능에서 리소스는 "회원"이다.
    - 리소스와 행위를 분리
    - 행위 = HTTP 메서드
        - GET: 리소스 조회
        - POST: 요청 데이터 처리, 주로 등록에 사용
            - 메시지 바디를 통해 서버로 요청 데이터 전달 후 서버는 요청 데이터를 처리함.
            - 컨트롤 URI를 사용해서 설계
        - PUT: 리소스를 대체(덮어쓰기), !중요! 클라이언트가 특정 리소스를 지정해서 통째로 대체할 때만 사용해야 함.
        - PATCH: 리소스 부분 변경
        - DELETE: 리소스 삭제
        - HEAD, OPTIONS, CONNECT, TRACE 등이 있음.
- 속성
    - 안전(Safe Methods): 호출시 리소스를 변경하지 않음.
    - 멱등(Idempotent Methods): 몇번을 중복해서 호출하더라도 최종 결과가 같음.
        - POST는 멱등이 아니다.
    - 캐시가능(Cacheable Methods): 응답 결과 리소스를 캐시해서 사용 가능 여부, GET과 HEAD에서 주로 사용

- 활용
    - 데이터 전달 방식에 따른 분류
        - 쿼리 파라미터를 통한 전송: GET
        - 메시지 바디를 통한 데이터 전송: POST, PUT, PATCH
    - 데이터 유형에 따른 분류
        - 정적 데이터 조회
        - 동적 데이터 조회
        - HTML Form을 통한 데이터 전송, !중요! get-post만 가능
            - 사용 Content-Type: application/x-www-form-urlencoded, key:value형태의 값
            - 사용 Content-Type: multipart/form-data, 파일 전송시
        - HTTP Api를 통한 데이터 전송
            - 사용 Content-Type: application/json을 주로 사용

### 3. HTTP API 설계 방법 [HTTP API 설계 예시](https://restfulapi.net/resource-naming/) 
- !중요! 리소스 식별이 최고 핵심.
- !중요! Post-Put-Patch 차이 구분
    - Post(예시 회원 관리 시스템)
        - 클라이언트는 리소스의 !URI를 알지 못하고 등록하고 싶은 데이터만! 서버에게 준다. /members
        - 서버가 새로 등록되는 리소스의 URI를 생성한다.
        - Collection이란?
            - 서버가 관리하는 리소스 디렉토리
            - 서버가 리소스의 URI를 생성하고 관리하는 것(/members)

    - Put(예시 파일 관리 시스템)
        - 클라이언트는 !리소스의 URI를 직접 생성해서! 서버에 요청한다. /files/파일명.txt
        - Store란?
            - 클라이언트가 관리하는 리소스 저장소
            - 클라이언트가 리소스의 URI를 생성하고 관리하는 것(/files)
    - Patch

- !중요! HTML FORM 사용 방식
    - GET, POST만 지원한다. 
    - DELETE는 사용할 수 없다. -> 컨트롤 URI를 사용할 수 밖에 없다. /members/{id}/delete
    - /new, /edit, /delete 등 액션을 컨트롤 URI라고 한다. !그래도 리소스 중심 설계가 제일 중요하다.!

- 참고용 API 설계 개념
    - 문서(document): 단일 개념
    - 컬렉션: 서버가 관리하는 것
    - 스토어: 클라이언트가 관리하는 것
    - 컨트롤러: 위 3가지 경우로 대체하기 불가능한 경우 - 동사 키워드를 사용

### 4. HTTP 상태 코드
- 1XX: 요청이 수신되어 처리중
- 2XX: 요청 정상 처리
- 3XX: Redirection
    - Redirection: 웹 브라우저에서 3XX 응답 결과에 Location 헤더가 있으면 Location 위치로 자동 이동하는 것.
    - 브라우저를 통해 클라이언트에서 /old-resource 요청 -> 서버에서 301 상태 코드와 함께 Location: /new-resource 응답 -> 브라우저에서 자동으로 /new-resource 요청 -> 서버에서 200응답.
    - 종류
        - 영구 Redirection(301, 308): 경로가 완전히 바뀌었다.
            - 301: HTTP메서드랑(Post -> Get) 메시지도 제거될 수 있음(주로 사용)
            - 308: HTTP매서드 유지, 메시지도 유지
        - 일시 Redirection(302, 307, 303)
            - 302: Found(Post -> Get), 메시지 제거될 수 있음
            - 307: Temporary Redirect, HTTP 메서드, 메시지 유지
            - 303: See Other, (Post -> Get)
            - !중요 예시! Post/Redirect/Get 패턴
            ```
            /*
             Post로 Resource 등록 후 웹 브라우저를 새로고침 한다면?
             중복 등록이 될 수 있다.
            */
            Post로 등록 후 -> redirection -> get으로 등록 완료 화면으로 이동
            ```

        - 특수 Redirection(303, 304)
            - 304: 로컬 캐시를 사용하는 경우

- 4XX: Client Error: 재시도해도 항상 실패.
    - 401: 인증(로그인 문제)
    - 403: Fobidden - 인가(접근 권한 문제)
    - 404: resource 없음.

- 5XX: Server Error: 재시도하면 서버 복구 완료시 성공할 가능성이 있음.
    - 500
    - 503: 서비스 이용 불가

### 5. HTTP 헤더
- RFC723X 표준
{
    Representation 헤더: 표현 데이터를 해석할 수 있는 정보 제공
    message body{ Representation 데이터 }
    // message body == payload
    // resource -> Representation이라고 명명하는 시점
}
- Representation Header
    - Content-Type: text/html, application/json, image/jpeg
    - Content-Encoding: gzip, deflate, indentity
    - Content-Language: charset=UTF-8
    - Content-Length: 바이트 단위, Transfer-Encoding을 사용할 땐 사용하면 안됨.

- Contents negotiation
    - 클라이언트가 선호하는 표현 요청
        - Accept: 클라이언트에서 선호하는 미디어 타입 전달
        - Accept-Charset
        - Accept-Encoding
        - Accept-Language
    - 우선순위 예시
        - Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
        - Accept: text/*,text/plin,text/plain;format=flowed,*/*

- 전송 방식
    - 단순 전송: content-length 기반으로 전송.
    - 압축 전송: content-encoding도 추가해서 전송.
    - 분할 전송: !중요! content-length를 제외해야 함. transfer-encoding: chunked 같은 방식으로 사용
    - 범위 전송: bytes 1001-2000/ 2000

- 일반 정보
    - from: 유저 에이전트의 이메일 정보
    - referer: 현재 요청한 페이지 기준으로 이전 웹페이지 주소(유입 경로 분석에 사용), referrer의 오타지만 사용
    - user-agent: 유저 에이전트 애플리케이션 정보, 웹 브라우저 정보
    - server: 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보- 중간에 거치게 되는 cache서버, proxy서버가 아니라 실제 요청이 있는 서버
    - date: 메시지가 발생한 날짜와 시간

- 특별한 정보
    - Host: !필수값! 요청한 호스트 정보
    - Location: 3XX 응답의 결과에 Location이 있으면 자동으로 redirect
    - Allow: 허용 가능한 HTTP 메서드를 알려주는 정보
    - Retry-After: 503 응답과 함께 사용해서 언제 서비스가 사용 가능한지 알려주는 정보

- 인증 관련 헤더
    - Authorization

- 쿠키 헤더
    - Set-Cookie: 서버에서 클라이언트에 응답
    - Cookie: 클라이언트가 서버에서 받은 쿠키를 저장, HTTP요청시 서버로 전달
    ```
    1. 쿠키를 사용하지 않으면 클라이언트에서 서버에 데이터 요청할 때마다 사용자 정보를 전달해야함.
    2. 서버에서 응답할 때 set-cookie라는 헤더를 이용해서 클라이언트의 쿠키 저장소에 사용자 정보를 저장함.
    3. 이후 클라이언트가 요청시 자동으로 쿠키 저장소에 있는 정보를 Cookie헤더에 담아서 요청함.
    4. 그렇기 때문에 쿠키에 보안상 민감한 정보는 절대 저장하면 안됨.
    ```
    - 쿠키 생명주기
        - Set-Cookie: expire=Sat, 26-Jan...., 만료일이 되면 쿠키 삭제
        - Set-Cookie: max-age=3600, 3600초 지나면 쿠키 삭제
        - 세션쿠키: 만료 날짜 생략하면 브라우저 종료 기준으로 쿠키 삭제
        - 영속 쿠키: 입력된 만료 날짜까지 유지
    - 쿠키 도메인
        - 명시: 서브 도메인도 적용
        - 생략: 현재 도메인만 적용
        ```
        domain=dev7gy.com
        명시: test.dev7gy.com쿠키 접근 가능
        생략: test.dev7gy.com쿠키 접근 불가능
        ```
    - 쿠키 경로
        - path=/test, /test/xxx/... 등 접근 가능
    - 쿠키 보안
        - Secure: https에만 전송
        - HttpOnly: XSS공격 방지, 자바스크립트에서 접근 불가
        - SameSite: CSRF공격 방지
