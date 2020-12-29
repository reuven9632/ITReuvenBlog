package com.ITReuvenBlog.WebBlog.repositoryes;

import com.ITReuvenBlog.WebBlog.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
