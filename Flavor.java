public class Flavor extends Main {
    
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
    }/*
    public static void printZombie(){
        System.out.println( (()))
                            |x x|
                            ( - )
                          __/\/__
                         /=`'-'-'\  !!
                        |-{-_-_-} |   !
                         (-{-_-_-})   !
                         \{_-_-_}/  !
                          }-_-_-}
                          {-_|-_}
                          {-_|_-}
                          {_-|-_}
                          {_-|-_}  
                          %%@ @%%
    }
    */
}