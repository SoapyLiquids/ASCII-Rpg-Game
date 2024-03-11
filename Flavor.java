public class Flavor extends Main {
    
    public static void drawMonster(){
        switch(Monster.getInstance().getName()){
            case("Jackalope"):
                printJackalope();
                return;
            case("Slime"):
                printSlime();
                return;
            case("Zombie"):
                printZombie();
                return;
            case("Wolf"):
                printWolf();
                return;
            case("Wulfrum Golem"):
                printWulfrumGolem();
                return;
        }
        printPlaceholder();
    }
    
    public static void animateSpider(){
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
    public static void printJackalope(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                        +  " ⠀⠀⠀⠀⠀⠀⠀⠸⡞⠉⠀⠀⣰⠀⢠⠇⢀⡼\n"
                        +  "⠀⠀⠀⠀⠀⠀⠀⠀⢳⠒⠒⠚⠓⠚⠓⠊⠉⠀\n"
                        +  "⣴⠒⠉⠉⠉⠉⠉⠉⣉⡍⠉⠉⠉⠒⢄⠀⠀⠀\n"
                        +  "⠪⣕⡒⠤⠄⢒⣒⡯⠕⢣⠀⠀⠘⠃⠀⣇⠀⠀\n"
                        +  "⠀⠀⠈⠉⠉⠁⠀⣀⣀⣘⡆⠀⠙⢶⠊⠁⠀⠀\n"
                        +  "⠀⠀⠀⢀⡴⠊⢉⣀⡀⠀⠀⠀⠀⠀⢣⠀⠀⠀\n"
                        +  "⠀⠀⢠⠏⠀⠀⠀⠀⠉⢢⠀⡀⠀⠀⡼⠀⠀⠀\n"
                        +  "⣀⡀⡌⠀⠀⠀⠀⠀⠀⢸⠀⢱⠀⡏⢆⠀⠀⠀\n"
                        +  "⢻⡈⠳⡀⠀⠀⠀⠀⠠⠮⠤⡘⡆⢸⡸⡄⠀⠀\n"
                        +  "⠀⠉⠒⠛⠒⠒⠒⠒⠒⠓⠒⠛⠉⠒⠃⠃⠀⠀\n"
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
    }
    public static void printSlime(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢰⣾⣷⣾⣶⣷⣾⣶⣷⣾⡆⠀⠀⠀⠀⠀⠀⠀⠀\n"
                        +  "⠀⠀⠀⠀⢰⣿⣿⣿⡟⠉⡉⢉⠉⠌⢉⠡⠉⠡⢹⣿⣿⣿⡆⠀⠀⠀⠀\n"
                        +  "⠀⠀⠰⣿⣿⠁⠡⠉⠄⠡⠐⠠⢈⠐⠠⠀⡁⢂⠡⠀⠼⠀⣿⣿⠆⠀⠀\n"
                        +  "⠀⠀⠘⣿⣿⠀⠡⢈⠤⠁⠌⡁⠂⠌⢠⠁⡐⠠⢀⠁⢂⠁⣿⣿⠃⠀⠀\n"
                        +  "⢀⣿⣿⡉⠆⡈⠔⠂⠄⡁⢂⠤⠁⠌⣀⠂⠄⡁⠂⠌⡀⠆⣀⠂⣿⣿⠆\n"
                        +  "⠠⣿⣿⢈⠆⡐⢈⡐⢈⠐⡀⢂⠁⡂⠄⣈⠐⠠⢁⠒⡀⢂⠰⠄⣿⣿⠂\n"
                        +  "⠐⣿⣿⣌⣂⠐⠄⡐⠠⢁⡐⠂⠡⠐⢠⠀⠌⡐⡀⢂⠸⢀⣉⣐⣿⣿⡅\n"
                        +  "⠀⠀⠐⣿⣿⣘⣸⣑⣣⢀⡄⣑⢂⣁⡂⣌⡐⣠⢐⣁⢺⣡⣿⣿⠆⠀⠀\n"
                        +  "⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀\n"
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
    }
    
    public static void printSpider(){
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
                          + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
        wait(1.0);
    }
    public static void printWolf(){
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
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
        wait(1.0);
    }
    public static void printZombie(){
        System.out.println("    (( _\n"
                        +  "    |x\\_\\\n"
                        +  "    ( - )\n"
                        +  "   __/\\/__\n"
                        +  "  /=`'-/  \\\n"
                        +  " |/}-_-\\_} |\n"
                        +  "   }_____} |\n"
                        +  "   }-_-_-}W\n"
                        +  "   {\\_|-_}\n"
                        +  "   {|_|_-}\n"
                        +  "   {/-|-_}\n"
                        +  "   %%@ @%%\n"
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
        wait(1.0);
    }
    public static void printWulfrumGolem(){
        System.out.println("⠀⠀⠀⣠⡿⡛⠛⢛⡛⢧⡄⠀⠀⠀\n"
                        +  "⠀⠀⢾⡏⣽⣥⡄⠀⠐⠒⠛⢧⡄⠀\n"
                        +  "⠀⠀⢿⡿⣿⣟⠣⠼⠿⢃⠸⢿⡇⠀\n"
                        +  "⠀⠀⣻⣿⣟⣳⠄⠠⠤⢌⣱⣼⡇⠀\n"
                        +  "⣶⣶⣿⣟⠛⣿⣆⣀⣀⣊⣴⣿⣇⣀\n"
                        +  "⢿⣇⡏⣿⣷⡆⡙⠛⠻⠿⢿⣑⣼⣯\n"
                        +  "⢶⣾⣟⣷⣿⣿⡃⣴⠖⠒⣶⣼⣷⣾\n"
                        +  "⠀⣿⡟⠃⠀⣻⡇⢿⣦⣶⣾⣽⣿⣿\n"
                        +  "⠀⠙⣿⣧⣾⣿⣧⡄⣴⣤⣿⣿⡟⢻\n"
                        +  "⠀⠀⣈⣉⣽⡿⢏⡵⢿⣿⣾⡏⠁⠀\n"
                        +  "⠀⠀⠹⣏⡿⢇⡈⡀⠸⢯⣽⣇⡀⠀\n"
                        +  "    ⣺⣷⣾⣷⣶⣶⣾⣿⣿⣇\n"
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
    }
    public static void printPlaceholder(){
        System.out.println(" _______________\n"
                        +  "|￣￣￣￣￣￣   |\n"
                        +  "| Please excuse.|\n"
                        +  "|Graphics budget|\n"
                        +  "|  running low. | \n"
                        +  "| ＿＿＿＿＿____| \n"
                        +  "(\\__/) || \n"
                        +  "(•ㅅ•) || \n"
                        +  "/ 　 づ\")\n"
                        + percentageBar(Monster.getInstance().health, Monster.getInstance().maxHP) + "\n");
    }
    
    
    
    public static class Intro extends Flavor{
        
        public static void runIntro(){
            print("Hello Dear Mortal!");
            wait(1.5);
            print("You might be thinking things such as, \"Who are you? Why am I here?\"");
            wait(2.5);
            print("Which, thanks for asking by the way! Im Noteleks, or God, whichever you prefer!");
            wait(0.8);
            printNoteleks();
            wait(2.0);
            print("Now in return for that question you yourself asked me just then,\ntell me your name!");
            Player.askPlayerName();
            print("\nAmazing! Nice to meet you " + Player.playerName);
            wait(1.0);
            print("Now, my world is just beginning to develop, and im quite impatient!");
            wait(1.0);
            print("I love watching heros explore the highest mountains and plunder\nthe darkest of lairs, but nobody is doing anything yet,\nIt's so boring!");
            wait(2.0);
            print("That's where you come in. You have been specially chosen from a realm of high adventure,\nand will be sent through my world, as sort of a test run!");
            wait(2.0);
            print("Short note, somebody stole our entire animation budget, so dont expect much");
            wait(2.0);
            print("Anyway, have fun. And dont die, that'd disapoint the audience");
            wait(2.0);
        }
        
        private static void printNoteleks(){
            System.out.println("                                 ⣀\n"
                            +  "                               ⡠⠊⠈\n"
                            +  "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠦⣀⠀⠀⠀⠀⠀⠀⠀⢴⠊⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀ ⠀⡜⠀⠀⠉⠁⠒⡒⠀⠀⠀⢀⠇⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀    ⠜⠀⠀⠀⠀⠀⠀⠱⠤⠤⠐⠁⠀⠀⠀⢠⠋⡆⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "       ⢀⣀⣀⡀⠀⠤⡤⠀⠀⠈⢢⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "        ⠈⢢⠀⠀⠀⠀⢇⠀⠀⡠⠜⠀⠀⠀⢀⠃⢈⡇⠀⠀⠀⠀⠀⠀⠀⠀⡸⠤⡀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀    ⠀⠑⢄⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠘⠣⢾⠀⠀⠀⠀⠀⠀⡠⠔⠁⠀⠀⡸⠤⡀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀    ⠈⢣⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⠉⠀⠀⠀⠀⡰⠁⠀⠈⠑⣄⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀    ⠣⢾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠀⠀⠀⠀⠀⠀⠀⢀⠜⠀⠀⠀⠀⠀⠈⢆⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀    ⠀⠃⠀⢀⣤⠠⠀⠀⠀⠀⠘⠁⠀⠀⠀⠀⠀⠀⢠⠊⠀⠀⠀⠀⠀⠀⠀⠈⡄⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀     ⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢃⠀\n"
                            +  "    ⠀⠀⠀⠀⠀     ⠀⢃⠀⠀⠀⠀⠔⠉⡀⠀⠀⠀⠀⠀⠀⠀⡰⠁⠝⣠⣶⣶⣶⣦⡀⠀⠀⠀⢀⠇⠀\n"
                            +  "    ⠀⠀⠀⠀     ⠀⠀⠈⡆⠀⠀⢸⠀⠀⠃⠀⠀⠰⡄⠀⡠⠊⠀⠀⣾⣿⣿⠿⣿⣿⣷⡀⠀⠀⡌⠀⠀\n"
                            +  "    ⠀⠀⠀     ⠀⡔⠒⠉⠀⠀⠀⠘⢄⠀⠀⠀⠀⡷⢀⠊⣰⣧⠀⠀⣿⣿⣿⣶⣿⣿⡿⠁⠀⠀⠣⢀⠀\n"
                            +  "    ⠀⠀     ⠀⠀⢁⠀⠀⠀⠀⠀⠀⠀⠑⠀⠀⠀⠀⡈⢰⣿⣿⣇⠀⠈⠻⠿⣿⠿⠛⠁⠀⠀⠀⠀⡰⠁\n"
                            +  "    ⠀⠀⠀⠀    ⠈⠀⠉⠢⠠⢲⠀⠀⠀⠀⠀⠀⠀⡇⠈⠋⠘⠃⠀⠀⠀⠀⢀⣠⠀⠀⣠⠔⠂⠉⠁⠀\n"
                            +  "                   ⡄⠀⢸⣦⣤⠀⠀⢣⡠⠤⣠⠐⢴⠊⠑⢾⣿⣿⠀⡰⠁⠀⠀⠀⠀⠀\n"
                            +  "                   ⠃⠀⠘⣿⣷⡄⠀⡰⠀⠀⡇⠀⢸⣄⣠⣾⣿⡇⠀⠇⠀⠀⠀⠀⠀⠀\n"
                            +  "                   ⢸⠀⠀⢿⣿⣿⣦⣿⣦⣾⣷⣤⣿⣷⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⢸⠀⠀⠘⡯⠛⣿⠛⢿⠟⣿⠿⢻⡿⠛⢻⠃⠀⠀⡀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠑⢄⠀⠀⠰⣄⡥⣄⣀⡀⣸⡀⣠⣇⣀⠌⠀⢀⣠⠇⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠈⣰⢦⠀⠈⠀⠉⠀⠋⠁⠛⠁⡙⠁⣠⠖⠉⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠑⣄⠀⠀⠀⠀⠀⠀⢠⡥⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                            +  "    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠉⠈⠀⠒⠀⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n");
        }
    }
}