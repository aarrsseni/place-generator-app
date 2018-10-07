package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.dao.FoodPlaceDAO;
import pet.project.model.FoodPlace;

@Service
public class DefaultFoodPlaceService implements FoodPlaceService {

    @Autowired
    private FoodPlaceDAO foodPlaceDAO;

    @Override
    public boolean addFoodPlace(FoodPlace foodPlace) {
        if (foodPlaceDAO.foodPlaceExists(foodPlace.getName(), foodPlace.getAddress())) {
            return false;
        } else {
            foodPlaceDAO.addFoodPlace(foodPlace);
            return true;
        }
    }

    @Override
    public void updateFoodPlace(FoodPlace foodPlace) {
        foodPlaceDAO.updateFoodPlace(foodPlace);
    }

    @Override
    public void deleteFoodPlace(FoodPlace foodPlace) {
        foodPlaceDAO.deleteFoodPlace(foodPlace);
    }
}
