package Fractions.Units;

public class RangeUnit extends Unit {
    private int range;
    public RangeUnit(int hp, int dmg, int speed, int range) {
        super(hp, dmg, speed);
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
