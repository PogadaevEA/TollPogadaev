package jdev.server.controllers;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ServerControllerTest {

    public PointDTO point;

    @InjectMocks
    ServerController serverController;

    @Before
    public void setUp() throws Exception {
        point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAzim(123);
        point.setSpeed(40);
        point.setAutoId("k310ms80");
        point.setTime(System.currentTimeMillis());
    }

    @Test
    public void createPoint() throws Exception {
        PointDTO result = serverController.createPoint(point);
        assertNotNull(result);
        assertEquals(56, result.getLat(),0);
        assertEquals(74, result.getLon(),0);
        assertEquals(123, result.getAzim(),0);
        assertEquals(40, result.getSpeed(),0);
        assertEquals("k310ms80", result.getAutoId());
        assertTrue(result.toJson().contains("\"time\":"));
    }
    @Test
    public void reatePointIntegration() throws Exception {
        PointDTO result = new ServerController(new RestTemplate()).createPoint(point);
        assertNotNull(result);
        assertEquals(56, result.getLat(),0);
        assertEquals(74, result.getLon(),0);
        assertEquals(123, result.getAzim(),0);
        assertEquals(40, result.getSpeed(),0);
        assertEquals("k310ms80", result.getAutoId());
        assertTrue(result.toJson().contains("\"time\":"));
    }

}