package by.wms.acc.Controller;

import by.wms.acc.DTO.RequestDTO;
import by.wms.acc.Entity.Request;
import by.wms.acc.Service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<Request> create(@RequestBody RequestDTO dto){
        return new ResponseEntity<>(requestService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Request>> readAll(){
        return new ResponseEntity<>(requestService.readAll(), HttpStatus.OK);
    }

}
