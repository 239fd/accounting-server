package by.wms.server.Service;

import by.wms.server.DTO.ProductDTO;
import by.wms.server.Entity.Product;
import by.wms.server.Repository.ProductRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.transaction.Transactional;
import org.hibernate.*;
import org.hibernate.graph.RootGraph;
import org.hibernate.internal.SessionImpl;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaInsertSelect;
import org.hibernate.stat.SessionStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;


    public Product create(ProductDTO dto){
        Product product;
        product = Product.builder()
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
        product.setName(dto.getName());
        product.setWaybill(dto.getWaybill());
        product.setLength(dto.getLength());
        product.setWidth(dto.getWidth());
        product.setWeight(dto.getWeight());
        product.setHeight(dto.getHeight());
        return productRepository.save(product);
    }

    public void delete(Integer ID){
        productRepository.deleteById(ID);
    }

    public int takeNumber(Product product){
        return product.getId();
    }

}
