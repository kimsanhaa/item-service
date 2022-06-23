package hello.itemservice.web.basic;


import hello.itemservice.domain.Domain;
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

    @GetMapping("/t")
    public String qnaBoard(){
        return "QnA";
    }

}
