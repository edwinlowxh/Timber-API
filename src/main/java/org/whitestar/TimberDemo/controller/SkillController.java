package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.dto.DTO.SkillDTO;
import org.whitestar.TimberDemo.dto.Mapper.SkillMapperImpl;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.SkillType;
import org.whitestar.TimberDemo.repository.SkillRepository;
import org.whitestar.TimberDemo.repository.SkillTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/skill")
public class SkillController extends BaseController{

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkillTypeRepository skillTypeRepository;

    @Autowired
    SkillMapperImpl skillMapperImpl;

    @GetMapping(produces = "application/json", params = {"id"})
    @ResponseBody
    public ResponseEntity<?> getSkill(@RequestParam("id") String id){
        Optional<Skill> skill;
        skill = skillRepository.findById(id);
        Skill response = this.unwrapOptional(skill);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "all", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllSkill(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(skillRepository.findAll());
    }

    @GetMapping(value = "/bySkillType", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getAllSkillBySkillType(@RequestParam("skillTypeId") String skillTypeId){
        Optional<List<Skill>> skillList;

        Optional<SkillType> result = skillTypeRepository.findById(skillTypeId);

        if (result.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Skill Type does not exist.");
        }

        SkillType skillType = this.unwrapOptional(result);
        skillList = skillRepository.findAllBySkillType(skillType);
        List<Skill> response = this.unwrapOptional(skillList);

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
}
