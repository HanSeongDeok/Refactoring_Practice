package org.example.reflectionpractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DeclaredConstructor {
    static Object person;
    static Object person2;
    public static void invokeMethod(Method method) {
        try {
            System.out.println(method.invoke(person));
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void invokeMethod2(Method method) {
        try {
            System.out.println(method.invoke(person2, 21));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException{

        Class<?> test = Person.class;
        // 인자가 없는 생성자를 가지고 온다.
        Constructor<?> constructor = test.getDeclaredConstructor();
        Method[] declaredMethods = test.getDeclaredMethods();
        DeclaredConstructor.person = constructor.newInstance();

        Arrays.stream(declaredMethods)
                .forEach(DeclaredConstructor::invokeMethod);

        Class<?> test2 = Person2.class;
        // 인자가 있는 생성자를 가지고 온다.
        Constructor<?> han = test2.getDeclaredConstructor(String.class);
        Method[] declaredMethods2 = test2.getDeclaredMethods();
        DeclaredConstructor.person2 = han.newInstance("Han");

        Arrays.stream(declaredMethods2)
                .forEach(DeclaredConstructor::invokeMethod2);

        Field[] declaredFields = test2.getDeclaredFields();
        Arrays.stream(declaredFields)
                .filter(field -> field.getType().equals(String.class))
                .forEach(field -> {
                    try {
                        Person2 good = new Person2("good");
                        System.out.println(field.get(good));
                        field.set(good, "WOW");
                        System.out.println(field.get(good));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
