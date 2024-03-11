import java.util.Scanner;

public class Town extends Main{
    
    public static char getTownAction(){
        String action = "null";
        Scanner scan = new Scanner(System.in, "UTF-8");
        
        while (true){
            print("Copperleaf is home to many adventurers!\n"
                + "Not so many businessowners though\n"
                + "All you can find to do is:\n-Rest at an Inn\n-Head to the Market"
                + "\n-Go back to exploring");
            action = scan.nextLine();  
            if (checkValidTownAction(action) == 'n') System.out.println("\033[H\033[2JI Don't think they have that here? Please try again");
            else return checkValidTownAction(action);
        }
    }
    
    public static char checkValidTownAction(String action){
        if (action.toUpperCase().contains("RES") || action.toUpperCase().contains("INN")) return 'i';
        else if (action.toUpperCase().contains("MARK") || action.toUpperCase().contains("SHO")) return 'm';
        else if (action.toUpperCase().contains("EXP") || action.toUpperCase().contains("BACK")) return 'e';
        return 'n'; // if no valid action was found return null
    }
    
    public static void rest(int innQuality){
        Player.getInstance().health += 20 * innQuality;
        days++;
        time = 08.00;
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < 5 ; i++) {
            for (int x = 0; x <= i; x++){
                System.out.print("z");
                wait(0.2);
            }
            print("");
            wait(0.8);
        }
        print("You feel the sunshine come through the windowsill as the sun rises once more\n"
            + "You grab your equipment and ready yourself for another day of aventuring!");
        Player.getInstance().overhealCheck();
        print("Your health is restored by " + (20 * innQuality) + ",\nYou now have " 
            + Player.getInstance().health + " health remaining.\n" 
            + percentageBar(Player.getInstance().health, Player.getInstance().maxHP) + "\n");
    }
    
    
    
    public static class CopperLeaf extends Town{
        static int level = 0;
        static int innQuality = 1;
        static boolean visited = false;
        static boolean inTown = false;
        
        public static void enter(){
            inTown = true;
            while (inTown){
                if (!visited){
                    System.out.print("\033[H\033[2J");
                    print("Welcome " + Player.playerName + ", to CopperLeaf!\n"
                        + "The streets are full of people, and whilst the build quality\n"
                        + "of nearby buildings is lacking, the towns spirits certainly arent!\n"
                        + "You smell new adventure, and cheap booze.");
                    wait(2.0);
                    visited = true;
                }
                copperLeaf();
            }
        }
        private static void copperLeaf(){
            char act = getTownAction();
            if (act == 'i'){
                rest(innQuality);
            }
            else if (act == 'm') {
                print("This is currently not implemented yet, sorry! Please try something else");
            }
            else if (act == 'e'){
                System.out.print("\033[H\033[2J");
                print("You head back out the gates of CopperLeaf");
                print("The smell of the grass fills your nostrils as you stand before the fields of the Plains");
                inTown = false;
            }
        }
    }
}