import java.lang.Math;
import java.util.Scanner;

public class Player extends Creature{
    static int maxHP;
    static int xp = 0;
    static double xpReq = 16;
    static int lvl;
    static int[] inventory = {0,1,1,2};
    
    private static Player player = new Player(23);
    public static Player getInstance(){ // Returns the only instance of the player class
        return player;
    }
    private Player(int hp) { // Creates a player with base states
        maxHP = hp;
        health = maxHP;
        lvl = 1;
        str = 5;
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
            
            act = action.toLowerCase().charAt(checkValidAction(action));
            
            if (act != 'i') return action.toLowerCase().charAt(checkValidAction(action));
            Item.handleItemAction();
            if (Item.itemUsed) {
                while (!actionIsValid){
                    System.out.println("Attack | Defend | Run");
                    action = scan.nextLine();    
                
                    if (checkValidActionNoItem(action) == -1) System.out.println("Action Invalid, try again\n");
                    else actionIsValid = true;
                }
            }
        }
        return action.toLowerCase().charAt(checkValidAction(action));
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
}