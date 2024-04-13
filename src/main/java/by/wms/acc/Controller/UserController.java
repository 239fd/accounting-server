package by.wms.acc.Controller;

import by.wms.acc.DTO.UsersDTO;
import by.wms.acc.Entity.Users;
import by.wms.acc.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UsersDTO dto){
        return new ResponseEntity<>(usersService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Users> update(@RequestBody Users users) {
        return mappingResponseUsers(usersService.update(users));
    }

    private ResponseEntity<Users> mappingResponseUsers(Users users) {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
