package hello.itemservice.service;


import hello.itemservice.domain.Domain;
import hello.itemservice.papagoAPI.JpsEnsApi;
import hello.itemservice.papagoAPI.KrnJpnsApi;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class transService {

    private final KrnJpnsApi krnJpnsApi;
    private final JpsEnsApi jpsEnsApi;

    @Autowired
    public transService(KrnJpnsApi krnJpnsApi,JpsEnsApi jpsEnsApi) {
        this.krnJpnsApi = krnJpnsApi;
        this.jpsEnsApi = jpsEnsApi;
    }

    public String JpTrans(Domain domain) throws ParseException {
    return krnJpnsApi.mainMethod(domain.getLetter());
    }

    public String EnTrans(Domain domain) throws ParseException {
        return jpsEnsApi.mainMethod(domain.getJpLetter());
    }
}
