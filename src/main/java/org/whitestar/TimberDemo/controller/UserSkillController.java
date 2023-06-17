package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.UserSkill;
import org.whitestar.TimberDemo.repository.UserSkillRepository;


import java.util.List;
import java.util.Optional;

public class UserSkillController {
    private final UserSkillRepository userSkillRepository;

    @Autowired
    public UserSkillController(UserSkillRepository userSkillRepository){
        this.userSkillRepository = userSkillRepository;
    }

    @GetMapping(params = {"id"}, produces = "application/json")
    @ResponseBody
    public Optional<UserSkill> getUserSkill(@RequestParam("id") String id){
        return userSkillRepository.findById(id);
    }

    // userSkill body
    record UserSkillRecord(
            String user_id,
            String skill_id,
            int level,
            int levelExperience,
            int currentExperience
    ){}

//    @PostMapping()
//    public void postUserSkill(@RequestBody UserSkillController.UserSkillRecord userSkillRecord){
//        UserSkill userSkill = new UserSkill(userSkillRecord.user_id, userSkillRecord.skill_id);
//        userSkillRepository.save(userSkill);
//    }
//
//    @PutMapping(params = {"id"})
//    public void updateUserSkill(@RequestParam("id") String id, UserSkillController.UserSkillRecord userSkillRecord){
//        UserSkill userSkill = new UserSkill(id, userSkillRecord.user_id, userSkillRecord.skill_id);
//        userSkillRepository.save(userSkill);
//    }

    @GetMapping(value = "/user", params = {"userID"}, produces = "application/json")
    @ResponseBody
    public List<UserSkill> getUserSkills(@RequestParam("id") String userID, UserSkillRepository userSkillRepository){
        return (List<UserSkill>) userSkillRepository.findByUserID(userID);
    }
}
