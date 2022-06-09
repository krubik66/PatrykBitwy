package Fractions;

import java.util.ArrayList;

public abstract class Fraction {
    private ArrayList unitList;
    public Fraction() {
        this.unitList = new ArrayList();
    }
    public abstract void addMelee();
    public abstract void addRange();
    public abstract void addSpecial();
    public abstract int unitsLeft();
}
