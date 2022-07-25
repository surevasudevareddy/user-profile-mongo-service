package com.fse.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private Long id;

    private String skillName;

    private String skillType;

    private int expertiseLevel;

    private Long userId;
}
