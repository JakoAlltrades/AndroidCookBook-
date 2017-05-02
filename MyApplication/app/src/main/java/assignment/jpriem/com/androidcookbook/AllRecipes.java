package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Matthew Balderas on 5/1/2017.
 */

public class AllRecipes extends Activity {
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private RecipeAdapter recipeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.all_recipes);
        addRecipeName();
        recipeAdapter = new RecipeAdapter(this, recipes);
        ListView recipesView = (ListView)findViewById(R.id.RecipesView);
        recipesView.setAdapter(recipeAdapter);
    }

    public void addRecipeName()
    {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("flour", 2));
        ingredients.add(new Ingredient("Eggs", 3));
        ingredients.add(new Ingredient("Sugar", 1.5));

        Recipe r = new Recipe("Cake", "just a cake", 60, ingredients, "Mix ingredients and Bake");
        Recipe r1 = new Recipe("Cookies", "just a cake", 60, ingredients, "Mix ingredients and Bake");
        Recipe r2 = new Recipe("Bread", "just a cake", 60, ingredients, "Mix ingredients and Bake");
        Recipe r3 = new Recipe("Brownies", "just a cake", 60, ingredients, "Mix ingredients and Bake");
        recipes.add(r);
        recipes.add(r1);
        recipes.add(r2);
        recipes.add(r3);
//        recipeNames.add("Cake");
//        recipeNames.add("Chocolate Cake");
//        recipeNames.add("Chocolate Chip Cookies");
//        recipeNames.add("Brownies");
//        recipeNames.add("Snickerdoodles");
//        recipeNames.add("Calzones");
//        recipeNames.add("Fried Rice");

    }



}
