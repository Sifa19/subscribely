package com.subscribely.learning.scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import com.subscribely.learning.scope.Prototype;
import lombok.Getter;
import java.util.UUID;

// @Component
@Getter
@Scope("singleton")
public class PrototypeInsideSingleton {
    private final String id = UUID.randomUUID().toString();
    private Prototype prototype;

    public PrototypeInsideSingleton(Prototype prototype) {
        this.prototype = prototype;
        System.out.println("PrototypeInsideSingleton constructor called. Instance ID: " + id);
        System.out.println("PrototypeInsideSingleton is creating a new Prototype instance."+
                " Prototype instance ID: " + prototype.getInstanceId());
    }

}