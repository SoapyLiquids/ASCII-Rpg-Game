
public class Combat extends Main{
    private static Player player = Player.getInstance();
    private static Monster monster;
    private static char pAction;
    private static char mAction;
    
    public static void start(){
        monster = Monster.getInstance();
        startCombat();
    }
    
    private static void startCombat() {
        System.out.print("\033[H\033[2J");
        print("You encounter a " + monster.getName() + "!");
        
        
        while (combatActive()){
            Flavor.drawMonster();
            print("What would you like to do?");
            
            pAction = player.getPlayerAction();
            handlePlayerAction(pAction,monster);
            mAction = Monster.getMonsterAction();
            monster.tickStatus();
            handleMonsterAction(mAction,monster);
            player.tickStatus();

            print("You have " + player.getHP() + " Health remaining\n" 
                                + percentageBar(player.getHP(), player.maxHP) + "\n");
            wait(2.5);
            System.out.print("\033[H\033[2J\n");
        }
        print("You defeated the " + monster.getName() + "... congratulations!!!\nYou've earned " + Monster.xpReward + "XP!");
        Player.xp += Monster.xpReward;
        Player.checkForLevelUp();
    }
    
    public static void handlePlayerAction(char action,Monster monster){
        if (action == 'a') { //Attack Script
            int damage = (player.getStr()/2 + rollD(player.getStr())) - (monster.def + monster.tempDef);
            if (damage < 0) damage = 0;
            print("You strike a mighty blow to the " 
                + monster.getName() + " and deal " 
                + damage + " damage!");
            monster.setHP(monster.getHP() - damage);
            wait(1.5);
        }
        else if (action == 'd') { //Defend Script
            player.effectDefend();
            print("You raise your sheild and ready your stance, increasing your defence by " + player.tempDef);
        }
        else if (action == 'r') {
            mAction = Monster.getMonsterAction();
            handleMonsterAction(mAction,monster);
            print("\n\n\nCoward...");
            gameOver();
        }
    }
    
    public static void handleMonsterAction(char action,Monster monster){
        if (action == 'a') { //Attack Script
            int damage = (monster.getStr()/2 + rollD(monster.getStr())) - (player.def + player.tempDef);
            if (damage < 0) damage = 0;
            if (damage > 0 && Monster.hasStatus) monsterInflictStatus(Monster.effect, Monster.chance, Monster.potency);
            print("The " + monster.getName() 
                + " sinks its teeth into you, dealing " 
                + damage + " damage\n");
            wait(1.5);
            player.setHP(player.getHP() - damage);
        }
        else if (action == 'd') {
            monster.effectDefend();
            print("The " + monster.getName()
                + " readies itself, raising its defence");
        }
    }
    
    private static void monsterInflictStatus(String effect, int chance, int potency){
        if (chanceTo(chance,100)) player.effectPoison(5);
    }

    public static boolean combatActive(){
        if (!monster.isAlive()) return false;
        if (!player.isAlive()) gameOver();
        return true;
    }
}