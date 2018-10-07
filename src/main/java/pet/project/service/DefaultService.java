package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.model.FoodPlace;

@Service
public class DefaultService {

    @Autowired
    private FoodPlaceService foodPlaceService;

    public void test() {
        FoodPlace foodPlace = new FoodPlace();
        foodPlace.setName("TEST");
        foodPlace.setDescription("TEST");
        foodPlaceService.addFoodPlace(foodPlace);
        System.out.println("Test");
    }
}
