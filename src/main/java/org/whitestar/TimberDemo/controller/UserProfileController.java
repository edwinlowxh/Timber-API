package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.repository.UserProfileRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/userprofiles")
public class UserProfileController {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileController(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

//    @GetMapping
//    public List<UserProfile> getUsers(UserProfileRepository userProfileRepository){
//        return userProfileRepository.getUserProfiles();
//    }

//    @GetMapping(params = {"id"})
//    public UserProfile getUser(UserProfileRepository userProfileRepository, @RequestParam("id") Long id){
//        return userProfileRepository.getUserProfile(id);
//    }
}
