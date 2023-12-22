package org.example.java;

import org.example.Container;
import org.example.Environment;
public class Main {
    public static void main(String[] args) {
        Container container;

        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
        System.out.println(container.getComponent(UseAB.class));
        System.out.println(container.getComponent(UseAB.class));
    }
}
