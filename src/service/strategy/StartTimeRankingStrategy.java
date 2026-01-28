package service.strategy;


import model.ShowSlot;

import java.util.Comparator;
import java.util.List;

public class StartTimeRankingStrategy implements RankingStrategy{
    @Override
    public List<ShowSlot> rank(List<ShowSlot> lists){
        lists.sort(Comparator.comparing(ShowSlot::getStartTime));
        return lists;
    }
}
