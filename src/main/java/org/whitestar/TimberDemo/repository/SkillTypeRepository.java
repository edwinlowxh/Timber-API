package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.SkillTypeEntity;

import java.util.Optional;

@EnableScan
public interface SkillTypeRepository extends CrudRepository<SkillTypeEntity, String> {
    Optional<SkillTypeEntity> findById(String id);

}
