package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.model.FoodPlace;
import pet.project.model.Person;

import java.util.*;

@Service
public class DefaultGeneratorService implements GeneratorService {

    @Autowired
    private FoodPlaceService foodPlaceService;

    @Autowired
    private PersonService personService;

    private Random random = new Random();

    @Override
    public FoodPlace generateForPerson(int id) {
        Person person = personService.getPersonById(id);
        List places = person.getPlaces();
        return (FoodPlace) places.get(random.nextInt(places.size()));
    }

    @Override
    public FoodPlace generateForPersons(List<Integer> ids) {
        Set<FoodPlace> resultPlaces = new HashSet<>();
        for(Integer id : ids) {
            resultPlaces.addAll(personService.getPlacesByPerson(id));
        }
        return (FoodPlace) resultPlaces.toArray()[random.nextInt(resultPlaces.size())];
    }

    @Override
    public FoodPlace generateForPersonByMark(int id) {
        Person person = personService.getPersonById(id);
        List places = person.getPlaces();
        FoodPlace foodPlace = (FoodPlace) places.get(0);
        for(int i = 0; i < places.size(); i++) {
            if(((FoodPlace)places.get(i)).getFeedback() > foodPlace.getFeedback()) {
                foodPlace = (FoodPlace)places.get(i);
            }
        }
        return foodPlace;
    }

    @Override
    public FoodPlace generateForPersonsByMark(List<Integer> ids) {
        List<FoodPlace> foodPlaces = new ArrayList<>();
        for(Integer id : ids) {
            foodPlaces.add(generateForPersonByMark(id));
        }
        return foodPlaces.get(random.nextInt(foodPlaces.size()));
    }
}
