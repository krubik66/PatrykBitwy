package Fractions.Units;

public class RangeUnit extends Unit {
    private int range;
    public RangeUnit(int hp, int dmg, int speed, int positionX, int positionY, int range) {
        super(hp, dmg, speed, positionX, positionY);
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
