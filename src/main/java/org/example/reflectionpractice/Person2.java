package org.example.reflectionpractice;

public class Person2 {
    String name;
    int age;
    public Person2(String name){
        this.name = name;
    }
    public int getParamAge(int age) {
        this.age = age;
        return age;
    }
}
