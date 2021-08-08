package hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloGetParam {
    /*
     ResponseBody를 사용하면 viewResolver를 사용하지 않음.
      대신에 HTTP의 Body에 문자 내용을 직접 반환 -> HTML BODY TAG를 말하는 것이 아님.
    */
    @GetMapping("hello-mvc")
    public String helloString(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
