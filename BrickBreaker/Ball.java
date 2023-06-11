/**
 * Zakladna lopticka hry, ktora sa odraza na ploche a nici tehlicky
 */
public class Ball {
    private Kruh ball;
    private int x;
    private int y;
    private int size;
    
    private int delta;
    private int dirX;
    private int dirY;
    
    private boolean trigger;
    
    /**
     * Vytvori lopticku
     */
    public Ball(int x, int y) {
        this.loadUpInfo(x, y);
        this.setUpBall();
    }
    
    private void loadUpInfo(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 5;
        this.delta = 5;
        this.dirX = 0;
        this.dirY = 1;
        this.trigger = false;
    }
    
    /**
     * Graficky zobrazuje aktualne pouzivanie schopnosti lopticky kedy dokaze prechadzat cez tehlicky bez odrazania
     */
    public void trigger() {
        this.trigger = true;
        this.ball.zmenFarbu("yellow");
    }
    
    /**
     * Vracia udaj o pouzivani schopnosti lopticky kedy dokaze prechadzat cez tehlicky bez odrazania
     */
    public boolean isTriggered() {
        return this.trigger;
    }
    
    /**
     * Graficky zobrazuje aktualne pouzivanie schopnosti lopticky kedy zdvojnasobuje finalne skore priradene odrazom od odrazadla
     */
    public void doubleUp() {
        this.ball.zmenFarbu("green");
    }

    /**
     * Vracia lopticky do stavu bez schopnosti
     */
    public void reset() {
        this.trigger = false;
        this.ball.zmenFarbu("white");
    }
    
    private void setUpBall() {
        this.ball = new Kruh();
        this.ball.posunVodorovne(this.x - this.size);
        this.ball.posunZvisle(this.y - this.size);
        this.ball.zmenPriemer(this.size * 2);
        this.ball.zmenFarbu("white");
        this.ball.zobraz();
    }
    
    /**
     * Zabezpecuje pohyb lopticky
     */
    public void move() {
        this.ball.posunVodorovne(this.delta * this.dirX);
        this.x += this.delta * this.dirX;
        this.ball.posunZvisle(this.delta * this.dirY);
        this.y += this.delta * this.dirY;
    }
    
    /**
     * Zabezpecuje odrazanie lopticky na zaklade vlastnosti odrazania ktora jej bola pridelena
     */
    public void hit(HitType type) {
        switch (type) {
            case MIDDLE: {   //Hit horizontally upwards
                this.dirX = 0;
                this.dirY *= -1;
                break;
            }
            case LEFT: {   //Hit horizontally to left
                this.dirX = -1;
                this.dirY *= -1;
                break;
            }
            case RIGHT: {   //Hit horizontally to right
                this.dirX = 1;
                this.dirY *= -1;
                break;
            }
            case DOWN: {   // Hit horizontally down and keep direction
                this.dirX *= 1;
                this.dirY = 1;
                break;
            }
            case UP: {   // Hit horizontally up and keep direction
                this.dirX *= 1;
                this.dirY = -1;
                break;
            }
            case VERTICAL: {   // Hit vertically and keep direction
                this.dirX *= -1;
                this.dirY *= 1;
                break;
            }
        }
    }
    
    /**
     * Vracia udaj o smerovani lopticky vertikalne
     */
    public int getDirX() {
        return this.dirX;
    }
    
    /**
     * Vracia udaj o smerovani lopticky horizontlane
     */
    public int getDirY() {
        return this.dirY;
    }
    
    /**
     * Vracia udaj o polohe lopticky na xovej osi
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Vracia udaj o polohe lopticky na yovej osi
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Vracia udaj o velkosti lopticky
     */
    public int getSize() {
        return this.size;
    }
    
    
}
