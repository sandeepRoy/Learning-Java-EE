package cdifieldinjection.cdifieldinjection.beans;

import jakarta.enterprise.inject.spi.Bean;
import jakarta.inject.Inject;

import java.io.Serializable;

public class BeanScopes implements Serializable {

    private BeanToInject beanToInject_constructor;

    private BeanToInject beanToInject_method;

    // Field Injection
    @Inject
    private BeanToInject beanToInject_field; // Contextual Bean, taken from Container is getting Injected through a Field


    // Constructor Injection
    @Inject
    public BeanScopes(BeanToInject beanToInject) {
        this.beanToInject_constructor = beanToInject;
    }

    // Method Injection
    @Inject
    public void methodInjection(BeanToInject beanToInject) {
        this.beanToInject_method = beanToInject;
    }

    public void showData_() {
        System.out.println(beanToInject_field.showData());
        System.out.println(beanToInject_constructor.showData());
        System.out.println(beanToInject_method.showData());
    }
}