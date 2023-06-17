package org.whitestar.TimberDemo.repository;

import org.whitestar.TimberDemo.entity.User_Skill;

import java.util.HashMap;
import java.util.List;

public class User_SkillRepository {
    public List<User_Skill> getUser_Skills(){
        return List.of(
                new User_Skill(1L,1L,1L)
        );
    }

    public User_Skill getUser_Skill(Long id){
        HashMap<Long,User_Skill> user_skills = new HashMap<>();
        user_skills.put(1L, new User_Skill(1L,1L,1L));
        return user_skills.get(id);
    }
}
