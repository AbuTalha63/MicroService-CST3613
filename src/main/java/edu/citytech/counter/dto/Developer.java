package edu.citytech.counter.dto;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
public class Developer {

    private String name;
    private String[] skills;
    private float yearsOfExperience;

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public Developer(String name, String[] skills, float yearsOfExperience) {
        this.name = name;
        this.skills = skills;
        this.yearsOfExperience = yearsOfExperience;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getSkills() {
        return skills;
    }
    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}