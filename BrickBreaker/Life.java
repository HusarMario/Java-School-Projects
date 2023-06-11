/**
 * Graficke predstavenie jednotlivych zivotov
 */
public class Life {
    private Kruh life;
    
    /**
     * Vytvori graficke zobraznie zivotov
     */
    public Life(int x, int y) {   
        this.setUpLife(x, y);
    }
    
    /**
     * Skryva zivot
     */
    public void removeLife() {
        this.life.skry();
    }
    
    /**
     * Odhaluje zivot
     */
    public void getLife() {
        this.life.zobraz();
    }
    
    private void setUpLife(int x, int y) {
        this.life = new Kruh();
        this.life.posunVodorovne(x);
        this.life.posunZvisle(y);
        this.life.zmenPriemer(20);
        this.life.zmenFarbu("white");
        this.life.zobraz();
    }
    
}
