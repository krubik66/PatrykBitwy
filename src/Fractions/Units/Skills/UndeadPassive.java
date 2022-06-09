package Fractions.Units.Skills;

import Battle_Map.Title;
import Fractions.Undead;
import settings.Settings;

public class UndeadPassive {
    public void passive(Title title) {
        if(title.getDeadBodies() >= Settings.bodiesRequiredToResurrect && title.getUnit() == null) {
            title.setDeadBodies(0);
            title.setUnit(Undead.addMelee());
        }
    }
}
