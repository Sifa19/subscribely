package com.subscribely.learning.lifecycle;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import com.subscribely.learning.scope.Singleton;
import com.subscribely.learning.scope.Prototype;
import com.subscribely.learning.lifecycle.DemoBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// @Component
public class LifecycleDemoBean implements BeanNameAware, InitializingBean, DisposableBean,BeanPostProcessor {

    private Singleton singleton;
    private Prototype prototype;
    private DemoBean demoBean;
    
    public LifecycleDemoBean(Singleton singleton, Prototype prototype, DemoBean demoBean) {
        this.singleton = singleton;
        this.prototype = prototype;
        this.demoBean = demoBean;
        System.out.println("LifecycleDemoBean constructor called with singleton: " + singleton.getId() + " and prototype: " + prototype.getInstanceId());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization called for: " + beanName);
        return bean; // You must return the bean!
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization called for: " + beanName);
        return bean; // You must return the bean!
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("LifecycleDemoBean @PostConstruct called");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("LifecycleDemoBean @PreDestroy called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("LifecycleDemoBean setBeanName called with name: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleDemoBean afterPropertiesSet called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleDemoBean destroy called");
    }

}