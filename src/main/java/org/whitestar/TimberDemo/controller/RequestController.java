package org.whitestar.TimberDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.repository.RequestRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/requests")
public class RequestController {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestController(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    @GetMapping(params = {"userId"})
    public List<Request> getRequests(RequestRepository requestRepository, @RequestParam("userId") Long userId){
        return requestRepository.getRequests(userId);
    }

    @GetMapping(params = {"id"})
    public Request getRequest(RequestRepository requestRepository, @RequestParam("id") Long id){
        return requestRepository.getRequest(id);
    }
}
