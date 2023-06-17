package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.Request;

import java.util.Optional;

@EnableScan
public interface RequestRepository extends CrudRepository<Request, String> {
    Optional<Request> findById(String id);
    void deleteById(String id);
    Iterable<Request> findAll();
}

