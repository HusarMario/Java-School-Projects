import java.util.ArrayList;
import java.util.Random;

/**
 * Stena hry - sklada sa z jednotlivich tehliciek
 */
public class Wall {
    private ArrayList<Brick> wall; 
    private ArrayList<Brick> holes;
    private ArrayList<Brick> sides;
    
    private Brick[][] bonus;
    
    /**
     * Vytvori stenu tehliciek
     */
    public Wall(int x, int y) {   
        this.setUpWall(x, y);
    }
  
    private void setUpWall(int x, int y) {
        this.wall = new ArrayList<Brick>(); // Using arraylists beacause i wanna browse only trough certain bricks without needing to browse trough everything
        this.holes = new ArrayList<Brick>();
        this.sides = new ArrayList<Brick>();
        
        this.bonus = new Brick[15][];   // Using list beacsue i need to browse trough every single row and every single brick till i find error
        for (int i = 0; i < 15; i++) {
            this.bonus[i] = new Brick[25];
            for (int j = 0; j < 25; j++) {
                Brick brick = new Brick(j * 20 + x, y + i * 10);
                this.bonus[i][j] = brick;
                if ((i > 11) || (new Random().nextInt(10) < 5)) {    // Bricks got 50% chance on spawning except last 3 rows which will be fully spawned
                    brick.show();
                    this.wall.add(brick);
                } else {
                    this.holes.add(brick);
                    brick.destroy();
                }
                
                if ((j == 0) || (j == 24)) { // Adding another ArrayList with only sides of the wall so it can be later used to not generate brick on sides when hitting the playground is triggered
                    this.sides.add(brick);
                }
            }
        }
    }
    
    /**
     * Pocita pocet uplne prazdnych riadkov pre aktivaciu bonusu a naslednu regeneraciu tychto tehliciek
     */
    public void getBonus(Score score) { // Adds 1000 for each row that is completley destroyed and recreates it with 50%chance 
        for (Brick[] row : this.bonus) {
            boolean clear = true;
            int i = 0;
            do {
                if (!row[i].isDestroyed()) {
                    clear = false;
                }
                i++;
            } while ((clear) && (i < 25));
            if (clear) {
                score.addScore(1000);
                
                for (Brick brick : row) {
                    if (new Random().nextInt(10) < 5) {
                        this.recreate(brick);
                    }
                }
            }   
        }
    }
    
    /**
     * Generuje tehlicky na zaklade podmienky
     */
    public void generate(boolean side) {    // Alternative generate excepts bricks on side
        while (true) {
            Brick brick = this.holes.get(new Random().nextInt(this.holes.size()));
            if (!this.sides.contains(brick)) {
                this.recreate(brick); 
                break;
            }
        }
    }
    
    /**
     * Generuje tehlicky
     */
    public void generate() {    // Generate brick from destroyed ones
        Brick brick = this.holes.get(new Random().nextInt(this.holes.size()));   
        this.recreate(brick);             
    }
    
    private void recreate(Brick brick) {    // Transfering bricks from destroyed ones to normal ones
        this.holes.remove(brick);
        this.wall.add(brick);
        brick.recreate();
    }
    
    /**
     * Zabezpecuje odrazanie lopticky od tehliciek a zaroven aktivaciu vylepseni hry ale aj priratava skore za kazdu znicenu kocku
     */
    public boolean hit(Ball ball, Score score, PowerUp powerUp) {
        HitType hitType = null;
        boolean vertical = false;
        HitType filter = null;
        boolean hit = false;
        ArrayList<Brick> remove = new ArrayList<Brick>(); 
        
        for (Brick brick : this.wall) {
            filter = brick.hit(ball);   // Method returns something after every cycle therefore we eliminate null to remove result
                
            if (filter != null) {
                score.additon();
                remove.add(brick);
                hit = true;
                if (filter == HitType.VERTICAL) { // Vertical hit happenes without deciding between left and right side 
                    vertical = true;
                } else {
                    hitType = filter; // Logicaly for every direction there is only one type to be put here therefore we can put it here without UP and DOWN removing eachother
                }
                if (brick.getPowerUp() != null) {   // Attaching powerUps
                    powerUp.attach(brick.getPowerUp());
                }
            }
            
        }
        
        for (Brick brick : remove) {
            this.wall.remove(brick);
            this.holes.add(brick);
        }
        
        if (!ball.isTriggered()) {        
            if (hit) {   // Boolean hit needed for special situations when there are both types without returing after one of them
                if (hitType != null) {
                    ball.hit(hitType);
                }
                if (vertical) {
                    ball.hit(HitType.VERTICAL);
                }
                return true;
            }
        }
        
        
        return false;
    }
}
