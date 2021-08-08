package servletMVC.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringConfig implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        //System.out.println("onStrartup");
        // Spring MVC 프로젝트 설정을 위한 클래스 책체 생성
        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
        servletAppContext.register(ServletContext.class);

        // 요청 발생시 Dispatcher Servlet으로
        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

        // 부가 설정
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        // Bean을 정의하는 클래스를 지정
        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(RootAppContext.class);
    }
}
