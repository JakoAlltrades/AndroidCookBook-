package assignment.jpriem.com.androidcookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    /*

    #images Loading Optimizations
     -Scale Down image to fit container size,
     -Cache the image in memory.

     Optimizations: two options for images,
      -Implement everything ourselves,
      -Image loading managment library.
      -Universal Image Loader, Picasso, Fresco.


      #memoryleaks:
       -A static reference to your view,
       -A static instance of a class.
       -References live longer than out activity.

       #fix memory leaks
       -Make sure to clear all references to our activity.
       -Avoid static references to Activities, Views, and other android components.

       #Battery saving tips
       -put the phone into doze mode when the app is not in use.
       -you can also use battery-historian to track the android battery status.

      

     */
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
