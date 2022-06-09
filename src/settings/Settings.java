package settings;

import Battle_Map.BattleMap;
import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.Skills.ElvenSkill;
import Fractions.Units.Skills.HumanSkill;
import Fractions.Units.Skills.OrcSkill;
import Fractions.Units.Skills.UndeadSkill;
import Fractions.Units.SpecialUnit;

import java.net.PortUnreachableException;

public class Settings {
    // game settings
    public static int mapSize = 100;
    public static BattleMap battleMap = new BattleMap(mapSize);

    // common stats (also Humans)
    public static int HP = 20;
    public static int meleeSpeed = 3;
    public static int rangeSpeed = 1;
    public static int range = 10;
    public static int DMG = 4;


    //              Human Settings

    // Paladin (melee)
    public static MeleeUnit Paladin = new MeleeUnit(HP, DMG, meleeSpeed);

    // Marksman (ranged)
    public static RangeUnit Marksman = new RangeUnit(HP, DMG, rangeSpeed, range);

    // Priest (special)
    public static SpecialUnit Priest = new SpecialUnit(HP * 5, DMG * 4, meleeSpeed, new HumanSkill());

    public static int Heal = HP / 2;

    // ------------------------------------------------

    //              Orc settings

    // Grunt (melee)
    public static MeleeUnit Grunt = new MeleeUnit(HP, DMG + 1, meleeSpeed - 1);

    // Hunter (range)
    public static RangeUnit Hunter = new RangeUnit(HP, DMG, rangeSpeed + 1, range);

    // Shaman (special)
    public static SpecialUnit Shaman = new SpecialUnit(HP * 5, DMG * 4, rangeSpeed, new OrcSkill());

    public static int poisonDMG = 1;

    // -------------------------------------------------

    //              Elf settings

    // Bladedancer (melee)
    public static MeleeUnit Bladedancer = new MeleeUnit((int) (HP * 0.8), DMG + 2, meleeSpeed + 1);

    // Archer (range)
    public static RangeUnit Archer = new RangeUnit((int) (HP * 0.8), DMG, rangeSpeed + 1, range + 1);

    // Teleporter (special)
    public static SpecialUnit Teleporter = new SpecialUnit(HP * 10, 0, 0, new ElvenSkill());

    //              Undead settings

    // Zombie (melee)
    public static MeleeUnit Zombie = new MeleeUnit(HP * 2, DMG / 4, meleeSpeed / 2);

    // SkeletonArcher (range)
    public static RangeUnit SkeletonArcher = new RangeUnit(HP /2 , DMG, meleeSpeed, range);

    // Vampire (special)
    public static SpecialUnit Vampire = new SpecialUnit(HP * 10, DMG * 2, meleeSpeed + 5, new UndeadSkill());

    // passive skill
    public static int bodiesRequiredToResurrect = 3;
}
