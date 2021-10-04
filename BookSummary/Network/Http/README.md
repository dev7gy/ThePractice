# HTTP
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
- HTTP 요청 메세지 
```
{
    GET /search?q=hello HTTP/1.1
    HOST: www.google.com
}
```
- HTTP 응답 메세지
```
{
    HTTP/1.1 200 OK
    Content-Type: text/html;charset=UTF-8
    Content-Length: 3423
    
    <html>
        <body></body>
    </html>
}
```