package by.wms.server.Controller;

import by.wms.server.Service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/director")
@AllArgsConstructor
public class DirectorController {

   private DirectorService directorService;

   @GetMapping("/take")
   public ResponseEntity<List<Object>> takeHistory(){
      return new ResponseEntity<>(directorService.takeHistory(), HttpStatus.OK);
   }

}
