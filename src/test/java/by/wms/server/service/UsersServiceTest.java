package by.wms.server.service;

import by.wms.server.Controller.UsersController;
import by.wms.server.DTO.UsersDTO;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.UsersRepository;
import by.wms.server.Service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class UsersServiceTest {
    @InjectMocks
    private UsersController usersController;
    @Mock
    private UsersDTO usersDTO;
    @Mock
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void userUpdateTest(){
        UsersService usersService = Mockito.mock(UsersService.class);

        usersDTO.setLogin("john");
        usersDTO.setEmail("john@example.com");
        usersDTO.setPassword("12345678");
        usersDTO.setTitle("Manager");
        usersDTO.setFirstName("john");
        usersDTO.setSecondName("john");
        usersDTO.setSurname("");
        when(usersRepository.save(any(Users.class))).thenReturn(new Users());
        ResponseEntity<Users> response = usersController.update(usersDTO, 1);

    }
}
