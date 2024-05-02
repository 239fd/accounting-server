import by.wms.server.Entity.Product;
import by.wms.server.DTO.ProductDTO;
import by.wms.server.Repository.ProductRepository;
import by.wms.server.Service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void createTest() {
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
        assertEquals("Test Product", dto.getName());
        assertEquals(789, dto.getWaybill());
        assertEquals(15.1, dto.getLength());
        assertEquals(8.1, dto.getWidth());
        assertEquals(4.1, dto.getWeight());
        assertEquals(6.1, dto.getHeight());

        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void updateTest() {
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
        assertEquals(789, result.getWaybill());
        assertEquals(15.1, result.getLength());
        assertEquals(8.1, result.getWidth());
        assertEquals(4.1, result.getWeight());
        assertEquals(6.1, result.getHeight());
        assertEquals(id, result.getId());

        verify(productRepository, times(1)).getReferenceById(id);
        verify(productRepository, times(1)).save(existingProduct);
    }
    @Test
    public void takeNumberTest() {
        Product product = new Product();
        product.setId(1);

        int result = productService.takeNumber(product);

        assertEquals(1, result);
    }

    @Test
    public void deleteTest() {
        Integer id = 1;

        productService.delete(id);

        verify(productRepository, times(1)).deleteById(id);
    }


}

