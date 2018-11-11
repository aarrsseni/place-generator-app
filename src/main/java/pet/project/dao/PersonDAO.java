package pet.project.dao;

import pet.project.model.FoodPlace;
import pet.project.model.Person;

import java.util.List;

public interface PersonDAO {

    Person getPersonById(int id);

    boolean personExists(String name, String lastName);

    void addPerson(Person person);

    void deletePerson(String name, String lastName);

    List getPersons();

}
