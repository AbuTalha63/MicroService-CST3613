package edu.citytech.counter.controller;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import io.micronaut.http.annotation.Controller;         //Controller is for changing the uri
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import edu.citytech.counter.services.ABCService;        //Service is for business logic

@Controller("/abc")
public class ABCController {

    @Inject ABCService service;

    @Get(value = "/letters/{mode}")
    public Object getData( String mode ) {
        return service.getData(mode);
    }
}



//Seperation of concerns:
//Splitting it all up based on need; ABCController has the uri direction logic, while ABCService has all the "business" logic