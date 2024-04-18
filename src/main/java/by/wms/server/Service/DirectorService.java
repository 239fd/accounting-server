package by.wms.server.Service;

import by.wms.server.Entity.Product;
import by.wms.server.Entity.Request;
import by.wms.server.Repository.ProductRepository;
import by.wms.server.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DirectorService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Object> takeHistory(){
        List<Request> requests = requestRepository.findAll();
        List<Product> products = productRepository.findAll();
        return  Stream.concat(requests.stream(), products.stream()).collect(Collectors.toList());
    }
}
