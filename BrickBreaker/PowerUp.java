/**
 * Uchovava konkretne vylepsenie hry, ktore moze byt pouzite
 */
public class PowerUp {
    private PowerUpType powerUp;
    
    /**
     * Vytvori herne vylepsenie
     */
    public PowerUp() {
        this.setUpPowerUp();
    }
    
    private void setUpPowerUp() {
        this.deattach();
    }
    
    /**
     * Vlozi konkretne vylepsenie hry na neskorsie pouzitie
     */
    public void attach(PowerUpType powerUp) {
        this.powerUp = powerUp;
    }
    
    /**
     * Zmaze konkretne vylepsenie hry pre moznost dosadenia noveho
     */
    public void deattach() {
        this.powerUp = null;
    }
    
    /**
     * Aktivuje konkretne vylepsenie hry
     */
    public void activate(Lives lives, Score score, Ball ball) {
        switch (this.powerUp) {
            case LIFE: {
                if (lives.getLives() < lives.getAmount()) {
                    lives.regainLife();
                    break;
                } else {
                    score.addScore(50);
                }
                break;
            }
            case SCORE: {
                score.doubleUp();
                ball.doubleUp();
                break;
            }
            case BALL: {
                ball.trigger();
                break;
            }
        }
    }
    
    /**
     * Vracia udaj o vlozenom vylepseni hry
     */
    public PowerUpType getPowerUp() {
        return this.powerUp;
    }
}
