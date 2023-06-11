/**
 * Odrazadlo hry
 * Sklada sa z 2 casti stred a boky ktore menia smerovanie odrazu lopticky
 */
public class Paddle {
    private Obdlznik[] paddle;
    private PowerUpType powerUp;
    private int x;
    private int y;
    private int size;
    private int delta;
    
    /**
     * Vytvori odrazadlo
     */
    public Paddle(int x, int y, boolean bigSize) {
        this.loadUpInfo(x, y, bigSize);
        this.setUpPaddle();
    }
    
    private void loadUpInfo(int x, int y, boolean bigSize) {
        if (bigSize) {
            this.size = 70;
        } else {
            this.size = 50;
        }
        
        this.x = x;
        this.y = y;
        this.delta = 10;
        this.powerUp = null;
    }
    
    private void setUpPaddle() {
        this.paddle = new Obdlznik[2];
        for (int i = 0; i < this.paddle.length; i++) {
            this.paddle[i] = new Obdlznik();
            this.paddle[i].posunZvisle(this.y);
            
            if (i == 1) {
                this.paddle[i].posunVodorovne(this.x - (this.size / 10));
                this.paddle[i].zmenStrany((this.size / 5), 5);
                this.paddle[i].zmenFarbu("white");
            } else {
                this.paddle[i].posunVodorovne(this.x - (this.size / 2));
                this.paddle[i].zmenStrany(this.size, 5);
                this.paddle[i].zmenFarbu("blue");
            }
            
            this.paddle[i].zobraz();
        }
    }
    
    /**
     * Priraduje vylepsenie hry na odrazadlo kde caka na aktivaciu
     */
    public void attach(PowerUpType powerUp) {
        this.powerUp = powerUp;
        switch (this.powerUp) {
            case BALL: {
                this.paddle[1].zmenFarbu("yellow");
                break;
            }
            case LIFE: {
                this.paddle[1].zmenFarbu("red");
                break;
            }
            case SCORE: {
                this.paddle[1].zmenFarbu("green");
                break;
            }
        }
    }
    
    /**
     * Vracia odrazadlo do stavu bez vylepsenia hry
     */
    public void deattach() {
        this.powerUp = null;
        this.paddle[1].zmenFarbu("white");
    }
    
    /**
     * Zabezpecuje ovladanie odrazadla smerom dolava
     */
    public void posunVlavo() {
        if ((this.x - this.size / 2) > 0) {
            for (Obdlznik part : this.paddle) {
                part.posunVodorovne(-this.delta);
            }
            this.x -= this.delta;
        }
    }
    
    /**
     * Zabezpecuje ovladanie odrazadla smerom doprava
     */
    public void posunVpravo() {
        if ((this.x + this.size / 2) < 500) {
            for (Obdlznik part : this.paddle) {
                part.posunVodorovne(+this.delta);
            }
            this.x += this.delta;
        }
    }
    
    /**
     * Zabezpecuje odrazanie lopticky od odrazadla
     */
    public boolean hit(Ball ball) {     //Detecting hitting the ball with the paddle
        if ((ball.getX() + ball.getSize() > this.x - this.size / 10) && (ball.getX() - ball.getSize() < this.x + this.size / 10)) {    //Hitting middle --> Got higher priority 
            if (this.hitPaddle(ball)) {
                ball.hit(HitType.MIDDLE);
                return true;
            }
        } else if ((ball.getX() + ball.getSize() >= this.x - this.size / 2) && (ball.getX() - ball.getSize() < this.x + this.size / 10)) {   //Hitting leftside
            if (this.hitPaddle(ball)) {
                ball.hit(HitType.LEFT);
                return true;
            }
        } else if ((ball.getX() + ball.getSize() > this.x - this.size / 10) && (ball.getX() - ball.getSize() <= this.x + this.size / 2)) {   //Hitting rightside
            if (this.hitPaddle(ball)) {
                ball.hit(HitType.RIGHT);
                return true;
            }
        }
        return false;
    }
    
    private boolean hitPaddle(Ball ball) {  //Helping method for hit()
        return ((ball.getY() >= this.y) && (ball.getY() - ball.getSize() <= this.y));
    }
    

}
