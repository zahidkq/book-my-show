package model;


import enums.Genre;
import exceptions.SlotOverLappingException;

import java.util.HashMap;
import java.util.Map;

public class LiveShow {
    private String showName;
    private Genre genre;
    private Map<String, ShowSlot> showSlotMap;

    public LiveShow(String showName, Genre genre){
        this.showName = showName;
        this.genre = genre;
        showSlotMap = new HashMap<>();
    }

    public void addSlot(String start, String end, int capacity){
        if(showSlotMap.containsKey(start)){
            throw new SlotOverLappingException("Slot time is Overlapping");
        }
        showSlotMap.put(start, new ShowSlot(start, end, capacity));
    }

    public String getShowName(){
        return showName;
    }
    public Genre getGenre(){
        return genre;
    }
    public Map<String, ShowSlot> getSlots(){
        return showSlotMap;
    }
}
