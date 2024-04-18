package by.wms.server.Controller;

import by.wms.server.DTO.ProductDTO;
import by.wms.server.Entity.Product;
import by.wms.server.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receiver")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Integer> takeNumber(@RequestBody Product product){
        return  new ResponseEntity<>(productService.takeNumber(product), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO dto,@PathVariable Integer id) {
        return new ResponseEntity<>(productService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

}
