package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.SkillType;
import org.whitestar.TimberDemo.repository.SkillTypeRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/skillType")
public class SkillTypeController {

    @Autowired
    SkillTypeRepository skillTypeRepository;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getSkillType(@RequestParam("id") String id){
        Optional<SkillType> skillType;
        skillType = skillTypeRepository.findById(id);

        SkillType response = this.unwrapOptional(skillType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping(value = "/createSkillType", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> createSkillType(@RequestBody SkillType skillType){
        try{
            skillTypeRepository.save(skillType);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to save to database");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(skillType);
    }

    <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
