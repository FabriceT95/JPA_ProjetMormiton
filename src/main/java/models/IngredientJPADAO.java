package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class IngredientJPADAO implements CrudDAO<Ingredient> {
    @Override
    public List<Ingredient> findAll() {
        EntityManager em = ConnectionManager.getEntityManager();
        TypedQuery<Ingredient> query = em.createQuery("select i from Ingredient i", Ingredient.class);
        List<Ingredient> ingredients = query.getResultList();
      //  em.close();
        return ingredients;
    }


    @Override
    public Optional<Ingredient> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Ingredient> findByName(String s) {
        return null;
    }

    @Override
    public List<Ingredient> findByMealType(MealType mealType) {
        return null;
    }

    @Override
    public List<Ingredient> findByKeyword(String s) {
        return null;
    }

    @Override
    public Ingredient findByRandom() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Ingredient update(Ingredient element) {
        return null;
    }

    @Override
    public boolean setMomentsOfTheDay(Ingredient element, List<Integer> momentsId) {
        return false;
    }

    @Override
    public boolean setMealTypes(Ingredient element, List<Long> mealTypesId) {
        return false;
    }

    @Override
    public List<MealType> findAllMealTypes() {
        return null;
    }

}
