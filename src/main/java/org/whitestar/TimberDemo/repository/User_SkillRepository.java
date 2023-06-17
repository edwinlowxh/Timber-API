package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.User_Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@EnableScan
public interface User_SkillRepository extends CrudRepository<User_Skill, String> {
    Optional<User_Skill> findById(String id);
    void deleteById(String id);
    Iterable<User_Skill> findByUserId(String userId);
}
