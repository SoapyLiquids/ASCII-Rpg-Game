import java.util.Scanner;

public class Item extends Main{
    private static String[] items = {"Back","Healing Potion","Antidote"};
    static Player player = Player.getInstance();
    static boolean itemUsed = false;
    static boolean validIndex;
    static int index;
    static String indexStr;
    
    public static void handleItemAction(){
        Scanner scan = new Scanner(System.in, "UTF-8");
        validIndex = false;
        itemUsed = false;
        System.out.println("Enter the index of the item you wish to use");
        printInv();
        
        while (!validIndex){
            try {
                indexStr = scan.nextLine();
                index = Integer.parseInt(indexStr);
                validIndex = true;
            } catch (NumberFormatException e) {
                System.out.println("Not a number, try again");
            }
        }
        
        while (!itemUsed && index != 0){
            if (index < Player.inventory.size() && index != 0) {
                Item.useItem(index);
                itemUsed = true;
            }
            else if (index == 0) {}
            else {
                System.out.println("Value invalid. See numbers on the side");
                break;
            }
        }
    }
    
    private static void useItem(int itemID,int inventoryIndex){
        if (itemID == 1){
            healingPotion();
        }
        if (itemID == 2){
            antidote();
        }
        Player.inventory.remove(inventoryIndex);
    }
    private static void useItem(int itemIndex){
        useItem(itemIndexToId(itemIndex),itemIndex);
    }
    
    private static void printInv(){
        int index = 0;
        for (int item : Player.inventory){
            System.out.println(index + " - " + items[item]);
            index++;
        }
    }
    public static String itemIdToString(int id){
        return items[id];
    }
    public static int itemIndexToId(int index){
        return Player.inventory.get(index);
    }
    
    private static void healingPotion(){
        int healing = rollD(7) + 9;
        player.health += healing;
        player.overhealCheck();
        System.out.println("You feel the cherry flavored remedy hit the tip of your tongue as your wounds begin to close"
                            + "\nYou have healed " + healing + " HP");
        wait(1.5);
        System.out.println("You have " + player.getHP() + " Health remaining\n" 
                            + percentageBar(player.health, player.maxHP));
    }
    private static void antidote(){
        System.out.println("Your stomach grumbles as the vile purple liquid expells the poison out of your body");
        player.cure();
        wait(1.0);
    }
}