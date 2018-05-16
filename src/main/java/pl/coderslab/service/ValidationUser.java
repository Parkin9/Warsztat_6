package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Login;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Component
public class ValidationUser {

    @Autowired
    private UserRepository userRepository;


    public Boolean checkPassword(Login login) {

        User user = userRepository.findFirstByUsername(login.getUsername());

        if(user != null && BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
