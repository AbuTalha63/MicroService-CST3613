package edu.citytech.counter.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.Date;

import edu.citytech.counter.dto.Developer;

@Controller()
public class DeveloperController {
    
    @Get()
    public String developer() { 
        return "Usman Muhammad " + new Date() ;
    }


    @Get(uri = "developer")
    @Produces(MediaType.APPLICATION_JSON)     
        public Object detailDeveloper() {

            String name = "Muhammad Usman";
            String[] skills = {"Java", "SQL", "Git", 
                "Communication", "Public Speaking",
                "Teaching", "Quran memorization", "GitHub",
                "XML", "HTML/CSS"};
            float yearsOfExperience = 0.5f;
            var developer = new Developer(name, skills, yearsOfExperience); 
            return developer;
        }
        // left off 19 microservices video: 036 minute: 10:00
    

}