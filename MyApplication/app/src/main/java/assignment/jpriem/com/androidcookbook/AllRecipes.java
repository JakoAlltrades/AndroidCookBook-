package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Matthew Balderas on 5/1/2017.
 */

public class AllRecipes extends Activity {
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private RecipeAdapter recipeAdapter;
    public Recipe selectedRecipe;
    DBHandler dbh;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.all_recipes);
        dbh = new DBHandler(this);
        addRecipeName();
        recipeAdapter = new RecipeAdapter(this, recipes);
        ListView recipesView = (ListView)findViewById(R.id.RecipesView);
        recipesView.setAdapter(recipeAdapter);
    }

    public void addRecipeName()
    {
        recipes = dbh.getAllRecipes();

//        dbh.addRecipe(r);
//        dbh.addRecipe(r1);
//        dbh.addRecipe(r2);
//        dbh.addRecipe(r3);

    }

    public void onRecipeClick(View view)
    {
        int index = (Integer)view.getTag();
        if (index < recipes.size())
        {
            selectedRecipe = recipes.get(index);
            fullRecipe();
        }
    }

    public void fullRecipe()
    {
        Intent myIntent = new Intent(AllRecipes.this, FullRecipe.class);
        myIntent.putExtra("recipeName", selectedRecipe.getName());
        startActivity(myIntent);
    }



}
