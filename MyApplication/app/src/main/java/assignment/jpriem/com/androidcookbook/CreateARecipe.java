package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Matthew Balderas on 5/1/2017.
 */

public class CreateARecipe extends Activity{

    DBHandler db;
    ArrayList<Ingredient> ingredients;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_a_recipe);
        ingredients = new ArrayList<Ingredient>();
        db = new DBHandler(this);
    }
    public void submitRecipe(View view)
    {
        EditText name = (EditText)findViewById(R.id.RecName);
        EditText desc = (EditText)findViewById(R.id.RecDesc);
        EditText inst = (EditText)findViewById(R.id.RecInst);
        //EditText addIng = (EditText)findViewById(R.id.AddIng);
        EditText cookTime = (EditText)findViewById(R.id.CookTime);
        int intCookTime = Integer.parseInt(cookTime.getText().toString());
        Recipe recipe = new Recipe(name.getText().toString(), desc.getText().toString(), intCookTime, ingredients,inst.getText().toString());
        db.addRecipe(recipe);
<<<<<<< HEAD

=======
>>>>>>> origin/master
    }
    public void sendHome(View view)
    {
        Intent myIntent = new Intent(CreateARecipe.this,MainActivity.class);
        startActivity(myIntent);
    }
    public void addIngredient(View view)
    {
        EditText amount = (EditText)findViewById(R.id.Amount);
        EditText unit = (EditText)findViewById(R.id.units);
        EditText addIng = (EditText)findViewById(R.id.AddIng);
        double doubleAmount = Double.parseDouble(amount.getText().toString());
        Ingredient ingredient = new Ingredient(addIng.getText().toString(),doubleAmount, unit.getText().toString());
        ingredients.add(ingredient);
    }

}
