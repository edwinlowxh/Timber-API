package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.entity.SkillTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@EnableScan
public interface RequestRepository extends CrudRepository<Request, String> {
    Optional<Request> findById(String id);
    void deleteById(String id);
    Iterable<Request> findAll();
}

