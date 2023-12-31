package org.whitestar.TimberDemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
@DynamoDBTable(tableName="SkillType")
public class SkillType {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    @DynamoDBAttribute
    private String name;
}
