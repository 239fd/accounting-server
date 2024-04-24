package by.wms.server.service;

import by.wms.server.Entity.Product;
import by.wms.server.DTO.ProductDTO;
import by.wms.server.Repository.ProductRepository;
import by.wms.server.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductService productService;
    @Test
    void createTest() {
        ProductDTO dto = new ProductDTO();
        dto.setName("Test Product");
        dto.setWaybill(789);
        dto.setLength(15.1);
        dto.setWidth(8.1);
        dto.setWeight(4.1);
        dto.setHeight(6.1);

        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        Product result = productService.create(dto);

        assertNotNull(result);
        assertEquals("Test Product", result.getName());
        assertEquals("ABC123", result.getWaybill());
        assertEquals(10, result.getLength());
        assertEquals(5, result.getWidth());
        assertEquals(2, result.getWeight());
        assertEquals(3, result.getHeight());

        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void updateTest() {
        ProductDTO dto = new ProductDTO();
        dto.setName("Updated Product");
        dto.setWaybill(789);
        dto.setLength(15.1);
        dto.setWidth(8.1);
        dto.setWeight(4.1);
        dto.setHeight(6.1);
        Integer id = 1;
        Product existingProduct = new Product();
        existingProduct.setId(id);

        when(productRepository.getReferenceById(id)).thenReturn(existingProduct);
        when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        Product result = productService.update(dto, id);

        assertNotNull(result);
        assertEquals("Updated Product", result.getName());
        assertEquals("XYZ789", result.getWaybill());
        assertEquals(15, result.getLength());
        assertEquals(8, result.getWidth());
        assertEquals(4, result.getWeight());
        assertEquals(6, result.getHeight());
        assertEquals(id, result.getId());

        verify(productRepository, times(1)).getReferenceById(id);
        verify(productRepository, times(1)).save(existingProduct);
    }

    @Test
    void deleteTest() {
        Integer id = 1;

        productService.delete(id);

        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void takeNumberTest() {
        Product product = new Product();
        product.setId(1);

        int result = productService.takeNumber(product);

        assertEquals(1, result);
    }
}

