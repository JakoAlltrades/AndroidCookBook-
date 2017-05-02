package assignment.jpriem.com.androidcookbook;

/**
 * Created by jprirm on 5/2/2017.
 */

public class Ingredient {
    private String igrName;
    private double igrAmount;
    private String igrmeasure;

    public Ingredient(String name, double amount, String measure)
    {
        igrName = name;
        igrAmount = amount;
        igrmeasure = measure;
    }

    public String getIgrName()
    {
        return igrName;
    }

    public String getIgrmeasure()
    {
        return igrmeasure;
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
}
