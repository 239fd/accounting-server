package by.wms.server.Repository;

import by.wms.server.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);

}
