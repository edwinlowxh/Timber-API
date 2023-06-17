package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.repository.SkillRepository;
import org.whitestar.TimberDemo.repository.UserProfileRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/skill")
public class SkillController {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillController(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    @GetMapping(params = {"userId"}, produces = "application/json")
    @ResponseBody
    public Optional<Skill> getSkill(@RequestParam("userId") String user_id){
        return skillRepository.findById(user_id);
    }
}
