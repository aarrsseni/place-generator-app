package pet.project.dao;

import org.springframework.stereotype.Repository;
import pet.project.model.FoodPlace;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
    public boolean foodPlaceExists(String name, String address) {
        String query = "from FoodPlace where NAME = :name and ADDRESS = :address";
        int count = entityManager.createQuery(query).setParameter("name", name)
                .setParameter("address", address).getResultList().size();
        return count > 0 ? true : false;
    }

    @Override
    public void addFoodPlace(FoodPlace place) {
        entityManager.persist(place);
    }

    @Override
    public void updateFoodPlace(FoodPlace foodPlace) {
        FoodPlace place = getPlaceByID(foodPlace.getId());
        place.setName(foodPlace.getName());
        place.setDescription(foodPlace.getDescription());
        place.setAddress(foodPlace.getAddress());
        place.setNotes(foodPlace.getNotes());
        entityManager.flush();
    }

    @Override
    public void deleteFoodPlace(FoodPlace place) {
        entityManager.remove(getPlaceByID(place.getId()));
    }
}
