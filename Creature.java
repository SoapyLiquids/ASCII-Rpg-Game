public class Creature extends Main {
    int health;
    int str;
    int def;
    int tempDef;

    public int getHP() {
        return health;
    }
    
    public int getStr() {
        return str;
    }
    
    public int getDef() {
        return def;
    }
    
    public void setHP(int hp) {
        health = hp;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public int poisonDur = 0;
    public int defendDur = 0;
    
    public int poisonLeth;
    public int poisonInc;
      
    public void effectPoison(int lethality){
        poisonDur = 5;
        poisonInc = (int) Math.floor(lethality * 0.20);
        poisonLeth = lethality;
    }
    
    public void effectDefend(){
        defendDur = 2;
        tempDef = (health / 10) + rollD(str / 2);
    }
    
    public void tickStatus(){
        if (poisonDur > 0){
            poisonDur -= 1;
            health -= poisonLeth;
            poisonLeth -= poisonInc;
        }
        if (defendDur > 0){
            defendDur -= 1;
            tempDef /= 2;
        }
    }
    
    public void cure(){
        poisonDur = 0;
    }
}