package by.wms.acc.Service;

import by.wms.acc.DTO.GoodsDTO;
import by.wms.acc.Entity.Goods;
import by.wms.acc.Repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;

    public Goods create(GoodsDTO dto){
        Goods goods = Goods.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .length(dto.getLength())
                .width(dto.getWidth())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .build();
        return goodsRepository.save(goods);
    }

    public Goods update(Goods goods){
        return goodsRepository.save(goods);
    }

    public void delete(Integer ID){
        goodsRepository.deleteById(ID);
    }
}
