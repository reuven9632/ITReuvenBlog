package com.ITReuvenBlog.WebBlog.service;

import com.ITReuvenBlog.WebBlog.models.Role;
import com.ITReuvenBlog.WebBlog.models.User;
import com.ITReuvenBlog.WebBlog.repositoryes.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSenderService mailSenderService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {

            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())){    /*проверяю если getEmail() не пустой или не null*/
            /*в String.format("текст с использованием %s", переменная заменяющая %s в тексте)*/
            String message = String.format("Hello %s  \n" +
                    "go to link: http://localhost:8081/activate/%s",
                    user.getUsername(),
                    user.getActivationCode());
            mailSenderService.send(user.getEmail(), "Activation code", message);
        }

        return true;
    }

    public boolean activateUser(String activationCode) {
        User user = userRepository.findByActivationCode(activationCode);

        if (user == null)
            return false;

        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

}
