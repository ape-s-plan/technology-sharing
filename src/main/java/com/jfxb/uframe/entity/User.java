package com.jfxb.uframe.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Setter
@Getter
@Component
public class User {
    public String test_name;
    public String test_sex;
    public Integer test_age;
}
