package models;

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

    E create(E element);


}
