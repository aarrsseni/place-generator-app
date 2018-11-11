package pet.project.dao;

import org.springframework.stereotype.Repository;
import pet.project.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class DefaultPersonDAO implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person getPersonById(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public boolean personExists(String name, String lastName) {
        String query = "from Person where first_name = :name and last_name = :lastName";
        int count = entityManager.createQuery(query).setParameter("name", name)
                .setParameter("lastName", lastName).getResultList().size();
        return count > 0;
    }

    @Override
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void deletePerson(String name, String lastName) {
        String query = "from Person where first_name = :name and last_name = :lastName";
        Person person = (Person)entityManager.createQuery(query).setParameter("name", name)
                .setParameter("lastName", lastName).getResultList().get(0);
        entityManager.remove(person);
    }

    @Override
    public List getPersons() {
        return entityManager.createQuery("from Person").getResultList();
    }
}
