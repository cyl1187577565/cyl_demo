package jvm.spi;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<Person> load = ServiceLoader.load(Person.class);
    }
}
