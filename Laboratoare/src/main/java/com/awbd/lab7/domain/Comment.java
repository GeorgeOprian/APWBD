package com.awbd.lab7.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@ToString
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String name;
    private String email;
    private String text;
    private Date date;
}
