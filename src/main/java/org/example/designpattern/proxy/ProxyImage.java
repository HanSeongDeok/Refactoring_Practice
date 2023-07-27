package org.example.designpattern.proxy;

import java.util.Optional;

public class ProxyImage implements Image{
    private String file;
    private RealImage realImage;
    public ProxyImage(String file){
        this.file = file;
    }
    @Override
    public void display() {
        realImage = Optional.ofNullable(realImage).orElseGet(() -> new RealImage(this.file));
        realImage.display();
    }
}
