package org.whitestar.TimberDemo.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.entity.UserProfile;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@EnableScan
public interface UserProfileRepository extends CrudRepository<UserProfile, String> {
    Optional<UserProfile> findById(String id);
    Iterable<UserProfile> findAll();
}