package by.wms.server.Service;

import by.wms.server.DTO.LoginDTO;
import by.wms.server.DTO.UsersDTO;
import by.wms.server.Entity.Enums.UsersTitle;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public String registerUser(UsersDTO usersDTO) {

        Users users = new Users(
                usersDTO.getLogin(),
                usersDTO.getEmail(),
                usersDTO.getTitle(),
                usersDTO.getFirstName(),
                usersDTO.getSecondName(),
                usersDTO.getSurname(),
                usersDTO.getPassword()
        );
        userRepository.save(users);
        return users.getLogin();
    }

    public Boolean loginUser(LoginDTO loginDTO) {
        Users user = userRepository.findByLogin(loginDTO.getLogin());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = loginDTO.getPassword();
            if (password.matches(loginDTO.getPassword())) {
                Optional<Users> employee = userRepository.findByLoginAndPassword(loginDTO.getLogin(), encodedPassword);
                if (employee.isPresent()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }else {
            return false;
        }

    }
    public Users update(UsersDTO usersDTO, Integer id){
        Users users = userRepository.getReferenceById(id);
            Users.builder()
                    .login(usersDTO.getLogin())
                    .email(usersDTO.getEmail())
                    .password(usersDTO.getPassword())
                    .title(usersDTO.getTitle())
                    .firstName(usersDTO.getFirstName())
                    .secondName(usersDTO.getSecondName())
                    .surname(usersDTO.getSurname())
                    .build();
        return userRepository.save(users);
    }

}
