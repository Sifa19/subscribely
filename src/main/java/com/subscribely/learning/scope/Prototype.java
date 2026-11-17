package com.subscribely.learning.scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import lombok.Getter;
import java.util.UUID;
import org.springframework.context.annotation.Lazy;

// @Component
@Lazy
@Scope("prototype")
@Getter
public class Prototype {
    private static int instanceCount = 0;
    private final int instanceId;

    public Prototype() {
        instanceId = ++instanceCount;
        System.out.println("Prototype constructor called. Instance ID: " + instanceId);
    }

    public int getInstanceId() {
        return instanceId;
    }
}