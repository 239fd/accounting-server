package by.wms.server.service;

import by.wms.server.DTO.RequestDTO;
import by.wms.server.Entity.Request;
import by.wms.server.Entity.Users;
import by.wms.server.Repository.RequestRepository;
import by.wms.server.Service.RequestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private RequestService requestService;

    @Test
    void createTest() {
        RequestDTO dto = new RequestDTO();
        Date currentDate = new Date();
        dto.setDate(currentDate);
        Users users = new Users();
        when(requestRepository.save(any(Request.class))).thenReturn(new Request());

        Request result = requestService.create(dto);

        assertNotNull(result);
        assertEquals("processing", result.getStatus());
        assertEquals("2022-01-01", result.getDate());
        assertEquals(users, result.getUsers());

        verify(requestRepository, times(1)).save(any(Request.class));
    }

    @Test
    void updateTest() {
        RequestDTO dto = new RequestDTO();
        Date currentDate = new Date();
        dto.setDate(currentDate);
        Integer id = 1;
        Request existingRequest = new Request();
        existingRequest.setId(id);

        when(requestRepository.getReferenceById(id)).thenReturn(existingRequest);
        when(requestRepository.save(existingRequest)).thenReturn(existingRequest);

        Request result = requestService.update(dto, id);

        assertNotNull(result);
        assertEquals("processing", result.getStatus());
        assertEquals("2022-01-01", result.getDate());
        assertEquals(id, result.getId());

        verify(requestRepository, times(1)).getReferenceById(id);
        verify(requestRepository, times(1)).save(existingRequest);
    }

    @Test
    void takeHistoryTest() {
        Users users = new Users();
        users.setId(1);
        List<Request> requests = new ArrayList<>();

        when(requestRepository.findAllById(users.getId())).thenReturn(requests);

        List<Request> result = requestService.takeHistory(users);

        assertNotNull(result);
        assertEquals(requests, result);

        verify(requestRepository, times(1)).findAllById(users.getId());
    }

    @Test
    void deleteTest() {
        Integer id = 1;

        requestService.delete(id);

        verify(requestRepository, times(1)).deleteById(id);
    }
}
