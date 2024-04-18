package by.wms.server.Repository;


import by.wms.server.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findAllById(Integer id);
}
