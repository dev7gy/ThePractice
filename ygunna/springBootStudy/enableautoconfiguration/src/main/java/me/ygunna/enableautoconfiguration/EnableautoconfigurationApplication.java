package me.ygunna.enableautoconfiguration;

import javafx.application.Application;
import me.ygunna.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnableautoconfigurationApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EnableautoconfigurationApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
        //SpringApplication.run(EnableautoconfigurationApplication.class, args);
    }

    //autoconfiguration에 있는데도 불구하고 추가로 holoman bean을 등록
    /*
    2.1.17에서는 알아서 에러 잡아줌 -> 2.0.3이어야함
    The bean 'holoman', defined in class path resource [me/ygunna/HolomanConfiguration.class], could not be registered.
    A bean with that name has already been defined in me.ygunna.enableautoconfiguration.EnableautoconfigurationApplication
    and overriding is disabled.
     */
    /* component scan이 autoconfiguration보다 우선시 되게는 했는데... 이걸 매번 이렇게 해줘야하는가...
    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("ygunna");
        holoman.setHowLong(60);
        return  holoman;
    }
    그렇게 안하고 application context에다가 해버리자 -> application.properties파일에 하기
    */


}
