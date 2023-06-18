package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.Skill;
import org.whitestar.TimberDemo.entity.UserSkill;

import java.util.Optional;


@EnableScan
public interface UserSkillRepository extends CrudRepository<UserSkill, String> {
    Iterable<UserSkill> findAllByUserId(String userId);

    Optional<UserSkill> findByUserIdAndSkill(String userId, Skill skill);
}
