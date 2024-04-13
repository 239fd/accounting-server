package by.wms.acc.Service;

import by.wms.acc.DTO.RequestDTO;
import by.wms.acc.Entity.Request;
import by.wms.acc.Repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public Request create(RequestDTO dto){
        Request request = Request.builder()
                .status(dto.getStatus())
                .date(dto.getDate())
                .build();
        return requestRepository.save(request);
    }

    public List<Request> readAll(){
        return requestRepository.findAll();
    }



}
