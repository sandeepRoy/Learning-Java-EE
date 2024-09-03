package ormtask3.ormtask3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Comment {
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "ADD_DATE")
    private LocalDate date;
    @Column(name = "COMMENT")
    private String comment;
}
