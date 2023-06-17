package org.whitestar.TimberDemo.repository;

import org.whitestar.TimberDemo.entity.User_Skill;

import java.util.HashMap;
import java.util.List;

public class User_SkillRepository {
    public List<User_Skill> getUser_Skills(){
        return List.of(
                new User_Skill("1","1","1")
        );
    }

    public User_Skill getUser_Skill(Long id){
        HashMap<String,User_Skill> user_skills = new HashMap<>();
        user_skills.put("1", new User_Skill("1","1","1"));
        return user_skills.get(id);
    }
}
