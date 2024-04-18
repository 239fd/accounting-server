package by.wms.server.Service;

import by.wms.server.DTO.RequestDTO;
import by.wms.server.Entity.Request;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request create(RequestDTO dto) {
        Request request = Request.builder()
                .status("processing")
                .date(dto.getDate())
                .users(dto.getUsers())
                .build();
        return requestRepository.save(request);
    }

    public Request update(RequestDTO dto, Integer ID){
        Request request = requestRepository.getReferenceById(ID);
        Request.builder()
                .status("processing")
                .date(dto.getDate())
                .build();
        return requestRepository.save(request);
    }

    public List<Request> takeHistory(Users users) {
        return requestRepository.findAllById(users.getId());
    }

    public void delete(Integer ID){
        requestRepository.deleteById(ID);
    }

}
