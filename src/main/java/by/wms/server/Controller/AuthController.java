package by.wms.server.Controller;

import by.wms.server.Entity.Users;
import by.wms.server.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users newUser) {
        Users createdUser = userService.registerUser(newUser);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        String token = userService.loginUser(user.getLogin(), user.getPassword());
        if (token != null) {
            String title = user.getTitle();
            return switch (title) {
                case "director" -> ResponseEntity.ok("redirect:/director");
                case "receiver" -> ResponseEntity.ok("redirect:/receiver");
                case "supplier", "recipient" -> ResponseEntity.ok("redirect:/supplier");
                default -> ResponseEntity.ok("redirect:/home");
            };
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
