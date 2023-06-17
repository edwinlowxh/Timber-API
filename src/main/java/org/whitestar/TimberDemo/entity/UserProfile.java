package org.whitestar.TimberDemo.entity;

import java.time.LocalDate;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName="userprofiletable")
public class UserProfile {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private Integer age;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private LocalDate dob;
    @DynamoDBAttribute
    private int level;
    @DynamoDBAttribute
    private int bounties;
    //experience required to level up for current level
    @DynamoDBAttribute
    private int levelExperience;
    //accumulated experience for current level
    @DynamoDBAttribute
    private int currentExperience;

    public UserProfile(String id, String name, Integer age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.level = 1;
        this.bounties = 0;
        this.levelExperience = 100;
        this.currentExperience = 0;
    }

    public UserProfile(String name, Integer age, String email, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.level = 1;
        this.bounties = 0;
        this.levelExperience = 100;
        this.currentExperience = 20;
    }
}