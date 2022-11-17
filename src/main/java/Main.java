import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import models.ConnectionManager;
import models.CrudDAO;
import models.DaoFactory;
import models.Recipe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CrudDAO<Recipe> recipeDao = DaoFactory.getRecipeJPADao();

        List<Recipe> recipes = recipeDao.findByName("Tarti");

        recipes.forEach(System.out::println);









    }
}
