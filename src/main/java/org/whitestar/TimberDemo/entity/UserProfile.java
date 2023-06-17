package org.whitestar.TimberDemo.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserProfile {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDate dob;
    private int level;
    private int bounties;
    //experience required to level up for current level
    private int levelExperience;
    //accumulated experience for current level
    private int currentExperience;


    public UserProfile() {}

    public UserProfile(Long id, String name, Integer age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.level = 1;
        this.bounties = 0;
        this.levelExperience = 100;
        this.currentExperience = 20;
    }

    public UserProfile(String name, Integer age, String email, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.level = 1;
        this.bounties = 0;
        this.levelExperience = 100;
        this.currentExperience = 20;
    }
}