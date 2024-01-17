package org.example.annotation;

public class MyObject {
    @MyAnnotation
    public void testMethod1(){
        System.out.println("test1");
    }
    @MyAnnotation(value = "good")
    public void testMethod2(){
        System.out.println("test1");
    }
}
