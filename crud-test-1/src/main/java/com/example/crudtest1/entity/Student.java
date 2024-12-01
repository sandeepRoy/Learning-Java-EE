package com.example.crudtest1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    private Integer student_id;
    private String student_name;
}
