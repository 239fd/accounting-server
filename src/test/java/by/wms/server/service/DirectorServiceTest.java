package by.wms.server.service;

import by.wms.server.Entity.Product;
import by.wms.server.Entity.Request;
import by.wms.server.Repository.ProductRepository;
import by.wms.server.Repository.RequestRepository;
import by.wms.server.Service.DirectorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DirectorServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private DirectorService historyService;

    @Test
    void takeHistoryTest() {
        List<Request> requests = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        when(requestRepository.findAll()).thenReturn(requests);
        when(productRepository.findAll()).thenReturn(products);

        List<Object> result = historyService.takeHistory();

        assertNotNull(result);
        assertEquals(requests.size() + products.size(), result.size());

        verify(requestRepository, times(1)).findAll();
        verify(productRepository, times(1)).findAll();
    }
}
