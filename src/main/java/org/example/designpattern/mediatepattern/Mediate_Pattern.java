package org.example.designpattern.mediatepattern;

public class Mediate_Pattern {
    public static void main(String[] args) {
        Mediate mediateONE = new MediateImpl();

        CustomUser userOne = new CustomUser(mediateONE, "HAN");
        CustomUser userTwo = new CustomUser(mediateONE, "LEE");

        mediateONE.sendMessage("Hi Everyone My name is Han!, Nice to meet you",userOne);
        mediateONE.sendMessage("Hi Everyone My name is Lee!, Nice to meet you",userTwo);
    }
}
