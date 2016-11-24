package eu.kielczewski.example;

/**
 * Created by quanzongwei(207127) on 2016/11/23 0023.
 */
public class A {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void foo(String name) {
        System.out.println("Hello, " + name);
    }

    public void foo2(String name) {
        System.out.println("Hello, " + name);
    }
}
