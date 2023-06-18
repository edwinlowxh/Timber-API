package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.dto.DTO.UserSkillDTO;
import org.whitestar.TimberDemo.dto.Mapper.UserSkillMapper;
import org.whitestar.TimberDemo.dto.Mapper.UserSkillMapperImpl;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.SkillType;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.entity.UserSkill;
import org.whitestar.TimberDemo.repository.UserProfileRepository;
import org.whitestar.TimberDemo.repository.UserSkillRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/userSkill")
public class UserSkillController extends BaseController{
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Autowired
    UserSkillMapperImpl userSkillMapperImpl;

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping(params = {"id"}, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUserSkill(@RequestParam("id") String id){
        Optional<UserSkill> userSkill;
        userSkill = userSkillRepository.findById(id);

        UserSkill response = this.unwrapOptional(userSkill);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/allByUser", params = {"userId"}, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUserSkillsByUser(@RequestParam("userId") String userId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userSkillRepository.findAllByUserId(userId));
    }

    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> updateUserSkills(@RequestBody UserSkillDTO userSkillDTO){
        UserSkill userSkill = userSkillMapperImpl.userSkillDTOToUserSkill(userSkillDTO);
        Skill skill = userSkill.getSkill();

        if (skill == null || !userProfileRepository.existsById(userSkill.getUserId())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Check request body");
        }

        UserSkill existing = this.unwrapOptional(userSkillRepository.findByUserIdAndSkill(userSkill.getUserId(), skill));

        if (existing != null){
            userSkill.setId(existing.getId());
        }

        userSkillRepository.save(userSkill);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userSkill);
    }

    @DeleteMapping(value = "/delete", params = "id", produces = "application/json")
    public ResponseEntity<?> deleteUserSkill(@RequestParam("id") String id){
        userSkillRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted");
    }
}
