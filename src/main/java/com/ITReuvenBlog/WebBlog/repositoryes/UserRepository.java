package com.ITReuvenBlog.WebBlog.repositoryes;

import com.ITReuvenBlog.WebBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
