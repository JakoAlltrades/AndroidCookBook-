package assignment.jpriem.com.androidcookbook;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by chance on 5/2/2017.
 */

public class FullRecipe extends Activity {

    private Recipe recipe;
    public FullRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.display_recipe);



    }
}
