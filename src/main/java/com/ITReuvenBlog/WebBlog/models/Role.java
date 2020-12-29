package com.ITReuvenBlog.WebBlog.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();                  //строковое представление USER(смотри строку выше от enum)
    }
}
