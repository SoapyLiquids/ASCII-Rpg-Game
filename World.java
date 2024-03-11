import java.util.Scanner;

public class World extends Main {
    
    public static void generateMonster(String monster, Monster[] monsterList){
        for (int i = 0; i <= monsterList.length - 1 ; i++){
            if (monsterList[i].getName().equals(monster)) {
                Monster.setInstance(monsterList[i]);
                Monster.getInstance().necromance();
                return;
            }
        }
        Monster.setInstance(new Monster("ERROR"));
    }
    public static void generateRandomMonster(Monster[] monsterList){
        int dangerLevel = 0;
        if (time > 22.00 || time < 02.00) dangerLevel = monsterList.length/2;
        else if (time > 18.00 || (time < 05.00 && time > 02.00)) dangerLevel = monsterList.length/3;
        else if (time > 14.00) dangerLevel = monsterList.length/6;
        
        Monster.setInstance(monsterList[(int)rollD((monsterList.length-1)/2) + dangerLevel]);
    }
    
    public static char getWorldAction(){
        String action = "null";
        Scanner scan = new Scanner(System.in, "UTF-8");
        
        while (true){
            action = scan.nextLine();    
            
            if (checkValidWorldAction(action) == 'n') System.out.println("Nuh uh. Please try again");
            else return checkValidWorldAction(action);
        }
    }
    
    private static char checkValidWorldAction(String action){
        if (action.toUpperCase().contains("HEAD") || action.toUpperCase().contains("COP") || action.toUpperCase().contains("TOWN")) return 't';
        else if (action.toUpperCase().contains("EXP")) return 'e';
        else if (action.toUpperCase().contains("WAN")) return 'w';
        return 'n'; // if no valid action was found return null
    }
    
    
    
    public static class Plains extends World{
        private static String nearbyTown = "Nearby Town";
        private static boolean inPlains = false;
        
        public static void enter(){
            print("The smell of the grass fills your nostrils as you stand\nbefore the fields of the Plains");
            inPlains = true;
            while (inPlains){
                print("What would you like to do?");
                if (Town.CopperLeaf.visited){
                    nearbyTown = "Copperleaf";
                }
                System.out.println("Head to " + nearbyTown + " | Explore | Wander");
                char act = getWorldAction();
                if (act == 't'){
                    Town.CopperLeaf.enter();
                }
                if (act == 'w' || act == 'e'){
                    encounter();
                }
            }
        }
        
        public static void encounter(){
            // generateMonster("Goblin",Monster.getMonsterList("Plains"));
            generateRandomMonster(Monster.getMonsterList("Plains"));
            Combat.start();
        }
    }
}