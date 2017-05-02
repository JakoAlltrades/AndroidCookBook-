package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by chance on 5/2/2017.
 */

public class FullRecipe extends Activity {

    private Recipe recipe;
    private ArrayAdapter<String> ingredientsAdapter;
    public FullRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    public FullRecipe()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.display_recipe);
        DBHandler dbh = new DBHandler(this);
        String recipeName = getIntent().getStringExtra("recipeName");
        recipe = dbh.getRecipe(recipeName);
        displayRecipe();

    }

    private void displayRecipe()
    {
        if (recipe != null)
        {
            TextView nameV = (TextView)findViewById(R.id.recipeName);
            nameV.setText(recipe.getName());
            TextView cookTime = (TextView)findViewById(R.id.cookTime);
            cookTime.setText(recipe.getCookTime() + "");
            TextView descV = (TextView)findViewById(R.id.recipeDesc);
            descV.setText(recipe.getDescription());
            TextView instructions = (TextView)findViewById(R.id.recipeInstructions);
            instructions.setText(recipe.getCookInstructions());
            ListView ingredients = (ListView)findViewById(R.id.recipeIngredientsList);
            SetUpIngredientsList();
            ingredients.setAdapter(ingredientsAdapter);
            Log.e("TEST", recipe.getName());
        }
        else
        {
            Toast.makeText(FullRecipe.this, "Recipe is null", Toast.LENGTH_SHORT).show();
        }
    }

    private void SetUpIngredientsList()
    {
        ArrayList<Ingredient> ings = recipe.getIngredients();
        ArrayList<String> ingStrings = new ArrayList<>();
        for(int j = 0; j < ings.size(); ++j)
        {
            ingStrings.add(ings.get(j).toString());
        }
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingStrings);
    }
}
