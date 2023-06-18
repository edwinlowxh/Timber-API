package org.whitestar.TimberDemo.dto.DTO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileDTO {
    private String name;
    private String email;
    private int age;
    private String dob;

    @Schema(defaultValue = "1")
    private int level = 1;
    @Schema(defaultValue = "0")
    private int bounties = 0;
    @Schema(defaultValue = "100")
    private int levelExperience = 100;
    @Schema(defaultValue = "20")
    private int currentExperience = 20;
}
