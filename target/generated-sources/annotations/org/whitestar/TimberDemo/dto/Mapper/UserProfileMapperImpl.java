package org.whitestar.TimberDemo.dto.Mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.whitestar.TimberDemo.dto.DTO.UserProfileDTO;
import org.whitestar.TimberDemo.entity.UserProfile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:17:17+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserProfileMapperImpl extends UserProfileMapper {

    @Override
    public UserProfile userProfileDTOToUserProfile(UserProfileDTO userProfileDTO) {
        if ( userProfileDTO == null ) {
            return null;
        }

        UserProfile userProfile = new UserProfile();

        userProfile.setName( userProfileDTO.getName() );
        userProfile.setAge( userProfileDTO.getAge() );
        userProfile.setEmail( userProfileDTO.getEmail() );
        userProfile.setLevel( userProfileDTO.getLevel() );
        userProfile.setBounties( userProfileDTO.getBounties() );
        userProfile.setLevelExperience( userProfileDTO.getLevelExperience() );
        userProfile.setCurrentExperience( userProfileDTO.getCurrentExperience() );

        userProfile.setDob( LocalDate.parse(userProfileDTO.getDob()) );

        return userProfile;
    }
}
