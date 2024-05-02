package service;

import by.wms.server.DTO.RequestDTO;
import by.wms.server.DTO.UsersDTO;
import by.wms.server.Entity.Product;
import by.wms.server.Entity.Request;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.ProductRepository;
import by.wms.server.Repository.RequestRepository;
import by.wms.server.Repository.UsersRepository;
import by.wms.server.Service.ProductService;
import by.wms.server.Service.RequestService;
import by.wms.server.Service.UsersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringRunner.class)
public class ServerApplicationTest {

    @Test
    public void  contextLoads() {
    }
    @Mock
    private UsersRepository usersRepository;
    @InjectMocks
    private UsersService usersService;

    @Test
    public void userUpdateTest(){
        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setLogin("john");
        usersDTO.setEmail("john@example.com");
        usersDTO.setPassword("12345678");
        usersDTO.setTitle("Manager");
        usersDTO.setFirstName("john");
        usersDTO.setSecondName("john");
        usersDTO.setSurname("");
        when(usersRepository.save(any(Users.class))).thenReturn(new Users());

        Users users = new Users();
        users.setId(1);

    }
    @Mock
    private RequestRepository requestRepository;
    @InjectMocks
    private RequestService requestService;

    @Test
    public void createTest() {
        RequestDTO dto = new RequestDTO();
        Date currentDate = new Date();
        dto.setDate(currentDate);
        dto.setStatus("processing");
        Users users = new Users();
        when(requestRepository.save(any(Request.class))).thenReturn(new Request());

        Request result = requestService.create(dto);

        Assert.assertNotNull(result);
        Assert.assertEquals("processing", dto.getStatus());
        Assert.assertEquals(currentDate, dto.getDate());

        verify(requestRepository, times(1)).save(any(Request.class));
    }

    @Test
    public void updateTest() {
        RequestDTO dto = new RequestDTO();
        Date currentDate = new Date();
        dto.setDate(currentDate);
        dto.setStatus("processing");
        Integer id = 1;
        Request existingRequest = new Request();
        existingRequest.setId(id);

        when(requestRepository.getReferenceById(id)).thenReturn(existingRequest);
        when(requestRepository.save(existingRequest)).thenReturn(existingRequest);

        Request result = requestService.update(dto, id);


        Assert.assertNotNull(result);
        Assert.assertEquals("processing", dto.getStatus());
        Assert.assertEquals(currentDate, dto.getDate());

        verify(requestRepository, times(1)).getReferenceById(id);
        verify(requestRepository, times(1)).getReferenceById(id);
    }

    @Test
    public void takeHistoryTest() {
        Users users = new Users();
        users.setId(1);
        List<Request> requests = new ArrayList<>();

        when(requestRepository.findAllById(users.getId())).thenReturn(requests);

        List<Request> result = requestService.takeHistory(users);

        Assert.assertNotNull(result);
        Assert.assertEquals(requests, result);

        verify(requestRepository, times(1)).findAllById(users.getId());
    }

    @Test
    public void deleteTest() {
        Integer id = 1;

        requestService.delete(id);

        verify(requestRepository, times(1)).deleteById(id);
    }
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

//    @Test
//    public void createTest1() {
//        ProductDTO dto = new ProductDTO();
//        dto.setName("Test Product");
//        dto.setWaybill(789);
//        dto.setLength(15.1);
//        dto.setWidth(8.1);
//        dto.setWeight(4.1);
//        dto.setHeight(6.1);
//
//
//        when(productRepository.save(any(Product.class))).thenReturn(new Product());
//        Product result = productService.create(dto);
//
//        assertNotNull(result);
//        Assert.assertEquals("Test Product", dto.getName());
//        Assert.assertEquals(Optional.of(789), dto.getWaybill());
//        Assert.assertEquals(Optional.of(15.1), dto.getLength());
//        Assert.assertEquals(Optional.of(8.1), dto.getWidth());
//        Assert.assertEquals(Optional.of(4.1), dto.getWeight());
//        Assert.assertEquals(Optional.of(6.1), dto.getHeight());
//
//        verify(productRepository, times(1)).save(any(Product.class));
//    }

//    @Test
//    public void updateTest1() {
//        ProductDTO dto = new ProductDTO();
//        dto.setName("Updated Product");
//        dto.setWaybill(789);
//        dto.setLength(15.1);
//        dto.setWidth(8.1);
//        dto.setWeight(4.1);
//        dto.setHeight(6.1);
//        Integer id = 1;
//        Product existingProduct = new Product();
//        existingProduct.setId(id);
//
//        when(productRepository.getReferenceById(id)).thenReturn(existingProduct);
//        when(productRepository.save(existingProduct)).thenReturn(existingProduct);
//
//        Product result = productService.update(dto, id);
//
//        assertNotNull(result);
//        Assert.assertEquals("Updated Product", result.getName());
//        Assert.assertEquals(789, Optional.ofNullable(dto.getWaybill()));
//        Assert.assertEquals(Optional.of(15.1), dto.getLength());
//        Assert.assertEquals(Optional.of(8.1), dto.getWidth());
//        Assert.assertEquals(Optional.of(4.1), dto.getWeight());
//        Assert.assertEquals(Optional.of(6.1), dto.getHeight());
//        Assert.assertEquals(id, result.getId());
//
//        verify(productRepository, times(1)).getReferenceById(id);
//        verify(productRepository, times(1)).save(existingProduct);
//    }
    @Test
    public void takeNumberTest() {
        Product product = new Product();
        product.setId(1);

        int result = productService.takeNumber(product);

        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteTest1() {
        Integer id = 1;

        productService.delete(id);

        verify(productRepository, times(1)).deleteById(id);
    }

}
