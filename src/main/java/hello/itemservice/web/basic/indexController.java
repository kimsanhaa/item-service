package hello.itemservice.web.basic;


import hello.itemservice.domain.Domain;
import hello.itemservice.service.transService;
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
        return "basic/main";
    }

    @PostMapping("/transForm")
    public String transForm(Domain domain){
        transservice.trans(domain);
        domain.setTransLetter("번역완료!");
        return "basic/trans";
    }

}
