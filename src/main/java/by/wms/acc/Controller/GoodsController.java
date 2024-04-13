package by.wms.acc.Controller;

import by.wms.acc.DTO.GoodsDTO;
import by.wms.acc.Entity.Goods;
import by.wms.acc.Service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping
    public ResponseEntity<Goods> create(@RequestBody GoodsDTO dto){
        return new ResponseEntity<>(goodsService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Goods> update(@RequestBody Goods goods) {
        return mappingResponseGoods(goodsService.update(goods));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        goodsService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Goods> mappingResponseGoods(Goods goods) {
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }


}
