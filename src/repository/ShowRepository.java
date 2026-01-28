package repository;


import model.LiveShow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShowRepository {
    private static ShowRepository INSTANCE = new ShowRepository();
    Map<String, LiveShow> showMap;

    private ShowRepository(){
        showMap = new HashMap<>();
    }

    public static ShowRepository getINSTANCE(){
        return INSTANCE;
    }
    public void save(LiveShow liveShow){
        this.showMap.put(liveShow.getShowName(), liveShow);
    }
    public void remove(String showName){
        this.showMap.remove(showName);
    }

    public LiveShow getShowByName(String showName){
        return this.showMap.get(showName);
    }

    public Collection<LiveShow> getAllLiveShows(){
        return this.showMap.values();
    }
}
