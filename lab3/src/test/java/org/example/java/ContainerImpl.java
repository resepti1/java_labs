package org.example.java;

import org.example.Configuration;
import org.example.Container;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
public class ContainerImpl implements Container {

    public final BinderImpl binder;

    public ContainerImpl(Configuration configuration) {
        this.binder = new BinderImpl(this);
        configuration.configure(binder);
    }
    public final Map<Class<?>, Supplier<?>> prototypeSuppliers = new HashMap<>();
    public final Map<Class<?>, Object> singletonObjects = new HashMap<>();


    @Override
    @SuppressWarnings("unchecked")
    public <T> T getComponent(Class<T> clazz) {
        if (singletonObjects.containsKey(clazz)) {
            return clazz.cast(singletonObjects.get(clazz));
        } else if (prototypeSuppliers.containsKey(clazz)) {
            Supplier<?> supplier = prototypeSuppliers.get(clazz);
            return clazz.cast(supplier.get());
        }
        throw new IllegalArgumentException("no object registered for type: " + clazz.getName());
    }

}