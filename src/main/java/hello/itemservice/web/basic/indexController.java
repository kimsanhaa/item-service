package hello.itemservice.web.basic;


import hello.itemservice.domain.Domain;
import hello.itemservice.domain.NaverDomain;
import hello.itemservice.service.transService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {


    private final transService transservice;


    @Autowired
    public indexController(transService transservice ) {

        this.transservice = transservice;
    }

    @GetMapping()
    public String index(){
        return "main";
    }

    @GetMapping("/transForm")
    @ResponseBody
    public Domain transForm(@RequestParam("data") String data, Domain domain) throws ParseException {
        System.out.println(data);
        String jp = transservice.JpTrans(data);
        domain.setJpLetter(jp);
        domain.setEnLetter(transservice.EnTrans(jp));


        System.out.println(domain.getJpLetter());
        System.out.println(domain.getEnLetter());

        return domain;
    }

    @GetMapping("/board")
    public String board(){
        return "board";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/callback")
    public String callback(){
        return "callback";
    }

    @PostMapping("/login")
    public NaverDomain loginChk(@RequestParam String email, String token, NaverDomain naverDomain){
        System.out.println("Post login controller 실행완료");
        //db와 연동해서 확인하는 로직 있어야함
        //로그인 성공하면 check = true; 아니면 false
        boolean  check = true;
        if(check){
            System.out.println("check");
            naverDomain.setEmail(email);
            naverDomain.setToken(token);
            System.out.println(naverDomain);
        return naverDomain;
        }

        return naverDomain;
    }

}
