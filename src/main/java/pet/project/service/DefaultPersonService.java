package pet.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.dao.PersonDAO;
import pet.project.model.Person;

import java.util.List;

@Service
public class DefaultPersonService implements PersonService {

    @Autowired
    private PersonDAO personDAO;


    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }

    @Override
    public boolean addPerson(Person person) {
        if(personDAO.personExists(person.getFirstName(), person.getLastName())) {
            return false;
        } else {
            personDAO.addPerson(person);
            return true;
        }
    }

    @Override
    public boolean deletePerson(String firstName, String lastName) {
        if(personDAO.personExists(firstName, lastName)) {
            personDAO.deletePerson(firstName, lastName);
            return true;
        }
        return false;
    }

    @Override
    public List getPersons() {
        return personDAO.getPersons();
    }

    @Override
    public List getPlacesByPerson(int personId) {
        Person person = personDAO.getPersonById(personId);
        return person.getPlaces();
    }
}
