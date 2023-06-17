package org.whitestar.TimberDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.entity.User_Skill;
import org.whitestar.TimberDemo.repository.RequestRepository;
import org.whitestar.TimberDemo.repository.UserProfileRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/userprofile")
public class UserProfileController {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileController(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping(params = {"id"}, produces = "application/json")
    @ResponseBody
    public Optional<UserProfile> getUser(@RequestParam("id") String id){
        return userProfileRepository.findById(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public List<UserProfile> getUsers(UserProfileRepository userProfileRepository){
        return (List<UserProfile>) userProfileRepository.findAll();
    }
}
