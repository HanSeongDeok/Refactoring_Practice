package org.example.patternpractice.mediator;

public class ChatUser {
    String name;
    ChatRoom chatRoom;
    public ChatUser(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }
    public void sendMessage(String message){
        System.out.println(name + " Send: " + message);
        chatRoom.sendMessage(this, message);
    }

    public void receiveMessage(ChatUser user, String message) {
        System.out.println(user.name + " Receive: " + message);
    }
}
