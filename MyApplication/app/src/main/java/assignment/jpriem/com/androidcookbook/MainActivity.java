package assignment.jpriem.com.androidcookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recipe pie = new Recipe("Pie", "A apple pie", 45);
        ArrayList<Pair<Integer, String>> instructions = new ArrayList<Pair<Integer, String>>();
        ArrayList<Pair<Double,String>> ingredients = new ArrayList<Pair<Double, String>>();
        pie.AddInstruction(new Pair<Integer, String>(1, "Pre-heat the oven to 400 degrees"));
        pie.AddIngredient(1.0, "Pie crust");
        pie.RemoveIngredient("Pie crust");
        pie.RemoveInstruction(1);
    }



    public void CreateRecipe(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, CreateARecipe.class);
        startActivity(myIntent);
    }


    public void AllRecipes(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, AllRecipes.class);
        startActivity(myIntent);
    }
}
