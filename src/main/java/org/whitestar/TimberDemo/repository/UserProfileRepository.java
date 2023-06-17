package org.whitestar.TimberDemo.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.UserProfile;
import org.whitestar.TimberDemo.entity.UserSkill;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

@EnableScan
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
}
