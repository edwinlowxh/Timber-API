package org.whitestar.TimberDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.dto.DTO.UserProfileDTO;
import org.whitestar.TimberDemo.dto.Mapper.UserProfileMapperImpl;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.repository.UserProfileRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/userProfile")
public class UserProfileController extends BaseController{

    @Autowired
    private  UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileMapperImpl userProfileMapperImpl;


    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestParam("id") String id){
        Optional<UserProfile> userProfile;
        userProfile = userProfileRepository.findById(id);
        UserProfile response = this.unwrapOptional(userProfile);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUsers(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userProfileRepository.findAll());
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to retrieve from database.");
        }
    }

    @PostMapping(value = "/createUser", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody UserProfileDTO userProfileDTO){
        UserProfile userProfile;

        try{
            userProfile = userProfileMapperImpl.userProfileDTOToUserProfile(userProfileDTO);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Check request body");
        }

        userProfileRepository.save(userProfile);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userProfile);
    }

    @DeleteMapping(value = "/delete", params = "id", produces = "application/json")
    public ResponseEntity<?> deleteUserProfile(@RequestParam("id") String id){
        userProfileRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deleted");
    }

    public UserProfile increaseBounties(UserProfile userProfile, int gain){
        if (gain <= 0){
            return userProfile;
        }
        userProfile.setBounties(userProfile.getBounties() + gain);
        return userProfile;
    }

    public UserProfile increaseExperience(UserProfile userProfile, int gain){
        if (gain <= 0){
            return userProfile;
        }

        int levelExperience = userProfile.getLevelExperience();
        int level = userProfile.getLevel();
        int currentExperience = userProfile.getCurrentExperience() + levelExperience * level;

        int newCurrentExperience = currentExperience + gain;
        int newLevel = (int) Math.floor(newCurrentExperience / levelExperience);
        newCurrentExperience = currentExperience % levelExperience;

        userProfile.setCurrentExperience(newCurrentExperience);
        userProfile.setLevel(newLevel);

        return userProfile;
    }
}
