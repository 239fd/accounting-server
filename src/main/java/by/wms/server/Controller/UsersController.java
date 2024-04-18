package by.wms.server.Controller;

import by.wms.server.Entity.Users;
import by.wms.server.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsersController {

    private UsersService usersService;

    @PutMapping
    public ResponseEntity<Users> update(@RequestBody Users users) {
        return mappingResponseUsers(usersService.update(users));
    }

    private ResponseEntity<Users> mappingResponseUsers(Users users) {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
