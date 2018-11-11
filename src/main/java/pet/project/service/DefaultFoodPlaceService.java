package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.dao.FoodPlaceDAO;
import pet.project.model.FoodPlace;
import pet.project.model.Person;

import java.util.List;

@Service
public class DefaultFoodPlaceService implements FoodPlaceService {

    @Autowired
    private FoodPlaceDAO foodPlaceDAO;

    @Autowired
    private PersonService personService;

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
    public boolean addPlaceToPerson(FoodPlace foodPlace, int id) {
        Person person = personService.getPersonById(id);
        if(person == null) {
            return false;
        }
        if(foodPlaceDAO.foodPlaceExists(foodPlace.getName(), foodPlace.getAddress())) {
            foodPlace = foodPlaceDAO.getPlaceByID(foodPlace.getId());

        }
        foodPlace.addPerson(person);
        foodPlaceDAO.addFoodPlace(foodPlace);
        return true;
    }

    @Override
    public void updateFoodPlace(FoodPlace foodPlace) {
        foodPlaceDAO.updateFoodPlace(foodPlace);
    }

    @Override
    public void deleteFoodPlace(FoodPlace foodPlace) {
        foodPlaceDAO.deleteFoodPlace(foodPlace);
    }

    @Override
    public List getPlaces() {
        return foodPlaceDAO.getPlaces();
    }

    @Override
    public boolean getPlaceAndSetPerson(int personId, int placeId) {
        FoodPlace foodPlace = foodPlaceDAO.getPlaceByID(personId);
        Person person = personService.getPersonById(personId);
        if(foodPlace == null || person == null) {
            return false;
        }
        foodPlace.addPerson(person);
        return foodPlaceDAO.update(foodPlace);
    }
}
