package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Matthew Balderas on 5/1/2017.
 */

public class AllRecipes extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.all_recipes);
    }


}
