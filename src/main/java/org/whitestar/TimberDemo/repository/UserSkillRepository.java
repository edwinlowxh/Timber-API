package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.UserSkill;


@EnableScan
public interface UserSkillRepository extends CrudRepository<UserSkill, Long> {
}
