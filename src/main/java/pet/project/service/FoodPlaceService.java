package pet.project.service;

import pet.project.model.FoodPlace;

public interface FoodPlaceService {

    boolean addFoodPlace(FoodPlace foodPlace);

    void updateFoodPlace(FoodPlace foodPlace);

    void deleteFoodPlace(FoodPlace foodPlace);
}
