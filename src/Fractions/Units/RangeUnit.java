package Fractions.Units;

import Fractions.Fraction;

public class RangeUnit extends Unit {
    public RangeUnit(int hp, int dmg, int speed, int range) {
        super(hp, dmg, speed, "$");
        setRange(range);
    }
}
