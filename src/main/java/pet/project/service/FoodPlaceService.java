package pet.project.service;

import pet.project.model.FoodPlace;

import java.util.List;

public interface FoodPlaceService {

    boolean addFoodPlace(FoodPlace foodPlace);

    boolean addPlaceToPerson(FoodPlace foodPlace, int id);

    void updateFoodPlace(FoodPlace foodPlace);

    void deleteFoodPlace(FoodPlace foodPlace);

    List getPlaces();

    boolean getPlaceAndSetPerson(int personId, int placeId);
}
