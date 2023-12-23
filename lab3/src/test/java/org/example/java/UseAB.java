package org.example.java;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UseAB {
    private final A dependencyA;
    private final B dependencyB;

    @Inject
    public UseAB(A a, B b) {
        this.dependencyA = a;
        this.dependencyB = b;
    }

    public A getDependencyA() {
        return dependencyA;
    }

    public B getDependencyB() {
        return dependencyB;
    }
}