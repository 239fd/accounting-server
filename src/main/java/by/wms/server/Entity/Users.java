package by.wms.server.Entity;

import by.wms.server.Entity.Enums.UsersTitle;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_db")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique=true)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "surname")
    private String surname;


    public Users(String login, String email, String password, String title, String firstName, String secondName, String surname) {
        this.login = login;
        this.email = email;
        this.password = passwordEncoder().encode(password);
        this.title = title;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


}
