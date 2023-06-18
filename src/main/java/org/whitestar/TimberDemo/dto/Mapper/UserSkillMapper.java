package org.whitestar.TimberDemo.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.whitestar.TimberDemo.dto.DTO.UserProfileDTO;
import org.whitestar.TimberDemo.dto.DTO.UserSkillDTO;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.entity.UserSkill;
import org.whitestar.TimberDemo.repository.SkillRepository;
import org.whitestar.TimberDemo.repository.UserSkillRepository;

import java.time.LocalDate;
import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public abstract class UserSkillMapper {
    @Autowired
    SkillRepository skillRepository;

    @Mapping(target="skill", expression = "java(unwrapOptional(skillRepository.findById(userSkillDTO.getSkillId())))")
    public abstract UserSkill userSkillDTOToUserSkill(UserSkillDTO userSkillDTO);

    <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
