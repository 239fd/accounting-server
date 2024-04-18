package by.wms.server.Service;

import by.wms.server.Entity.Users;
import by.wms.server.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users registerUser(Users newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public String loginUser(String login, String password) {
        Users user = userRepository.findByLogin(login);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "authentication_token";
        }
        return null;
    }
    public Users update(Users users){
        return userRepository.save(users);
    }

}
