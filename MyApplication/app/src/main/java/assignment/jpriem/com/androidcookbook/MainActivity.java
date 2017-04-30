package assignment.jpriem.com.androidcookbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recipe pie = new Recipe("Pie", "A apple pie", 45);
        HashMap<Integer, String> instructions = new HashMap<Integer, String>();
        ArrayList<Pair<Double,String>> ingredients = new ArrayList<Pair<Double, String>>();
        pie.AddInstruction(new Pair<Integer, String>(1, "Pre-heat the oven to 400 degrees"));
        pie.AddIngredient(1.0, "Pie crust");
        pie.RemoveIngredient("Pie crust");
        pie.RemoveInstruction(1);
    }
}
