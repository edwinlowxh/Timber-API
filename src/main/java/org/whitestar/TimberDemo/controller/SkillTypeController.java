package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.SkillTypeEntity;
import org.whitestar.TimberDemo.repository.SkillTypeRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/skilltype")
public class SkillTypeController {

    @Autowired
    SkillTypeRepository skillTypeRepository;

    @GetMapping(value = "/skillType/{id}", produces = "application/json")
    @ResponseBody
    public Optional<SkillTypeEntity> getSkillType(@PathVariable String id){
        Optional<SkillTypeEntity> skillType = skillTypeRepository.findById(id);
        return skillType;
    }

    @GetMapping(value = "/skillType/create", produces = "application/json")
    @ResponseBody
    public void createSkillType(){
        SkillTypeEntity skillType = new SkillTypeEntity();
        skillType.setCategory("Technology");
        ArrayList<String> subCategories = new ArrayList<>();
        subCategories.add("Java");
        subCategories.add("PostgreSQL");
        subCategories.add("Python");
        skillType.setSub_categories(subCategories);
        skillTypeRepository.save(skillType);
    }
}
