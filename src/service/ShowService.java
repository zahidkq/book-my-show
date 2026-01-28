package service;


import enums.Genre;
import model.LiveShow;
import model.ShowSlot;
import repository.ShowRepository;
import service.strategy.RankingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShowService {
    ShowRepository showRepository = ShowRepository.getINSTANCE();
    RankingStrategy rankingStrategy;

    public void setRankingStrategy(RankingStrategy strategy){
        this.rankingStrategy = strategy;
    }

    public void registerShow(String showName, Genre genre){
        showRepository.save(new LiveShow(showName, genre));
        System.out.println(showName + " show is registered !!");
    }

    public void onboardShowSlots(String showName, List<Object[]> slots){
        LiveShow liveShow = showRepository.getShowByName(showName);
        for(Object[] slot : slots){
            liveShow.addSlot((String)slot[0], (String)slot[1], (int)slot[2]);
        }
        System.out.println("Done!");
    }

    public void showAvailByGenre(Genre genre){
        for (LiveShow show : showRepository.getAllLiveShows()) {
            if (show.getGenre() == genre) {

                List<ShowSlot> slots = new ArrayList<>(show.getSlots().values());
                rankingStrategy.rank(slots);

                for (ShowSlot slot : slots) {
                    if (slot.getAvailable() > 0) {
                        System.out.println(
                                show.getShowName() + ": " +
                                        slot.getTimeRange() + " " +
                                        slot.getAvailable()
                        );
                    }
                }
            }
        }
    }
}
