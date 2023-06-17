package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.dto.DTO.SkillDTO;
import org.whitestar.TimberDemo.dto.Mapper.SkillMapperImpl;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.repository.SkillRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/skill")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkillMapperImpl skillMapperImpl;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getSkill(@RequestParam("id") String id){
        Optional<Skill> skill;
        skill = skillRepository.findById(id);
        Skill response = this.unwrapOptional(skill);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping(value = "/createSkill", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> createSkill(@RequestBody SkillDTO skillDTO){
        Skill skill = null;
        try{
            skill = skillMapperImpl.skillDTOToSkill(skillDTO);

            if (skill.getSkillType() == null){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Unknown Skill Type");
            }
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Check request body");
        }

        try{
            skillRepository.save(skill);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to save to database");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(skill);
    }

    <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
