package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<E> {
    List<E> findAll();

    Optional<E> findById(Long id);

    List<E> findByName(String s);

    List<E> findByMealType(MealType mealType);

    List<E> findByKeyword(String s);
    //List<E> findByKeyWordNameMealType(String keyWord, String name, MealType mealType);

    E findByRandom();

    boolean delete(Long id);

    E update(E element);

    boolean setMomentsOfTheDay(E element, List<Integer> momentsId);
    boolean setMealTypes(E element, List<Long> mealTypesId);
    List<MealType> findAllMealTypes();

    default E create(E element) {
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            // em.close();
        }
        return element;
    }




}
