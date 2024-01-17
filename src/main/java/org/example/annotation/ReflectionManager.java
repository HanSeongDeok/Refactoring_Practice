package org.example.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionManager {
    public void printMethod(){
        Method[] declaredMethods = MyObject.class.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(this::isAnnotationPresent)
                .forEach(this::printAnnotationInfo);
    }
    private boolean isAnnotationPresent(Method method) {
        return method.isAnnotationPresent(MyAnnotation.class);
    }
    private void printAnnotationInfo(Method method) {
        System.out.println(method.getName() + ":" +
                method.getDeclaredAnnotation(MyAnnotation.class).value());
    }

    public static void main(String[] args) {
        new ReflectionManager().printMethod();
    }
}
