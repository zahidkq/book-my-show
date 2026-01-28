package model;

public class WaitList {
    private String userName;
    private int persons;

    public WaitList(String  userName, int persons){
        this.userName = userName;
        this.persons = persons;
    }
    public String getUserName(){
        return userName;
    }
    public int getPersons(){
        return persons;
    }
}
