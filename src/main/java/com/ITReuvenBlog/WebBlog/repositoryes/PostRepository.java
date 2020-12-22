package com.ITReuvenBlog.WebBlog.repositoryes;

import com.ITReuvenBlog.WebBlog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
