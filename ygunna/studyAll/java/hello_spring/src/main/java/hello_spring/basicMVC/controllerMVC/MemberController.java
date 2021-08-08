package hello_spring.basicMVC.controllerMVC;

import hello_spring.basicMVC.domain.Member;
import hello_spring.basicMVC.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * @ResponseBody 어노테이션을 사용하지 않았으니
     * view resolver가 동작해서 mvc/home.html을 찾게 됨.
     * @return
     */
    private final String mvcFolder = "mvc/";
    @GetMapping("/")
    public String home() {
        return mvcFolder + "home";
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return mvcFolder + "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        // 등록이 끝나면 home화면으로 돌려보내기
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return mvcFolder + "members/memberList";

    }
}
