package org.example.designpattern.mediatepattern;

public class CustomUser {
    private Mediate mediate;
    private String userName;
    public CustomUser(Mediate mediate, String userName){
        this.mediate = mediate;
        this.userName = userName;
        addCustomUser(userName);
    }
    private void addCustomUser(String userName){
        mediate.addUser(userName);
    }
    @Override
    public String toString(){
        return userName;
    }
}
