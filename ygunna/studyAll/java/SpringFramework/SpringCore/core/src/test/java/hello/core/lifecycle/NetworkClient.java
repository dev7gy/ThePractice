package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    /**
     * 설정 정보 사용 특징
     * 메서드 이름을 자유롭게 줄 수 있다.
     * 스프링 빈이 스프링 코드에 의존하지 않는다.
     * 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드
     * 를 적용할 수 있다.
     *
     */
    // 초기화
    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    // 종료 - 대부분 close나 shutdown으로 종료를 사용하기 때문에 추론이 되게 들어가져 있다. (inferred)
    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
