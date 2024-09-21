package com.springboot.springcoredemo.rest;


import com.springboot.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In Constructor: " + this.getClass().getSimpleName());
        myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " +
                (myCoach == anotherCoach);
    }
}
