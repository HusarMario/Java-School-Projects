/**
 * Zakladna herna plocha pre hru aj samotne MENU
 */
public class PlayGround {
    private Obdlznik backGround;
    private Obdlznik highLine;
    private int x;
    private int y;
    
    /**
     * Vytvori hernu plochu
     */
    public PlayGround(int x, int y) {
        this.setUpPlayGround(x, y);
    }
    
    /**
     * Zabezpeci prazdne platno pre dalsie vykonavanie programu
     */
    public void reset() {
        this.setUpBackGround();
        this.setUpHighLine();
    }
    
    private void setUpPlayGround(int x, int y) {
        this.setBoundaries(x, y);
        this.setUpBackGround();
        this.setUpHighLine();
    }
    
    private void setUpBackGround() {
        this.backGround = new Obdlznik();
        this.backGround.zmenStrany(this.x, this.y);
        this.backGround.zmenFarbu("black");
        this.backGround.zobraz();
    }
    
    private void setUpHighLine() {
        this.highLine = new Obdlznik();
        this.highLine.zmenStrany(this.x, 5);
        this.highLine.zmenFarbu("white");
        this.highLine.posunZvisle(100 - 5);
        this.highLine.zobraz();
    }
    
    private void setBoundaries(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Zabezpecuje odrazanie lopticky od stien hernej plochy
     */
    public boolean hit(Ball ball) {
        boolean hit = false;
        
        if ((ball.getX() - ball.getSize() <= 0) || (ball.getX() + ball.getSize() >= this.x)) {  // Hitting sides of playground
            ball.hit(HitType.VERTICAL);
            hit = true;
        }
        
        if (ball.getY() - ball.getSize() <= 100) {  // Hitting ceiling of playground   
            ball.hit(HitType.DOWN);
            hit = true;
        }
        
        if (hit) {   // Hitting needs to be resulted after checking both sides and ceiling of playground beacause there is a small chance of hitting a corner where ball would go out of the playground for one turn
            return true;
        }
        return false;
    }
    
    /**
     * Zabezpecuje pad lopticky mimo hernej plochy
     */
    public boolean miss(Ball ball) {
        if (ball.getY() - ball.getSize() >= this.y) {   // Letting ball under playground   
            return true;
        }
        return false;
    }
}
