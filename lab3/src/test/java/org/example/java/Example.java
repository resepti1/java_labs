package org.example.java;

import org.example.Container;
import org.example.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        System.out.println(container.getComponent(A.class));
        System.out.println(bAsSingleton);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        System.out.println(container.getComponent(UseA.class));
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void shouldInjectABDependencies() {
        final UseAB useAB1 = container.getComponent(UseAB.class);
        final UseAB useAB2 = container.getComponent(UseAB.class);

        assertSame("expected UseAB instances to be the same", useAB1, useAB2);

        assertSame("expected the same A instance in UseAB", useAB1.getDependencyA(), container.getComponent(A.class));
        assertSame("expected the same B instance in UseAB", useAB1.getDependencyB(), container.getComponent(B.class));
    }
}
