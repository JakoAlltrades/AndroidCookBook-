package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    }

    private void displayRecipe()
    {
        if (recipe != null)
        {
            TextView nameV = (TextView)findViewById(R.id.recipeName);
            TextView cookTime = (TextView)findViewById(R.id.cookTime);
            TextView descV = (TextView)findViewById(R.id.recipeDescription);
            TextView instructions = (TextView)findViewById(R.id.recipeDescription);
            ListView ingredients = (ListView)findViewById(R.id.recipeIngredientsList);

        }
    }

    private void SetUpIngredientsList()
    {
        ArrayList<Ingredient> ings = recipe.getIngredients();
        String[] ingStrings = new String[ings.size()];
        for(int j = 0; j < ings.size(); ++j)
        {
            ingStrings[j] = ings.get(j).toString();
        }
    }
}
