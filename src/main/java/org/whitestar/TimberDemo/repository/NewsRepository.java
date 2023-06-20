package org.whitestar.TimberDemo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.whitestar.TimberDemo.entity.News;

@EnableScan
public interface NewsRepository extends CrudRepository<News, String> {
}
