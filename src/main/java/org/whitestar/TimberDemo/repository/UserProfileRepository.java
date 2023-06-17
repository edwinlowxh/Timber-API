package org.whitestar.TimberDemo.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.UserProfile;

@EnableScan
public interface UserProfileRepository extends CrudRepository<UserProfile, String> {}