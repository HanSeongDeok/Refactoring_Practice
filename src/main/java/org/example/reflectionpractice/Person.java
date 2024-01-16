package org.example.reflectionpractice;

public class Person {
    int age;
    public Person(){
        age = 28;
    }
    public Person(int _age){
        age = _age;
    }
    public int getAge() {
        return age;
    }
    public int getFinalAge(){
        return 30;
    }

}
