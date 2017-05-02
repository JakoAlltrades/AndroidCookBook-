package assignment.jpriem.com.androidcookbook;

import java.util.AbstractMap;

/**
 * Created by jprirm on 5/2/2017.
 */

public class Ingredient {
    private String igrName;
    private double igrAmount;
    private String igrMeasure;

    public Ingredient(String name, double amount, String measure)
    {
        igrName = name;
        igrAmount = amount;
        igrMeasure = measure;
    }

    public String getIgrName()
    {
        return igrName;
    }

    public String getIgrmeasure()
    {
        return igrMeasure;
    }

    public double getIgrAmount()
    {
        return igrAmount;
    }

    public void setIgrName(String value)
    {
        igrName = value;
    }

    public void setIgrAmount(double value)
    {
        igrAmount = value;
    }

    public void setIgrmeasure(String value)
    {
        igrName = value;
    }

    @Override
    public String toString()
    {
        String s = igrAmount + " " + igrMeasure + " " + igrName;
        return s;
    }
}
