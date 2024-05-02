package by.wms.server.Controller;

import by.wms.server.DTO.UsersDTO;
import by.wms.server.Entity.Users;
import by.wms.server.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PutMapping
    public ResponseEntity<Users> update(@RequestBody UsersDTO dto,@PathVariable Integer id) {
        return new ResponseEntity<>(usersService.update(dto, id), HttpStatus.OK);
    }
}
