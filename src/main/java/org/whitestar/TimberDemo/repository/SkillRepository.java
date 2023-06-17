package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.entity.Skill;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@EnableScan
public interface SkillRepository extends CrudRepository<Skill, String> {
    Optional<Skill> findById(String id);
}
