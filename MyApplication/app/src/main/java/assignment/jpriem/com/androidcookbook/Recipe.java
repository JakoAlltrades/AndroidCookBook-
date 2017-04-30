package assignment.jpriem.com.androidcookbook;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jprirm on 4/30/2017.
 */

public class Recipe {
    private String name;
    private ArrayList<Pair<Double, String>> ingredients;//amount and name of ingredient
    private String description;
    private int cookTime;
    private Map<Integer, String> cookInstructions;

    public Recipe()
    {
        ingredients = new ArrayList<Pair<Double,String>>();
        cookInstructions = new HashMap<Integer, String>();
    }

    public Recipe(String name, String description, int cookTime)
    {
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        ingredients = new ArrayList<Pair<Double,String>>();
        cookInstructions = new HashMap<Integer, String>();
    }

    public Recipe(String name, String description, int cookTime, ArrayList<Pair<Double,String>> ingredients, HashMap<Integer,String> cookInstructions)
    {
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.cookInstructions = cookInstructions;
    }

    public void AddIngredient(double amount, String ingredientName)
    {
        Pair<Double, String> ingredient = new Pair<Double,String>(amount,ingredientName);
        ingredients.add(ingredient);
    }

    public void RemoveIngredient(String ingredientName)
    {
        boolean removed = false;
        for(int j = 0; j < ingredients.size() && !removed; j++)
        {
            Pair<Double,String> ingredient = ingredients.get(j);
            if(ingredient.second.equals(ingredientName))
            {
                ingredients.remove(ingredient);
                removed = true;
            }
        }
    }

    public void AddInstruction(Pair<Integer,String> instruction)
    {
        cookInstructions.put(instruction.first, instruction.second);
    }

    public void RemoveInstruction(int step)
    {
        if(cookInstructions.containsKey(step))
        {
            cookInstructions.remove(step);
        }
    }

}
