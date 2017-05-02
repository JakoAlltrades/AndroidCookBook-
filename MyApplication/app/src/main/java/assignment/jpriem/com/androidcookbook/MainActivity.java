package assignment.jpriem.com.androidcookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DBHandler dBhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dBhandler = new DBHandler(this);
        //dBhandler.onUpgrade(openOrCreateDatabase("recipeInfo", MODE_PRIVATE, null),1, 2);

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
