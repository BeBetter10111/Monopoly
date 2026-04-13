package main.java.cooking.player;

import main.java.domain.Dish;
import.main.java.domain.Recipe;

public interface IPlayer {
    String getName();
    Dish cook(Recipe recipe);
    int getScore();
    void addScore(int points);
    void resetScore();
}
