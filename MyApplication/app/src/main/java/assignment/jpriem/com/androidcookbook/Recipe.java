package assignment.jpriem.com.androidcookbook;

import java.util.ArrayList;

/**
 * Created by jprirm on 4/30/2017.
 */

public class Recipe {
    private int id;
    private String name;
    private ArrayList<Ingredient> ingredients;//amount and name of ingredient
    private String description;
    private int cookTime;
    private String cookInstructions;

    public Recipe(String name, String description, int cookTime)
    {
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        ingredients = new ArrayList<Ingredient>();
    }

    public Recipe(String name, String description, int cookTime, ArrayList<Ingredient> ingredients,String cookInstructions)
    {
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.cookInstructions = cookInstructions;
    }

    public void AddIngredient(double amount, String ingredientName)
    {
        Ingredient ingredient = new Ingredient(ingredientName, amount);
        ingredients.add(ingredient);
    }

    public void RemoveIngredient(String ingredientName)
    {
        boolean removed = false;
        for(int j = 0; j < ingredients.size() && !removed; j++)
        {
            Ingredient ingredient = ingredients.get(j);
            if(ingredient.getIgrName().equals(ingredientName))
            {
                ingredients.remove(ingredient);
                removed = true;
            }
        }
    }

    public void setInstruction(String instruction)
    {
        this.cookInstructions = instruction;
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

    public ArrayList<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public String getCookInstructions() {
        return cookInstructions;
    }
}
