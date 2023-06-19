package org.whitestar.TimberDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whitestar.TimberDemo.entity.Request;
import org.whitestar.TimberDemo.repository.RequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/request")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

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
    public void postRequest(@RequestBody  RequestRecord requestRecord){
        Request request = new Request(requestRecord.user_id, requestRecord.title, requestRecord.description);
        requestRepository.save(request);
    }

    @PutMapping(params = {"id"})
    public void acceptRequest(@RequestParam("id") String id,@RequestBody RequestRecord requestRecord){
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

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public List<Request> getRequests(){
        return (List<Request>) requestRepository.findAll();
    }
}
