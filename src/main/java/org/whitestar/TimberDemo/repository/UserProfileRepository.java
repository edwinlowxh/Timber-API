package org.whitestar.TimberDemo.repository;


import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.UserProfile;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserProfileRepository {
    public List<UserProfile> getUserProfiles(){
        return List.of(
                new UserProfile(1L,"elvis",22,"asd@mail.com", LocalDate.of(1919, Month.MAY,5))
        );
    }

    public UserProfile getUserProfile(Long id){
        HashMap<Long, UserProfile> user_profiles = new HashMap<>();
        user_profiles.put(1L, new UserProfile(
                1L,
                "elvi",
                22,
                "asd@mail.com",
                LocalDate.of(1919, Month.MAY,5)));
        return user_profiles.get(id);
    }
}
