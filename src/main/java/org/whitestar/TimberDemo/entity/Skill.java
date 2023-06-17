package org.whitestar.TimberDemo.entity;

import lombok.Data;

@Data
public class Skill {
    private Long id;
    private String title;
    private String category;

    public Skill(){}

    public Skill(Long id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Skill(String title, String category) {
        this.title = title;
        this.category = category;
    }
}
