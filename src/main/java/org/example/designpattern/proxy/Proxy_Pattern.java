package org.example.designpattern.proxy;

public class Proxy_Pattern {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("TEST");
        image.display();
        image.display();
        image.display();
    }
}
