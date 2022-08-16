package com.fse.mongo.config;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Criteria {
    public String name;
    public String associateId;
    public String skillName;
}
