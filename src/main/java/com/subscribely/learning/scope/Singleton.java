package com.subscribely.learning.scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import lombok.Getter;
import java.util.UUID;

// @Component
@Getter
@Scope("singleton")
public class Singleton {
    private final String id = UUID.randomUUID().toString();

    private Singleton() {
        System.out.println("Singleton constructor called. ID: " + id);
    }

}