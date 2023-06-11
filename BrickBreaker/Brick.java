import java.util.Random;

/**
 * Graficke zobrazenie jednotlivej tehlicky
 */
public class Brick {
    private Obdlznik brickOutLine;
    private Obdlznik brick;
    private PowerUpType powerUp;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean destroyed;
    
    /**
     * Vytvori tehlicku
     */
    public Brick(int x, int y) {
        this.loadUpInfo(x, y);
        this.setUpBrick();
    }
    
    private void loadUpInfo(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 10;
        this.destroyed = false;
        this.powerUp = null;
    }
    
    private void setUpBrick() {
        this.brickOutLine = new Obdlznik();
        this.brick = new Obdlznik();
        
        this.brickOutLine.zmenStrany(this.width, this.height);
        this.brick.zmenStrany(this.width - 2, this.height - 2);
        
        this.brickOutLine.posunVodorovne(this.x - this.width / 2);
        this.brick.posunVodorovne(this.x - (this.width / 2) + 1);
        

        this.brickOutLine.posunZvisle(this.y - this.height / 2);
        this.brick.posunZvisle(this.y - (this.height / 2) + 1);
        
        this.brickOutLine.zmenFarbu("white");
        this.brick.zmenFarbu("blue");
    }
    
    /**
     * Zobrazuje tehlicku
     */
    public void show() {
        this.brickOutLine.zobraz();
        this.brick.zobraz();
    }
    
    private void hide() {
        this.brickOutLine.skry();
        this.brick.skry();
    }
    
    /**
     * Znovu vytvara tehlicku so sancou na vytvorenie vylepsenia hry v thelicky
     */
    public void recreate() {
        this.addPowerUp();
        this.destroyed = false;
        this.show();
    }
    
    /**
     * Nici tehlicku
     */
    public void destroy() {
        this.destroyed = true;
        this.hide();
        this.brick.zmenFarbu("blue");
    }
    
    /**
     * Vracia udaj o vylepseni hry nachadzujceho sa vnutri tehlicky
     */
    public PowerUpType getPowerUp() {
        return this.powerUp;
    }
    
    private void addPowerUp() {  //Every recreation of brick got 1% chance of getting a powerUp
        if (new Random().nextInt(100) < 1) {
            switch (new Random().nextInt(3)) {
                case 0: {
                    this.powerUp = PowerUpType.BALL;
                    this.brick.zmenFarbu("yellow");
                    break;
                }
                case 1: {
                    this.powerUp = PowerUpType.LIFE;
                    this.brick.zmenFarbu("red");
                    break;
                }
                case 2: {
                    this.powerUp = PowerUpType.SCORE;
                    this.brick.zmenFarbu("green");
                }
            }
        }
    }
    
    /**
     * Zabezpecuje odrazanie lopticky od jednotlivej tehlicky na ktoru narazi
     */
    public HitType hit(Ball ball) {
        if (!this.destroyed) {     
            if ((ball.getDirY() == -1) && (((ball.getY() - ball.getSize()) <= (this.y + this.height / 2)) && ((ball.getY() - ball.getSize()) >= (this.y + this.height / 2))) && ((ball.getX() >= (this.x - this.width / 2)) && (ball.getX() <= (this.x + this.width / 2)))) {
                this.destroy();
                return HitType.DOWN;
            }
            if ((ball.getDirY() == 1) && (((ball.getY() + ball.getSize()) >= (this.y - this.height / 2)) && ((ball.getY() + ball.getSize()) <= (this.y - this.height / 2))) && ((ball.getX() >= (this.x - this.width / 2)) && (ball.getX() <= (this.x + this.width / 2)))) {
                this.destroy();
                return HitType.UP;
            }
            if ((ball.getDirX() == -1) && (((ball.getX() - ball.getSize()) <= (this.x + this.width / 2)) && ((ball.getX() - ball.getSize()) >= (this.x + this.width / 2))) && ((ball.getY() >= (this.y - this.height / 2)) && (ball.getY() <= (this.y + this.height / 2)))) {
                this.destroy();
                return HitType.VERTICAL;
            }
            if ((ball.getDirX() == 1) && (((ball.getX() + ball.getSize()) >= (this.x - this.width / 2)) && ((ball.getX() + ball.getSize()) <= (this.x - this.width / 2))) && ((ball.getY() >= (this.y - this.height / 2)) && (ball.getY() <= (this.y + this.height / 2)))) {
                this.destroy();
                return HitType.VERTICAL;
            }
        }
        
        return null;
    }
    
    /**
     * Vracia udaj o stave znicenia tehlicky 
     */
    public boolean isDestroyed() {
        return this.destroyed;
    }
    
    
}
