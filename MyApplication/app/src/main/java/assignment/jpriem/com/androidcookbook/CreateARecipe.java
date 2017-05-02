package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Matthew Balderas on 5/1/2017.
 */

public class CreateARecipe extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_a_recipe);

    }
    public void submitRecipe(View view)
    {
        EditText name = (EditText)findViewById(R.id.RecName);
        EditText desc = (EditText)findViewById(R.id.RecDesc);
        EditText inst = (EditText)findViewById(R.id.RecInst);
        //EditText addIng = (EditText)findViewById(R.id.AddIng);
        EditText cookTime = (EditText)findViewById(R.id.CookTime);

        //Recipe recipe = new Recipe();
    }
    public void sendHome(View view)
    {

    }
}
