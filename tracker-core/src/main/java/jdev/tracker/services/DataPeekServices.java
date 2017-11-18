package jdev.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class DataPeekServices {

    @Autowired
    private DataSentServices dataSentServices;

    @PostConstruct
    private void init() {
        dataSentServices.callFromInit();
    }
}
