package assignment.jpriem.com.androidcookbook;

/**
 * Created by jprirm on 5/2/2017.
 */

public class Ingredient {
    private String igrName;
    private double igrAmount;

    public Ingredient(String name, double amount)
    {
        igrName = name;
        igrAmount = amount;
    }

    public String getIgrName()
    {
        return igrName;
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

}
