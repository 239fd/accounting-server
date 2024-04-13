package by.wms.acc.Service;

import by.wms.acc.DTO.UsersDTO;
import by.wms.acc.Entity.Users;
import by.wms.acc.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users create(UsersDTO dto){
        Users users = Users.builder()
                .login(dto.getLogin())
                .password(dto.getPassword())
                .name(dto.getName())
                .surname(dto.getSurname())
                .apostryc(dto.getApostryc())
                .build();
        return usersRepository.save(users);
    }

    public Users update(Users users){
        return usersRepository.save(users);
    }

}
