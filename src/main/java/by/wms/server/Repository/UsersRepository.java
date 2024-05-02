package by.wms.server.Repository;

import by.wms.server.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByLoginAndPassword(String login, String password);
    Users findByLogin(String login);

}
