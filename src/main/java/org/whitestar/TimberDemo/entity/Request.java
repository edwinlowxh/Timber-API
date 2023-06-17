package org.whitestar.TimberDemo.entity;

import lombok.Data;

@Data
public class Request {
    private Long id;
    private Long posted_by;
    private Long accepted_by;
    private String title;
    private String description;

    public Request(){}

    public Request(Long id, Long user_id, String title, String description) {
        this.id = id;
        this.posted_by = user_id;
        this.accepted_by = null;
        this.title = title;
        this.description = description;
    }

    public Request(Long user_id, String title, String description) {
        this.posted_by = user_id;
        this.accepted_by = null;
        this.title = title;
        this.description = description;
    }
}
