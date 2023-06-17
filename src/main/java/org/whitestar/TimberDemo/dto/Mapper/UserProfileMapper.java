package org.whitestar.TimberDemo.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.whitestar.TimberDemo.dto.DTO.UserProfileDTO;
import org.whitestar.TimberDemo.entity.UserProfile;

import java.time.LocalDate;

@Mapper(
        componentModel = "spring",
        imports = LocalDate.class
)
public abstract class UserProfileMapper {

    @Mapping(target="dob", expression = "java(LocalDate.parse(userProfileDTO.getDob()))")
    public abstract UserProfile userProfileDTOToUserProfile(UserProfileDTO userProfileDTO);
}
