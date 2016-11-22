package eu.kielczewski.example.controller;

import org.springframework.stereotype.Component;

/**
 * Created by quanzongwei(207127) on 2016/11/22 0022.
 */
@Component
public class Do {
    public String play() {
        System.out.println("I am you xx");
        return "play has do ";

    }
}
