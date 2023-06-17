package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.SkillType;

import java.util.Optional;


@EnableScan
public interface SkillTypeRepository extends CrudRepository<SkillType, String> {
    Optional<SkillType> findByName(String name);
}
