package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipaJPADAO implements CrudDAO<Recipe>{

   /* private static final EntityManager em;

    static {
        em = ConnectionManager.getEntityManager();
    }*/

    @Override
    public List<Recipe> findAll() {
        EntityManager em = ConnectionManager.getEntityManager();
        TypedQuery<Recipe> query = em.createQuery("select r from Recipe r", Recipe.class);
        List<Recipe> recipes = query.getResultList();
        em.close();
        return recipes;
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        EntityManager em = ConnectionManager.getEntityManager();
        return Optional.of(em.find(Recipe.class, id));
    }

    @Override
    public List<Recipe> findByName(String s) {
        EntityManager em = ConnectionManager.getEntityManager();
        Query query = em.createQuery("select r from Recipe r where r.title LIKE :s ");
        query.setParameter("s", "%"+s+"%");
        return (List<Recipe>) query.getResultList();
    }

    @Override
    public List<Recipe> findByMealType(MealType mealType) {
        return null;
    }

    @Override
    public List<Recipe> findByKeyword(String s) {
        return null;
    }

    @Override
    public Recipe findByRandom() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Recipe update(Recipe element){
        return null;
    }

    @Override
    public boolean setMomentsOfTheDay(Recipe element, List<Integer> momentsId)  {
        return false;
    }

    @Override
    public boolean setMealTypes(Recipe element, List<Long> mealTypesId)  {
        return false;
    }

    @Override
    public List<MealType> findAllMealTypes() {
        return null;
    }

    @Override
    public Recipe create(Recipe element) {
        return null;
    }
}
