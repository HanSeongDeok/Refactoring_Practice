package org.example.designpattern.mediatepattern;

public interface Mediate {
    void addUser(String user);
    void sendMessage(String message, CustomUser user);
}
