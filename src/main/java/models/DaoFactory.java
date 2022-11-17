package models;

import java.util.List;

public class DaoFactory {
    private DaoFactory() {

    }

    public static CrudDAO<Recipe> getRecipeJPADao(){
        return new RecipaJPADAO();
    }

    public static CrudDAO<Ingredient> getIngredientJPADao(){
        return new IngredientJPADAO();
    }
}
