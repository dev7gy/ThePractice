# Web Programming 
 - [User] - request -> [Web server] - response -> [User]
 - Protocol: 통신을 하기 위한 규약으로 HTTP, FTP, SMTP, POP등이 있다. 

# IP, Domain, Port
- 서버에 접근 후 많은 프로그램 중에 하나 실행해야 할 프로그램별로  port를 부여

# 웹 프로그램 흐름 
User(Browser) - Request(HTML) -> Web Server - query -> DataBase
User(Browser) <- Response(HTML) - Web Server <- result - DataBase
정적 데이터: html
동적 데이터: Web Container 로 데이터를 만들어서 결국엔 HTML을 리턴하게 됨.

# 웹 컨테이너 구조
 - WAS(Web Application Server) 안에 웹 컨테이너가 존재하여 jsp파일을 obj파일로 변환하는 작업을 거침.
XX.jsp - request ->        [웹 컨테이너 부분 Tomcat]           - response -> html
                    xx_jsp.java -> xx_jsp.class -> xx_jsp.obj