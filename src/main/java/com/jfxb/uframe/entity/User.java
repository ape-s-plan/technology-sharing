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
    public String name;
    public String sex;
    public Integer age;
}
