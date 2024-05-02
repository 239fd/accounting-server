import by.wms.server.DTO.UsersDTO;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.UsersRepository;
import by.wms.server.Service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;
    @InjectMocks
    private UsersService usersService;

    @Test
    public void userUpdateTest(){
        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setLogin("john");
        usersDTO.setEmail("john@example.com");
        usersDTO.setPassword("12345678");
        usersDTO.setTitle("Manager");
        usersDTO.setFirstName("john");
        usersDTO.setSecondName("john");
        usersDTO.setSurname("");
        when(usersRepository.save(any(Users.class))).thenReturn(new Users());

        Users users = new Users();
        users.setId(1);


    }
}
