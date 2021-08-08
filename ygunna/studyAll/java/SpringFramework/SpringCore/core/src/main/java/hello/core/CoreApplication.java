package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 역할과 구현을 분리 
 - 회원 저장소 역할  2개 중 하나 선택할 수 있음.
	> 메모리 회원 저장소
	> DB 회원 저장소

다형성만으로는 DIP, OCP 를 못 지키는구나
*/
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
