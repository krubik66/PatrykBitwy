package Fractions.Units;

public abstract class Unit {
    private int hp;
    private int dmg;
    private int speed;
    private int positionX;
    private int positionY;

    public Unit(int hp, int dmg, int speed, int positionX, int positionY) {
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
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
