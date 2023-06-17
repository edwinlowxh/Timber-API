package org.whitestar.TimberDemo.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.whitestar.TimberDemo.dto.DTO.SkillDTO;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.repository.SkillTypeRepository;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class SkillMapper {
    @Autowired
    SkillTypeRepository skillTypeRepository;

    @Mapping(target="skillType", expression = "java(unwrapOptional(skillTypeRepository.findById(skillDTO.getSkillType())))")
    public abstract Skill skillDTOToSkill(SkillDTO skillDTO);

    <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
