package org.whitestar.TimberDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.entity.SkillTypeEntity;
import org.whitestar.TimberDemo.repository.RequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/request")
public class RequestController {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestController(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    @GetMapping(params = {"id"}, produces = "application/json")
    @ResponseBody
    public Optional<Request> getRequest(@RequestParam("id") String id){
        return requestRepository.findById(id);
    }

    // request body
    record RequestRecord(
        String user_id,
        String title,
        String description
    ){}

    @PostMapping()
    public void postRequest(RequestRecord requestRecord){
        Request request = new Request(requestRecord.user_id, requestRecord.title, requestRecord.description);
        requestRepository.save(request);
    }

    @PutMapping(params = {"id"})
    public void acceptRequest(@RequestParam("id") String id, RequestRecord requestRecord){
        Request request = new Request(id, requestRecord.user_id, requestRecord.title, requestRecord.description);
        requestRepository.save(request);
    }

    @DeleteMapping(params = {"id","isComplete"})
    public void deleteRequest(@RequestParam("id") String id, @RequestParam(value = "isComplete", defaultValue = "false") boolean isComplete){
        if (isComplete){
            Optional<Request> completedRequest = requestRepository.findById(id);
            // increase experience points of the relevant user using request.accepted_by, which is a user id
        }
        requestRepository.deleteById(id);
    }

    @GetMapping(value = "/user", params = {"userId"})
    public List<Request> getRequests(RequestRepository requestRepository, @RequestParam("userId") String userId){
        return requestRepository.findByUserId(userId);
    }
}
