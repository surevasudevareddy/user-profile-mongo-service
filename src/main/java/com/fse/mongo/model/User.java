package com.fse.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class User {
    private Long id;
    private String name;
    private String associateId;
    private String email;
    private long mobile;
    private Date createTs;
    private Date updateTs;
    private List<Skill> skill;
}
