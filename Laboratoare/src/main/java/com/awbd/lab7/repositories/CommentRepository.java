package com.awbd.lab7.repositories;

import com.awbd.lab7.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
