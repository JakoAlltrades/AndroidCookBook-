package assignment.jpriem.com.androidcookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chance on 5/1/2017.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes) {
        super(context, 0, recipes);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        Recipe recipe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_recipe, parent, false);
        }

        TextView rName = (TextView) convertView.findViewById(R.id.recipeNameBox);
        TextView rDesc = (TextView) convertView.findViewById(R.id.recipeDescription);

        rName.setText(recipe.getName());
        rDesc.setText(recipe.getDescription());
        rName.setTag(position);
        rDesc.setTag(position);

        return convertView;
    }


}
