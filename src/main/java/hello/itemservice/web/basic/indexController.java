package hello.itemservice.web.basic;


import hello.itemservice.domain.Domain;
import hello.itemservice.service.transService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {


    private final transService transservice;

    @Autowired
    public indexController(transService transservice) {
        this.transservice = transservice;
    }

    @GetMapping()
    public String index(){
        return "main";
    }

    @PostMapping("/transForm")
    public String transForm(Domain domain) throws ParseException {
        domain.setJpLetter(transservice.JpTrans(domain));
        domain.setEnLetter(transservice.EnTrans(domain));
        return "trans";
    }
    @GetMapping("/board")
    public String board(){
        return "board";
    }

}
