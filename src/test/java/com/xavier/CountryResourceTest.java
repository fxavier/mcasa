package com.xavier;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.ws.rs.core.Response;

import com.xavier.dto.CountryDTO;
import com.xavier.resource.CountryResource;
import com.xavier.service.CountryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CountryResourceTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryResource countryResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        when(countryService.findAll()).thenReturn(Collections.emptyList());
        Response response = countryResource.findAll();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void testFindById() {
        when(countryService.findById(1L)).thenReturn(new CountryDTO());
        Response response = countryResource.findById(1L);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void testCreate() {
        when(countryService.save(new CountryDTO())).thenReturn(new CountryDTO());
        Response response = countryResource.create(new CountryDTO());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    void testUpdate() {
        when(countryService.update(1L, new CountryDTO())).thenReturn(new CountryDTO());
        Response response = countryResource.update(1L, new CountryDTO());
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void testDelete() {
        doNothing().when(countryService).delete(1L);
        Response response = countryResource.delete(1L);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    
}
