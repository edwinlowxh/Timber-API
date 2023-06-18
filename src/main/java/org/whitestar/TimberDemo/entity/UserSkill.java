package org.whitestar.TimberDemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName="UserSkill")
public class UserSkill {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String userId;

    @DynamoDBTypeConvertedJson
    private Skill skill;

    @DynamoDBAttribute
    private int level;

    @DynamoDBAttribute
    private int levelExperience;

    @DynamoDBAttribute
    private int currentExperience;

    public UserSkill(String userId, Skill skill) {
        this.userId = userId;
        this.skill = skill;
        this.level = 1;
        this.levelExperience = 100;
        this.currentExperience = 0;
    }
}
