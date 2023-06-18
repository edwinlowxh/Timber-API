package org.whitestar.TimberDemo.dto.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSkillDTO {
    private String userId;
    private String skillId;

    @Schema(defaultValue = "1")
    private int level = 1;
    @Schema(defaultValue = "100")
    private int levelExperience = 100;
    @Schema(defaultValue = "0")
    private int currentExperience = 0;
}
