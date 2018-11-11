package pet.project.dao;

import org.springframework.stereotype.Repository;
import pet.project.model.FoodPlace;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class DefaultFoodPlaceDAO implements FoodPlaceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FoodPlace getPlaceByID(int id) {
        return entityManager.find(FoodPlace.class, id);
    }

    @Override
    public List getPlaces() {
        return entityManager.createQuery("from FoodPlace").getResultList();
    }

    @Override
    public boolean update(FoodPlace foodPlace) {
        entityManager.persist(foodPlace);
        return true;
    }

    @Override
    public boolean foodPlaceExists(String name, String address) {
        String query = "from FoodPlace where title = :name and address = :address";
        int count = entityManager.createQuery(query).setParameter("name", name)
                .setParameter("address", address).getResultList().size();
        return count > 0;
    }

    @Override
    public void addFoodPlace(FoodPlace place) {
        update(place);
    }

    @Override
    public void updateFoodPlace(FoodPlace foodPlace) {
        FoodPlace place = getPlaceByID(foodPlace.getId());
        place.setName(foodPlace.getName());
        place.setDescription(foodPlace.getDescription());
        place.setAddress(foodPlace.getAddress());
        place.setNotes(foodPlace.getNotes());
        place.setDateTime(foodPlace.getDateTime());
        place.setFeedback(foodPlace.getFeedback());
        entityManager.flush();
    }

    @Override
    public void deleteFoodPlace(FoodPlace place) {
        entityManager.remove(getPlaceByID(place.getId()));
    }
}
