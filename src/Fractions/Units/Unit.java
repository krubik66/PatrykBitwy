package Fractions.Units;
import Fractions.Fraction;
import settings.Settings;

import javax.swing.*;

public abstract class Unit {
    private int hp;
    private int maxHP;
    private int dmg;
    private int speed;
    private int range;
    private int positionX;
    private int positionY;
    private boolean isPoisoned;
    private Fraction alliance;

    public final String icon;

    public final ImageIcon imageIcon;

    public Unit(int hp, int dmg, int speed, String icon) {
        this.hp = hp;
        this.maxHP = hp;
        this.dmg = dmg;
        this.speed = speed;
        this.range = -1;
        this.isPoisoned = false;
        this.icon = icon;
        imageIcon = new ImageIcon(icon);

    }

    public void poison() {
        this.isPoisoned = true;
    }

    public void poisonDMG() {
        if(isPoisoned) hp -= Settings.poisonDMG;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public Fraction getAlliance() {
        return alliance;
    }

    public void setAlliance(Fraction alliance) {
        this.alliance = alliance;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
