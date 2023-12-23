package org.example.java;

import org.example.Container;

public class DummyContainer implements Container {
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (clazz.equals(A.class)) {
            return (T) new A();
        }
        if (clazz.equals(B.class)) {
            return (T) new B();
        }
        return null;
    }
}
