package by.wms.server.Service;

import by.wms.server.DTO.ProductDTO;
import by.wms.server.Entity.Product;
import by.wms.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductDTO dto){
        Product product = Product.builder()
                .name(dto.getName())
                .waybill(dto.getWaybill())
                .length(dto.getLength())
                .width(dto.getWidth())
                .weight(dto.getWeight())
                .height(dto.getHeight())
                .build();
        return productRepository.save(product);
    }

    public Product update(ProductDTO dto, Integer ID){
        Product product = productRepository.getReferenceById(ID);
                Product.builder()
                .name(dto.getName())
                .waybill(dto.getWaybill())
                .length(dto.getLength())
                .width(dto.getWidth())
                .weight(dto.getWeight())
                .height(dto.getHeight())
                .build();
        return productRepository.save(product);
    }

    public void delete(Integer ID){
        productRepository.deleteById(ID);
    }

    public int takeNumber(Product product){
        return product.getId();
    }

}
