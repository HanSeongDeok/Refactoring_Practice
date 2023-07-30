package org.example.designpattern.proxy;

public class Proxy_Pattern {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("TEST");
        RealImage realImage = new RealImage("TEST_REAL");
        realImage.display();
        System.out.println("------------------------");
        image.display();
        image.display();
        image.display();
    }
}
