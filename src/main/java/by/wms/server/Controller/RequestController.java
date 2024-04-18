package by.wms.server.Controller;

import by.wms.server.DTO.RequestDTO;
import by.wms.server.Entity.Request;
import by.wms.server.Entity.Users;
import by.wms.server.Service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@AllArgsConstructor
public class RequestController {

    private RequestService supplierService;

    @PostMapping("/request")
    public ResponseEntity<Request> create(@RequestBody RequestDTO dto){
        return new ResponseEntity<>(supplierService.create(dto), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Request> update(@RequestBody RequestDTO dto, @PathVariable Integer id){
        return new ResponseEntity<>(supplierService.update(dto, id), HttpStatus.OK);
    }

    @GetMapping("/take")
    public ResponseEntity<List<Request>> takeHistory(@RequestBody Users users){
        return new ResponseEntity<>(supplierService.takeHistory(users), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        supplierService.delete(id);
        return HttpStatus.OK;
    }
}
