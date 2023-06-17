package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.UserSkill;

import java.util.Optional;


@EnableScan
public interface UserSkillRepository extends CrudRepository<UserSkill, Long> {
    Optional<UserSkill> findById(String id);
    void deleteById(String id);
    Iterable<UserSkill> findByUserID(String userID);
}
