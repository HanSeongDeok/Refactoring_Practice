package org.example.patternpractice.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Mediator {
    List<ChatUser> list = new ArrayList<>();
    public ChatRoom(){}
    public void addChatUser(ChatUser user){
        list.add(user);
    }
    public void sendMessage(ChatUser user, String message){
        list.stream()
                .filter(u -> u!=user)
                .forEach(u -> receiveMessage(message, u, user));
        System.out.println();
    }

    private void receiveMessage(String message, ChatUser ...user) {
        System.out.println("From " + user[1].name);
        user[0].receiveMessage(user[0], message);
    }
}
