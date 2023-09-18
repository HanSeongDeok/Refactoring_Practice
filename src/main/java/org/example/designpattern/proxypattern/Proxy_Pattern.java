package org.example.designpattern.proxypattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Proxy_Pattern {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("TEST");
        RealImage realImage = new RealImage("TEST_REAL");
        realImage.display();
        System.out.println("------------------------");
        image.display();
        image.display();
        image.display();

        List<String> measureElementList = new ArrayList<>();
        measureElementList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });
    }
}
