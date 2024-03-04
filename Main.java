import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        System.setProperty("file.encoding", "UTF-8"); // Bogos binted?
        Combat.start("Zombie"); //Combat test
    }
    
    public static void wait(double numSeconds){ // Sleeps the thread for (x) seconds
    try {
        Thread.sleep((int)(numSeconds * 1000.0));
    } catch (InterruptedException e) {// its fiiiiiiiine dont worry about iiiiiiit
    }
    }
    
    public static void gameOver() { // Closes the game
        System.out.println("Game Over");
        System.exit(0);
    }
    public static int rollD(double max){ // Rolls a dice with (x) sides
        Random rand = new Random();
        return (int) Math.floor(rand.nextDouble()*max+1.0);
    }
    public static boolean chanceTo(int chance, int outOf){ // Just a streamlines diceroller for true/false situations
        if (chance >= rollD(outOf)) return true;
        return false;
    }
    public static String percentageBar(int current, int max){ // Generates a bar as a string that represents current out of max
        String output = "[ ";
        for (int i = current ; i > 0 ; i -= 2){
            if (i >= 2) {
                output += "| ";
            }
            else{
                output += ": ";
            } 
        }
        for (int i = current +1 ; i < max ; i += 2){
            output += "- ";
        }
        output += "]";
        return output;
    }
}