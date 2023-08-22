package org.example.designpattern.mediatepattern;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MediateImpl implements Mediate{
    private List<String> users;
    public MediateImpl(){
        users = new LinkedList<>();
    }
    @Override
    public void addUser(String user) {
        users.add(user);
    }
    @Override
    public void sendMessage(String message, CustomUser user) {
        users.stream()
                .filter(u -> !u.equalsIgnoreCase(user.toString()))
                .forEach(u -> System.out.println("Receive Users: " + u + " - [" + message +"]"));
    }
}
