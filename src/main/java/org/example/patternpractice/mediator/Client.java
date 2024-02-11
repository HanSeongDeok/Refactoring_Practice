package org.example.patternpractice.mediator;

public class Client {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();

        ChatUser user1 = new ChatUser("Han", room);
        ChatUser user2 = new ChatUser("Seong", room);
        ChatUser user3 = new ChatUser("Deok", room);

        room.addChatUser(user1);
        room.addChatUser(user2);
        room.addChatUser(user3);

        user1.sendMessage("Hi");
        user2.sendMessage("Good");
        user3.sendMessage("Wow");
    }
}
