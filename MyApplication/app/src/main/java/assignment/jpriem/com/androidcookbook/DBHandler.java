package assignment.jpriem.com.androidcookbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jprirm on 4/30/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    private int columnID = 1;
    private int curId = GetCurID();
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "recipeInfo";
    // Contacts table name
    private static final String TABLE_RECIPES = "recipes";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_COOK_TIME = "cook_time";
    private static final String KEY_INGREDIENTS = "ingredients";
    private static final String KEY_INSTRUCTIONS = "cook_instructions";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_RECIPES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_COOK_TIME + " TEXT,"
                + KEY_INGREDIENTS + " TEXT,"
                + KEY_INSTRUCTIONS + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
// Creating tables again
        onCreate(db);
    }

    public int GetCurID()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        
        String selectQuery = "SELECT * FROM " + TABLE_RECIPES;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
// looping through all rows and adding to list
        int Id =0;
        if (cursor.moveToFirst()) {
            do {
                Id = Integer.parseInt(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        Id = Id + 1;
        return Id;
    }

    // Adding new shop
    public void addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();

        JSONArray jsonArray = null;
        ContentValues values = new ContentValues();
        values.put(KEY_ID, curId);
        curId++;
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_DESCRIPTION, recipe.getDescription());
        values.put(KEY_COOK_TIME, recipe.getCookTime());
        //To add the arrayLists for ingredients and instructions need to become json objects
        values.put(KEY_INSTRUCTIONS, recipe.getCookInstructions());
        String ingredients = new Gson().toJson(recipe.getIngredients());
        try {
            jsonArray = new JSONArray(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        values.put(KEY_INGREDIENTS, jsonArray.toString());
// Inserting Row
        db.insert(TABLE_RECIPES, null, values);
        db.close(); // Closing database connection
    }

    public Recipe getRecipe(String title) {
        SQLiteDatabase db = this.getReadableDatabase();
        Recipe recipe = null;
        String selectQuery = "SELECT * FROM " + TABLE_RECIPES;
        ArrayList<Ingredient> ingredients = null;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do {
                String curRecipeTitle = cursor.getString(1);
                if (curRecipeTitle.equals(title)) {
                    int time = Integer.parseInt(cursor.getString(3));
                    //need to get the arraylist from the json objects

                    try {
                        JSONArray objects = new JSONArray(cursor.getString(4));
                        ingredients = JSONArrayToIngredientList(objects);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    recipe = new Recipe(cursor.getString(1), cursor.getString(2), time, ingredients, cursor.getString(5));
                }
            } while (cursor.moveToNext() && recipe == null);
        }
        return recipe;
    }

    private ArrayList<Ingredient> JSONArrayToIngredientList(JSONArray array)
    {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for(int j = 0; j < array.length(); j++)
        {
            JSONObject i = null;
            try {
                i = (JSONObject) array.get(j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(i != null)
            {
                try {


                    Ingredient ing = new Ingredient(i.getString("igrName"), i.getDouble("igrAmount"), i.getString("igrMeasure"));
                    ingredients.add(ing);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return ingredients;
    }

    // Getting All Shops
    public ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> shopList = new ArrayList<Recipe>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_RECIPES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int time = Integer.parseInt(cursor.getString(3));
                //need to get the arraylist from the json objects

                try {
                    JSONArray objects = new JSONArray(cursor.getString(4));
                    ingredients = JSONArrayToIngredientList(objects);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Recipe recipe = new Recipe(cursor.getString(1), cursor.getString(2), time, ingredients, cursor.getString(5));
                recipe.setId(Integer.parseInt(cursor.getString(0)));
// Adding contact to list
                shopList.add(recipe);
            } while (cursor.moveToNext());
        }

// return contact list
        return shopList;
    }
    // Getting shops Count
    public int getRecipeCount() {
        int count;
        String countQuery = "SELECT * FROM " + TABLE_RECIPES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        count  = cursor.getCount();
        cursor.close();

// return count
        return count;
    }
    // Updating a shop
    public int updateRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        JSONArray jsonArray = null;
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_COOK_TIME, recipe.getCookTime());
        values.put(KEY_DESCRIPTION, recipe.getDescription());
        //need to get the arraylist from the json objectsvalues.put(KEY_INSTRUCTIONS, recipe.getCookInstructions());
        String ingredients = new Gson().toJson(recipe.getIngredients());
        try {
            jsonArray = new JSONArray(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        values.put(KEY_INGREDIENTS, jsonArray.toString());
// Inserting Row
// updating row
        return db.update(TABLE_RECIPES, values, KEY_NAME + " = ?",
                new String[]{String.valueOf(recipe.getName())});
    }

    // Deleting a recipe
    public void deleteRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RECIPES, KEY_NAME + " = ?",
                new String[] { String.valueOf(recipe.getName()) });
        db.close();
    }
}