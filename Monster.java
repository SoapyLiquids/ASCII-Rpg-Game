import java.util.ArrayList;

public class Monster extends Creature {
    public static Monster[] plainsMonsters = {new Monster(1, 1, 0, "Bunny", "Fearful")
                                     , new Monster(6, 3, 1, "Jackalope", "Neutral")
                                     , new Monster(5, 5, 1, "Slow", 100,  2, "Slime", "Savage")
                                     , new Monster(8, 5, 3, "Wulfrum Golem", "Neutral")
                                     , new Monster(12, 4, 0, "Zombie", "Aggressive")
                                     , new Monster(10, 3, 0, "Poison", 20, 5, "Giant Spider", "Aggressive")};
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
    
    public static void generate(String monster){
        for (int i = 0; i <= plainsMonsters.length - 1 ; i++){
            if (plainsMonsters[i].getName().equals(monster)) {
                instance = plainsMonsters[i];
                return;
            }
        }
        instance = new Monster(999,999,999, "ERROR", "Savage");
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