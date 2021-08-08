package hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello-string")
    public String hello(Model model) {
        model.addAttribute("data", "helloDATA");
        // view resolver가 화면을 찾아줌.
        // templates 폴더 밑에 hello.html이라는 파일을 열어라.
        return "hello";
    }

}
