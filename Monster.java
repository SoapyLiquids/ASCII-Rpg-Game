public class Monster extends Creature {
    String name;
    String behavior;
    int xpReward;
    char effect;
    int chance;
    int potency;
    boolean hasStatus;
    int maxHp;
    
    public Monster(int hp, int str, int def, boolean hasStatus, String name, String behavior){
        this.health = hp;
        this.maxHp = hp;
        this.str = str;
        this.def = def;
        this.name = name;
        this.behavior = behavior;
        xpReward = (hp + (str*3) + (def*6)) / 3;
    }
    public Monster(int hp, int str, int def, boolean hasStatus, char eff, int cha, int pot, String name, String behavior){
        this.health = hp;
        this.maxHp = hp;
        this.str = str;
        this.def = def;
        this.name = name;
        this.behavior = behavior;
        this.effect = eff;
        this.chance = cha;
        this.potency = pot;
        this.hasStatus = hasStatus;
        xpReward = (hp + (str*potency) + (def*6)) / 3;
    }
    
    public String getName(){
        return name;
    }
    
    public char getMonsterAction(){
        int random;
        char action = 'a'; //Placeholder might  be changed
    
        if (behavior.toUpperCase().equals("AGGRESSIVE")){
            random = rollD(5);
            if (random <= 4){ //Nothing for now, in the future 4/5 chance to attack, 1/5 to defend
                action = 'a';
            }
            else action = 'd';
        }
        return action;
    }
    
    public void animateSpider(){
        final String[] spider = {"       |"
                                        ,"       |"
                                        ,"       |"
                                        ,"   /   |   \\"
                                        ,"   \\   |   /"
                                        ," .  --\\|/--  ,"
                                        ,"  '--|___|--'"
                                        ,"  ,--|___|--,"
                                        ," '  /\\o o/\\  `"
                                        ,"   +       +"
                                        ,"    `     '"
                                        ,""
                                        ,""
                                        ,""
                                        ,"   /       \\"
                                        ,"   \\       /"
                                        ," .  --\\ /--  ,"};
        for (int outer = 10 ; outer >= 0 ; outer--){
            wait(0.2);
            System.out.print("\033[H\033[2J\n");
            for (int inner = outer ; inner <= 10 ; inner++){
                System.out.println(spider[inner]);
            }
        }
        wait(0.5);
        for (int outer = 5 ; outer >= 0 ; outer--){
            wait(0.2);
            System.out.print("\033[H\033[2J\n");
            spider[outer] = spider[outer + 11];
            for (int inner = 0 ; inner <= 10 ; inner++){
                System.out.println(spider[inner]);
            }
        }
        wait(1.0);
    }
    public void printSpider(){
        System.out.println("        \n"
                          +"        \n"
                          +"        \n"
                          +"   /       \\\n"
                          +"   \\       /\n"
                          +" .  --\\ /--  ,\n"
                          +"  '--|___|--'\n"
                          +"  ,--|___|--,\n"
                          +" '  /\\o o/\\  `\n"
                          +"   +       +\n"
                          +"    `     '\n"
                          + percentageBar(health, maxHp) + "\n");
        wait(1.0);
    }
    public void printWolf(){
        System.out.println("                n,\n"
                        +  "              _/ | _\n"
                        +  "             /'  `'/\n"
                        +  "            <~    .'\n"
                        +  "            .'    |\n"                 
                        +  "          _/      |\n"
                        +  "        _/      `.`.\n"
                        +  "       / '   \\__ | |\n"
                        +  "   ___/      /__\\ \\ \\\n"
                        +  "  (___.'\\_______)\\_|_|\n"
                        + percentageBar(health, maxHp) + "\n");
    }
}