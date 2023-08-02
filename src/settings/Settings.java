package settings;

import Battle_Map.BattleMap;
import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.Skills.ElvenSkill;
import Fractions.Units.Skills.HumanSkill;
import Fractions.Units.Skills.OrcSkill;
import Fractions.Units.Skills.UndeadSkill;
import Fractions.Units.SpecialUnit;

public class Settings {
    // game settings
    public static int mapSize = 20;


    // ------------------------------------------------

    // common stats (also Humans)
    public static int HP = 20;
    public static int meleeSpeed = 3;
    public static int rangeSpeed = 1;
    public static int range = 3;
    public static int DMG = 4;

    // ------------------------------------------------

    //              Human Settings

    // Paladin (melee)
    public static MeleeUnit Paladin() { return new MeleeUnit(HP, DMG, meleeSpeed);}

    // Marksman (ranged)
    public static RangeUnit Marksman() { return new RangeUnit(HP, DMG, rangeSpeed, range);}

    // Priest (special)
    public static SpecialUnit Priest() { return new SpecialUnit(HP * 5, DMG * 4, meleeSpeed, range, new HumanSkill(), 3);}

    public static int HealAmount = HP / 2;

    // ------------------------------------------------

    //              Orc settings

    // Grunt (melee)
    public static MeleeUnit Grunt() { return new MeleeUnit(HP, DMG + 1, meleeSpeed - 1);}

    // Hunter (range)
    public static RangeUnit Hunter() { return new RangeUnit(HP, DMG, rangeSpeed + 1, range);}

    // Shaman (special)
    public static SpecialUnit Shaman() { return new SpecialUnit(HP * 5, DMG * 4, rangeSpeed, range * 2, new OrcSkill(), 1);}

    public static int poisonDMG = 1;

    // -------------------------------------------------

    //              Elf settings

    // Bladedancer (melee)
    public static MeleeUnit Bladedancer() { return new MeleeUnit((int) (HP * 0.8), DMG + 2, meleeSpeed + 1);}

    // Archer (range)
    public static RangeUnit Bloodmage() { return new RangeUnit((int) (HP * 0.8), DMG, rangeSpeed + 1, range + 1);}

    // Teleporter (special)
    public static SpecialUnit Portal() { return new SpecialUnit(HP * 10, 0, 0, range * 10, new ElvenSkill(), 4);}

    //              Undead settings

    // Zombie (melee)
    public static MeleeUnit Zombie() { return new MeleeUnit(HP * 2, DMG / 4, meleeSpeed / 2);}

    // SkeletonArcher (range)
    public static RangeUnit SkeletonArcher() { return new RangeUnit(HP /2 , DMG + 1, meleeSpeed, range);}

    // Vampire (special)
    public static SpecialUnit Vampire() { return new SpecialUnit(HP * 10, DMG * 2, meleeSpeed + 5, -1, new UndeadSkill(), 0);}

    // passive skill
    public static int bodiesRequiredToResurrect = 3;
}
