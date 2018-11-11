package pet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.project.model.FoodPlace;
import pet.project.model.Person;
import pet.project.service.FoodPlaceService;

import java.util.List;

@RestController
public class PlacesController {

    @Autowired
    private FoodPlaceService foodPlaceService;

    @RequestMapping(value = "/createPlace", method = RequestMethod.POST)
    public ResponseEntity<String> createPlace(@RequestBody FoodPlace foodPlace, @RequestParam("id") int id) {
        return foodPlaceService.addPlaceToPerson(foodPlace, id) ? ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/addPlaceToPerson", method = RequestMethod.GET)
    public ResponseEntity<String> addPlaceToPerson(@RequestParam("person-id") int personId, @RequestParam("place-id") int placeId) {
        return foodPlaceService.getPlaceAndSetPerson(personId, placeId) ? ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/getPlaces", method = RequestMethod.GET)
    public List getPlaces() {
        return foodPlaceService.getPlaces();
    }

}
