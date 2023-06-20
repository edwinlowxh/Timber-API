package org.whitestar.TimberDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.News;
import org.whitestar.TimberDemo.repository.NewsRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/news")
public class NewsController extends BaseController{
    @Autowired
    NewsRepository newsRepository;

    @GetMapping(params = "id", produces = "application/json")
    public ResponseEntity<?> getNews(@RequestParam("id") String id){
        Optional<News> newsOptional = newsRepository.findById(id);

        News news = this.unwrapOptional(newsOptional);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(news);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllNews(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newsRepository.findAll());
    }

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<?> createNews(@RequestBody News news){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newsRepository.save(news));
    }
}
