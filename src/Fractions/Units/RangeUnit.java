package Fractions.Units;

public class RangeUnit extends Unit {
    public RangeUnit(int hp, int dmg, int speed, int range) {
        super(hp, dmg, speed, "$");
        setRange(range);
    }
}
