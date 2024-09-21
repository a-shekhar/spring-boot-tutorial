package com.springboot.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim in the pool for 10 minutes";
    }
}
