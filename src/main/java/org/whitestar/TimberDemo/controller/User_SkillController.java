package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.User_Skill;
import org.whitestar.TimberDemo.repository.User_SkillRepository;


import java.util.List;
import java.util.Optional;

public class User_SkillController {
    private final User_SkillRepository userSkillRepository;

    @Autowired
    public User_SkillController(User_SkillRepository userSkillRepository){
        this.userSkillRepository = userSkillRepository;
    }

    @GetMapping(params = {"id"}, produces = "application/json")
    @ResponseBody
    public Optional<User_Skill> getUser_Skill(@RequestParam("id") String id){
        return userSkillRepository.findById(id);
    }

    // userSkill body
    record User_SkillRecord(
            String user_id,
            String skill_id,
            int level,
            int levelExperience,
            int currentExperience
    ){}

    @PostMapping()
    public void postUser_Skill(@RequestBody User_SkillController.User_SkillRecord userSkillRecord){
        User_Skill userSkill = new User_Skill(userSkillRecord.user_id, userSkillRecord.skill_id);
        userSkillRepository.save(userSkill);
    }

    @PutMapping(params = {"id"})
    public void updateUser_Skill(@RequestParam("id") String id, User_SkillController.User_SkillRecord userSkillRecord){
        User_Skill userSkill = new User_Skill(id, userSkillRecord.user_id, userSkillRecord.skill_id);
        userSkillRepository.save(userSkill);
    }

    @GetMapping(value = "/user", params = {"userId"}, produces = "application/json")
    @ResponseBody
    public List<User_Skill> getUser_Skills(@RequestParam("id") String userId, User_SkillRepository userSkillRepository){
        return (List<User_Skill>) userSkillRepository.findByUserId(userId);
    }
}
