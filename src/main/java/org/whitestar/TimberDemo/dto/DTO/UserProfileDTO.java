package org.whitestar.TimberDemo.dto.DTO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.*;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileDTO {
    String name;
    String email;
    int age;
    String dob;

    private int level = 1;
    private int bounties = 0;
    private int levelExperience = 100;
    private int currentExperience = 20;
}
