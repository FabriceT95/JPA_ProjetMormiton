import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import models.*;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        CrudDAO<Recipe> recipeDao = DaoFactory.getRecipeJPADao();
        CrudDAO<Ingredient> ingredientDao = DaoFactory.getIngredientJPADao();
        Set<Ingredient> ingredientSelected = new HashSet<>();
        Recipe newRecipe = new Recipe();

        while(true) {
            System.out.println("1 - Voir les recettes");
            System.out.println("2 - Créer une recette");
            int choix = recupererEntier("");
            switch (choix) {
                case 1:
                    recipeDao.findAll().forEach(System.out::println);
                    break;
                case 2 :
                    int ch1 = 0;
                    do {
                        System.out.println("Voici les ingrédients : ");
                        List<Ingredient> ingredients = ingredientDao.findAll();

                        for(int i = 0; i < ingredients.size(); i++) {
                            System.out.println((i+1) + " - " + ingredients.get(i).getName());
                        }

                        ch1 = recupererEntier("Votre recette nécessite elle de nouveaux ingrédients (1/0) ?");
                        if(ch1 == 1) {
                            String ingrName = recupererString("Saisissez votre ingrédient");
                            Ingredient ingr = new Ingredient(ingrName);
                            ingredientDao.create(ingr);
                            ingredientSelected.add(ingr);


                        }
                    } while (ch1 == 1);



                    String recipe_name = recupererString("Quel est le nom de votre recette ?");
                   /* String steps = recupererString("Décrivez les étapes à réaliser");
                    int servings = recupererEntier("Saisissez le nombre de parts");
                    int prepDuration = recupererEntier("Saisissez la durée de préparation en minutes");
                    int bakingTime = recupererEntier("Saisissez la durée de cuisson en minutes");
                    int restTime = recupererEntier("Saisissez le temps de repos en minutes");
                    float cost = (float) recupererEntier("Saisissez le coût de la recette");
                    String notes = recupererString("Ajoutez un message concernant votre recette");*/

                    newRecipe.setTitle(recipe_name);





                    int ch2 = 0;
                    do {
                        System.out.println("Voici les ingrédients déjà présent dans votre recette : ");
                        ingredientSelected.forEach(e -> System.out.println(e.getName()));

                        ch2 = recupererEntier("Voulez-vous rajouter de nouveaux ingrédients ?");
                        if(ch2 == 1) {

                            System.out.println("Voici les ingrédients : ");
                            List<Ingredient> ingredients = ingredientDao.findAll();
                            for (int i = 0; i < ingredients.size(); i++) {
                                System.out.println((i + 1) + " - " + ingredients.get(i).getName());
                            }

                            int ingrToAdd = recupererEntier("Sélectionnez le numéro de l'ingrédient à ajouter : ");

                            ingredientSelected.add(ingredients.get(ingrToAdd - 1));

                            System.out.println("Voici les ingrédients que vous avez maintenant :");
                            List<Ingredient> tempIngrSelected = new ArrayList<>(ingredientSelected);
                            for (int i = 0; i < ingredientSelected.size(); i++) {
                                System.out.println((i + 1) + " - " + tempIngrSelected.get(i).getName());
                            }
                        }
                    } while (ch2 == 1);
                    newRecipe.setCooking(new Cooking(1L, "Pas de cuisson"));
                    newRecipe.setIngredientList(ingredientSelected);
                    recipeDao.create(newRecipe);
            }

        }



       // EntityManager em = ConnectionManager.getEntityManager();
      /*Recipe recipe = new Recipe();
        recipe.setTitle("Gateau au chocolat !");
        recipe.setIngredientList(Arrays.asList(
                new Ingredient("Pomme de terre"),
                new Ingredient("Vin"),new Ingredient("Cannelle")));
        recipeDao.create(recipe);*/













    }

    public static int recupererEntier(String message){
        Scanner sc = new Scanner(System.in);
        if(message.length() > 0) System.out.println(message);
        return sc.nextInt();
    }
    public static String recupererString(String message){
        Scanner sc = new Scanner(System.in);
        if(message.length() > 0) System.out.println(message);
        return sc.nextLine();
    }
}
