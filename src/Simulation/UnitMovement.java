package Simulation;

import Fractions.Units.Unit;
import settings.CurrentGameData;

public class UnitMovement {
    public static void movement(Unit currentlyMoving) {
        int staminaLeft = currentlyMoving.getSpeed();
        int originalRange = currentlyMoving.getRange();
        Unit closestTarget = UnitAttack.findTarget(currentlyMoving, false);
        while(closestTarget == null) {
            currentlyMoving.setRange(currentlyMoving.getRange() + 1);
            closestTarget = UnitAttack.findTarget(currentlyMoving, false);
        }
        int x = currentlyMoving.getPositionX();
        int y = currentlyMoving.getPositionY();
        while(staminaLeft > 0) {
            staminaLeft--;
            if(Math.abs(x - closestTarget.getPositionX()) > Math.abs(y - closestTarget.getPositionY())) {
                if(x - closestTarget.getPositionX() > 0) x--;
                else x++;
            }
            else {
                if(y - closestTarget.getPositionY() > 0) y--;
                else y++;
            }
        }
        CurrentGameData.battleMap.move(currentlyMoving, x, y);
    }
}