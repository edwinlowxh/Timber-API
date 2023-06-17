package org.whitestar.TimberDemo.repository;

import org.springframework.stereotype.Repository;
import org.whitestar.TimberDemo.entity.Request;

import java.util.HashMap;
import java.util.List;

@Repository
public class RequestRepository {

    public List<Request> getRequests(Long user_id){
        return List.of(
                new Request(1L,1L,"title","description")
        );
    }

    public Request getRequest(Long id){
        HashMap<Long,Request> requests = new HashMap<>();
        requests.put(1L, new Request(1L,1L,"title","description"));
        return requests.get(id);
    }
}
