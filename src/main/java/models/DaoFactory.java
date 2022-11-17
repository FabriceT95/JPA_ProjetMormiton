package models;

import java.util.List;

public class DaoFactory {
    private DaoFactory() {

    }

    public static CrudDAO<Recipe> getRecipeJPADao(){
        return new RecipaJPADAO();
    }
}
