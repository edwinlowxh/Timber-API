package org.whitestar.TimberDemo.repository;

import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.Skill;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

@Repository
public class SkillRepository {
    public List<Skill> getSkills(){
        return List.of(
                new Skill(1L,"Spring","Technology")
        );
    }

    public Skill getSkill(Long id){
        HashMap<Long,Skill> skills = new HashMap<>();
        skills.put(1L, new Skill(1L,"Spring","Technology"));
        return skills.get(id);
    }
}
