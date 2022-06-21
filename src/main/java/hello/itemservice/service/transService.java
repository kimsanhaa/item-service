package hello.itemservice.service;


import hello.itemservice.domain.Domain;
import hello.itemservice.papagoAPI.KrnJpnsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class transService {

    private final KrnJpnsApi krnJpnsApi;

    @Autowired
    public transService(KrnJpnsApi krnJpnsApi) {
        this.krnJpnsApi = krnJpnsApi;
    }

    public String trans(Domain domain){
    return krnJpnsApi.mainMethod(domain.getLetter());
    }
}
