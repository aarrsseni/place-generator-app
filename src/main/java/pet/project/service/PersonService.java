package pet.project.service;

import pet.project.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(int id);

    boolean addPerson(Person person);

    boolean deletePerson(String firstName, String lastName);

    List getPersons();

    List getPlacesByPerson(int personId);
}
