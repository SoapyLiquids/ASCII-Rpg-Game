import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class Player extends Creature{
    static int xp = 0;
    static double xpReq = 16;
    static int lvl;
    static ArrayList<Integer> inventory = new ArrayList<Integer>();
    static String playerName;
    
    private static Player instance = new Player(23);
    public static Player getInstance(){ // Returns the only instance of the player class
        return instance;
    }
    
    private Player(int hp) { // Creates a player with base states
        maxHP = hp;
        health = maxHP;
        lvl = 1;
        str = 5;
        inventory.add(0);
        inventory.add(1);
        inventory.add(1);
        inventory.add(2);
    }
    
    public static void checkForLevelUp(){ // Checks if the player has enough XP to level up
        if (xp >= xpReq){
            System.out.println("Congratulations! You've leveled up!\nOverflow XP discarded...\n\n"
                                + "You are now level: " + lvl + " --> " + (lvl+1));
            levelUp();
            xp = 0;
        }
    }
    
    private static void levelUp(){ 
        ++lvl;
        xpReq = Math.floor(5.0*Math.pow(lvl,2) + lvl + 10.0);
    }
    
    public char getPlayerAction(){
        boolean actionIsValid = false;
        String action = "null";
        Scanner scan = new Scanner(System.in, "UTF-8");
        char act;
        
        while (!actionIsValid){
            System.out.println("Attack | Defend | Item | Run");
            action = scan.nextLine();    
            
            if (checkValidAction(action) == -1) System.out.println("Action Invalid, try again\n");
            else actionIsValid = true;
        }
        act = action.toLowerCase().charAt(checkValidAction(action));
        
        if (act != 'i') return act;
        Item.handleItemAction();
        if (Item.itemUsed) {
            actionIsValid = false;
            while (!actionIsValid){
                System.out.println("Attack | Defend | Run");
                action = scan.nextLine();    
            
                if (checkValidActionNoItem(action) == -1) System.out.println("Action Invalid, try again\n");
                else actionIsValid = true;
            }
        }
        else act = getPlayerAction();
        return act;
    }
    
    @Override
    public void tickStatus(){
        if (poisonDur > 0){
            poisonDur -= 1;
            System.out.println("You are poisoned!\nRemaining duration : " + poisonDur + " rounds"
                                + "\nYou keel over and take " + poisonLeth + " poison damage\n");
            health -= poisonLeth;
            poisonLeth -= poisonInc;
            wait(2.0);
            if (poisonDur == 0) System.out.println("You've finally worked the poison out of your system!\n");
            wait(1.0);
        }
        if (defendDur > 0){
            defendDur -= 1;
            tempDef /= 2;
            if (defendDur == 2) System.out.println("You lower your sheild.\nBut your stance will remain strong for : " + defendDur + " rounds");
            else System.out.println("Your stance will remain strong for : " + defendDur + " rounds");
            wait(1.0);
            if (defendDur != 0) System.out.println("Your defence is temporarily increased by " + tempDef + "\n");
            else {
                System.out.println("You get back into an attacking position\nYour defence drops to normal levels");
            }
            wait(2.0);
        }
        overKillCheck();
    }
    
    public static void askPlayerName(){
        Scanner scan = new Scanner(System.in, "UTF-8");
        playerName = scan.nextLine();
    }
    
    // @Override
    // public void effectDefend(){
    //     defendDur = 3;
    //     player.tempDef = (player.health /10) + rollD(player.str /2);
    // }
    
    private int checkValidAction(String action){
        if      (action.toUpperCase().contains("ATTACK")) return action.toUpperCase().indexOf("ATTACK");
        else if (action.toUpperCase().contains("ITEM"))   return action.toUpperCase().indexOf("ITEM");
        else if (action.toUpperCase().contains("RUN"))    return action.toUpperCase().indexOf("RUN");
        else if (action.toUpperCase().contains("DEFEND")) return action.toUpperCase().indexOf("DEFEND");
        return -1;
    }
    private int checkValidActionNoItem(String action){
        if      (action.toUpperCase().contains("ATTACK")) return action.toUpperCase().indexOf("ATTACK");
        else if (action.toUpperCase().contains("RUN"))    return action.toUpperCase().indexOf("RUN");
        else if (action.toUpperCase().contains("DEFEND")) return action.toUpperCase().indexOf("DEFEND");
        return -1;
    }
    public void overhealCheck(){
        if (health > maxHP) health = maxHP;
    }
    private void overKillCheck(){
        if (health < 0) health = 0;
    }
}