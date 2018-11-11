package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.model.FoodPlace;
import pet.project.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
}
