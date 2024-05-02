package by.wms.server.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

    private String login;
    private String email;
    private String password;
    private String title;
    private String firstName;
    private String secondName;
    private String surname;


}
