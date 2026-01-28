package model;

import java.util.LinkedList;
import java.util.Queue;

public class ShowSlot {
    private String startTime;
    private String endTime;
    private int capacity;
    private int bookedCount;
    Queue<WaitList> waitLists;

    public ShowSlot(String startTime, String endTime, int capacity){
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        bookedCount = 0;
        waitLists = new LinkedList<>();
    }

    public String getStartTime(){
        return startTime;
    }

    public boolean canBook(int persons){
        return (capacity - bookedCount) >= persons;
    }

    public void book(int persons){
        bookedCount += persons;
    }

    public void cancel(int persons){
        bookedCount -= persons;
    }

    public int getAvailable(){
        return (capacity - bookedCount);
    }

    public String getTimeRange(){
        return "(" + startTime + "-" + endTime + ")";
    }

    public Queue<WaitList> getWaitLists(){
        return waitLists;
    }

}
