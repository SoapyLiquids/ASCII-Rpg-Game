import java.util.ArrayList;

public class Monster extends Creature {
    public static Monster[] plainsMonsters = {new Monster(6, 3, 1, "Jackalope", "Fearful")
                                            , new Monster(8, 4, 0, "Wolf", "Neutral")
                                            , new Monster(12,3, 0, "Goblin", "Aggresive")
                                            , new Monster(8, 5, 1, "Slime", "Savage")
                                            , new Monster(12, 4,0, "Zombie", "Aggressive")
                                            , new Monster(8, 5, 3, "Wulfrum Golem", "Neutral")};
    String name;
    static String behavior;
    static int xpReward;
    static String effect;
    static int chance;
    static int potency;
    static boolean hasStatus = false;

    private static Monster instance;
    public static Monster getInstance(){ // Returns the only instance of the Monster class
        return instance;
    }
    
    public static void setInstance(Monster monst){
        instance = monst;
    }
    
    private Monster(int hp, int str, int def, String name, String behavior){
        this.health = hp;
        this.maxHP = hp;
        this.str = str;
        this.def = def;
        this.name = name;
        this.behavior = behavior;
        xpReward = (hp + (str*3) + (def*6)) / 3;
    }
    private Monster(int hp, int str, int def, String eff, int cha, int pot, String name, String behavior){
        this.health = hp;
        this.maxHP = hp;
        this.str = str;
        this.def = def;
        this.name = name;
        this.behavior = behavior;
        this.effect = eff;
        this.chance = cha;
        this.potency = pot;
        hasStatus = true;
        xpReward = (hp + (str*potency) + (def*6)) / 3;
    }
    public Monster(String error){
        this.health = 999;
        this.maxHP = 999;
        this.str = 999;
        this.def = 999;
        this.name = "ERROR";
        this.behavior = "SAVAGE";
    }
    
    public static Monster[] getMonsterList(String location){
        return plainsMonsters;
    }
    
    public String getName(){
        return name;
    }

    public static char getMonsterAction(){
        char action = 'd'; //Placeholder might  be changed
        if (behavior.toUpperCase().equals("DEFENSELESS")){
            if (chanceTo(1,6)) action = 'a';
        }
        else if (behavior.toUpperCase().equals("FEARFUL")){
            if (chanceTo(2,6)) action = 'a';
        }
        else if (behavior.toUpperCase().equals("CAUTIOUS")){
            if (chanceTo(3,6)) action = 'a';
        }
        else if (behavior.toUpperCase().equals("NEUTRAL")){
            if (chanceTo(4,6)) action = 'a';
        }
        else if (behavior.toUpperCase().equals("AGGRESSIVE")){
            if (chanceTo(5,6)) action = 'a';
        }
        else if (behavior.toUpperCase().equals("SAVAGE")){
            action = 'a';
        }
        return action;
    }
    @Override
    public String toString(){
        return(name + " with " + health + " health, " + str + " strength, and " + def + " defence");
    }
}