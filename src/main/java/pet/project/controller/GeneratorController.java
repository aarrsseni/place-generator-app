package pet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.project.model.FoodPlace;
import pet.project.service.GeneratorService;

import java.util.Collections;
import java.util.List;

@RestController
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @RequestMapping(value = "/getRandomPlace", method = RequestMethod.GET)
    public FoodPlace getRandomPlace(@RequestParam("person-id") int personId) {
        return generatorService.generateForPerson(personId);
    }

    @RequestMapping(value = "/getRandomPlaceForPersons", method = RequestMethod.GET)
    public FoodPlace getRandomPlaceForPersons(@RequestParam("persons") List<Integer> ids) {
        return generatorService.generateForPersons(ids);
    }
}
