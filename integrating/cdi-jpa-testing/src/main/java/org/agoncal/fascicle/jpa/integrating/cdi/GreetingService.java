package org.agoncal.fascicle.jpa.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name;
    }
}
