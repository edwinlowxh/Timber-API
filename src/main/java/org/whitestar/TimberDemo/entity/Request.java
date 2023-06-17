package org.whitestar.TimberDemo.entity;

import lombok.Data;

@Data
public class Request {
    private String id;
    private String posted_by;
    private String accepted_by;
    private String title;
    private String description;

    public Request(){}

    public Request(String id, String user_id, String title, String description) {
        this.id = id;
        this.posted_by = user_id;
        this.accepted_by = null;
        this.title = title;
        this.description = description;
    }

    public Request(String user_id, String title, String description) {
        this.posted_by = user_id;
        this.accepted_by = null;
        this.title = title;
        this.description = description;
    }
}
