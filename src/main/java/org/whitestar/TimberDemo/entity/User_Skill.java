package org.whitestar.TimberDemo.entity;

import lombok.Data;

@Data
public class User_Skill {
    private Long id;
    private Long user_id;
    private Long skill_id;
    private int level;
    private int levelExperience;
    //accumulated experience for current level
    private int currentExperience;

    public User_Skill(){}

    public User_Skill(Long id, Long user_id, Long skill_id) {
        this.id = id;
        this.user_id = user_id;
        this.skill_id = skill_id;
        this.level = 1;
        this.levelExperience = 100;
        this.currentExperience = 0;
    }

    public User_Skill(Long user_id, Long skill_id) {
        this.user_id = user_id;
        this.skill_id = skill_id;
        this.level = 1;
        this.levelExperience = 100;
        this.currentExperience = 0;
    }
}