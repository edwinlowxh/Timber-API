package org.whitestar.TimberDemo.entity;

import lombok.Data;

@Data
public class Skill {
    private String id;
    private String title;
    private String category_id;

    public Skill(){}

    public Skill(String id, String title, String category_id) {
        this.id = id;
        this.title = title;
        this.category_id = category_id;
    }

    public Skill(String title, String category) {
        this.title = title;
        this.category_id = category_id;
    }
}
