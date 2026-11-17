package com.subscribely.learning.lifecycle;
import org.springframework.stereotype.Component;
import com.subscribely.learning.scope.Singleton;
import com.subscribely.learning.scope.Prototype;

// @Component
public class DemoBean {
    public DemoBean() {
            System.out.println("DemoBean constructor called");
    }

    public void initDemoBean() {
        System.out.println("DemoBean init method called");
    }

    public void destroyDemoBean() {
        System.out.println("DemoBean destroy method called");
    }

}