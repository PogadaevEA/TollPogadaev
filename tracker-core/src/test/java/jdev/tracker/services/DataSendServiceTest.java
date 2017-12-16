package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DataSendServiceTest {
    private PointDTO point;
    @Mock
    DataPeekService dataPeekService;

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    private DataSendService dataSendService;

    @Before
    public void setUp() throws Exception{
        point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAzim(123);
        point.setSpeed(40);
        point.setAutoId("k310ms70");
        point.setTime(System.currentTimeMillis());
    }

    @Test
    public void sendGPStoServer() throws Exception {
        when(restTemplate.postForObject("http://localhost:9000/points", point, PointDTO.class)).thenReturn(point)
                .thenThrow(ResourceAccessException.class);
//        .doThrow(new RuntimeException()).when(dataSendService).sendGPStoServer();
    }

}