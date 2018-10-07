package pet.project.dao;

import pet.project.model.FoodPlace;

public interface FoodPlaceDAO {

    boolean foodPlaceExists(String name, String address);

    void addFoodPlace(FoodPlace place);

    void updateFoodPlace(FoodPlace place);

    void deleteFoodPlace(FoodPlace place);

    FoodPlace getPlaceByID(int id);

}
