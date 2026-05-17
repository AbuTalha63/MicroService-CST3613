package edu.citytech.counter.controller;

import io.micronaut.http.annotation.Controller;//contreoller is for changing the uri
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
// import java.util.Date;
import edu.citytech.counter.services.ABCService;//service is for business logic

@Controller("/abc") //abc will get you to here, then the methods below with their uri's will get you to the other data points
public class ABCController {

    @ Inject ABCService service;

    @Get(uri= "upper-vowels")              //default since no uri associated (was before, now uri added: no uri = default)
    public Object dev() {                                       //method name does not matter
        return service.getVowelsUpper();
    }

    @Get(uri="lower-vowels")
    public Object dev2() {
        return service.getVowelsLower();
    }

    @Get(uri="upper-all")
    public Object dev3() {
        return service.getABC();
    }

    @Get(uri="lower-all")
    public Object dev4() {
        return service.getabc();
    }

    @Get(uri="lower-consonants")
    public Object dev5() {
        return service.getConsonantsLower();
    }

    @Get(uri="upper-consonants")
    public Object dev6() {
        return service.getConsonantsUpper();
    }
}
























// Notes:
//seperation of concerns: splitting it all up based on need REMEBER THIS AND GET EXPLANATIONS LATER TO LEARN