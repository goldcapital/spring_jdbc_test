package com.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@ToString
@Setter
@Getter
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private LocalDateTime createdDate;

}
