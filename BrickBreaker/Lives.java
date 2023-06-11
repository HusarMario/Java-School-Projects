/**
 * Zivoty hry
 * aktualny pocet - zivoty ktore sa menia (pribudaju/ubudaju)
 * celkovy pocet - maximalny pocet zivotov ktory predstavuje hranicu nad ktoru zivoty nepresahuju a zaroven urcuje zaciatocny pocet aktualnych zivotov
 */
public class Lives {
    private Life[] lives;
    private int amount;
    private int active;
    
    /**
     * Vytvori zivoty
     */
    public Lives(int x, int y, int amount) {
        this.setUpLives(x, y, amount);
    }
    
    private void setUpLives(int x, int y, int amount) {
        this.amount = amount;
        this.active = amount;
        this.lives = new Life[this.amount];
        for (int i = 0; i < this.lives.length; i++) {
            this.lives[i] = new Life(x + i * 30, y); 
        }
    }
    
    /**
     * Odpocitava jeden zivot z aktualneho poctu
     */
    public void removeLife() {
        this.lives[this.active - 1].removeLife();
        this.active--;
    }
    
    /**
     * Pripocitava jeden zivot k aktualnemu poctu
     */
    public void regainLife() {
        this.lives[this.active].getLife();
        this.active++;
    }
    
    /**
     * Vracia udaj o aktualnom pocte zivotov
     */
    public int getLives() {
        return this.active;
    }
    
    /**
     * Vracia udaj o celkovom pocte zivotov
     */
    public int getAmount() {
        return this.amount;
    }

}
