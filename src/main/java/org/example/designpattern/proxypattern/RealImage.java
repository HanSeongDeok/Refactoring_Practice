package org.example.designpattern.proxypattern;

public class RealImage implements Image{
    private String file;
    public RealImage(String file) {
        this.file = file;
        loadFromDis();
    }
    public void loadFromDis(){
        System.out.println("Loading " + file);
    }
    @Override
    public void display() {
        System.out.println("Start " + file);
    }
}
