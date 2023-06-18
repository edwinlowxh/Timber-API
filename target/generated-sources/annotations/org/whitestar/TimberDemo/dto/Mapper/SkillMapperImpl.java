package org.whitestar.TimberDemo.dto.Mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.whitestar.TimberDemo.dto.DTO.SkillDTO;
import org.whitestar.TimberDemo.entity.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:17:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class SkillMapperImpl extends SkillMapper {

    @Override
    public Skill skillDTOToSkill(SkillDTO skillDTO) {
        if ( skillDTO == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setName( skillDTO.getName() );

        skill.setSkillType( unwrapOptional(skillTypeRepository.findById(skillDTO.getSkillType())) );

        return skill;
    }
}
