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
    private int id;
    private String name;
    private ArrayList<Pair<Double, String>> ingredients;//amount and name of ingredient
    private String description;
    private int cookTime;
    private ArrayList<Pair<Integer, String>> cookInstructions;//Step number and then instructions

    public Recipe(String name, String description, int cookTime)
    {
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        ingredients = new ArrayList<Pair<Double,String>>();
        cookInstructions = new ArrayList<Pair<Integer, String>>();
    }

    public Recipe(String name, String description, int cookTime, ArrayList<Pair<Double,String>> ingredients, ArrayList<Pair<Integer, String>> cookInstructions)
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
        cookInstructions.add(instruction);
    }

    public void RemoveInstruction(int step)
    {
       for(int j = 0; j < cookInstructions.size(); j++)
       {
           if(cookInstructions.get(j).first == step)
           {
               cookInstructions.remove(j);
           }
       }
    }

    public void setId(int value)
    {
        id = value;
    }

    public int getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getCookTime()
    {
        return cookTime;
    }

    public ArrayList<Pair<Double,String>> getIngredients()
    {
        return ingredients;
    }

    public ArrayList<Pair<Integer, String>> getCookInstructions() {
        return cookInstructions;
    }
}