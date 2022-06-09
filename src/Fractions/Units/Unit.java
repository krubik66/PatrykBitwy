package Fractions.Units;
import settings.Settings;

public abstract class Unit {
    private int hp;
    private int dmg;
    private int speed;
    private int positionX;
    private int positionY;
    private boolean isPoisoned;

    public Unit(int hp, int dmg, int speed) {
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
        this.isPoisoned = false;
    }

    public void poison() {
        this.isPoisoned = true;
    }

    public void poisonDMG() {
        if(isPoisoned) hp -= Settings.poisonDMG;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
