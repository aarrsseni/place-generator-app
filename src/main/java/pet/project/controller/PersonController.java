package pet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.project.model.Person;
import pet.project.service.PersonService;

import java.util.Collections;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        return personService.addPerson(person) ? ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/removePerson", method = RequestMethod.GET)
    public String removePerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return personService.deletePerson(firstName, lastName) ? "success" : "fail";
    }

    @RequestMapping(value = "/getPersons", method = RequestMethod.GET)
    public List getPersons() {
        return personService.getPersons();
    }

    @RequestMapping(value = "getPlacesByPerson", method = RequestMethod.GET)
    public List getPlacesByPerson(@RequestParam("person-id") int personId) {
        List places = personService.getPlacesByPerson(personId);
        return places != null || !places.isEmpty() ? places : Collections.emptyList();
    }
}
