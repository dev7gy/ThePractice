package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // Model -> spring에서 사용하는 클래스, 담아서 뷰에다가 데이터를 넘길 수 있다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        // 화면 이름, resource/templates/hello.html 관례
        // 정적 컨텐츠는 resource/static에 위치시키고
        // 렌더링 컨텐츠는 resource/templates에 위치시키다.
        return "hello";
    }
}
