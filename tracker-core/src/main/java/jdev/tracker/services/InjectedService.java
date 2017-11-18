package jdev.tracker.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class InjectedService {

    @Value("${int.prop}")
    Integer intProp;

    @Value("${bool.prop}")
    Boolean boolProp;

    @PostConstruct
    public void init() {
        System.out.println("intProp = " + intProp);
        System.out.println("boolProp = " + boolProp);
    }

}
