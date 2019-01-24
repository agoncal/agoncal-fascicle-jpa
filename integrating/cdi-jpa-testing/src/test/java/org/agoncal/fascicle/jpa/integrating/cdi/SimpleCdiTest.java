package org.agoncal.fascicle.jpa.integrating.cdi;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCdiTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(GreetingService.class)
        .activate(RequestScoped.class)
        .inject(this)
        .build();

    @Inject
    private GreetingService greeter;

    @Test
    public void helloWorld() {
        assertThat(greeter.greet("Java")).isEqualTo("Hello, Java");
    }
}
