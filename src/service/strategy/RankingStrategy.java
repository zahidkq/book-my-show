package service.strategy;


import model.ShowSlot;

import java.util.List;

public interface RankingStrategy {
    List<ShowSlot> rank(List<ShowSlot> slotList);
}
