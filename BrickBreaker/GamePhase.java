/**
 * Uchovava konkretnu fazu hry v ktorej sa aplikacia nachadza 
 */
public class GamePhase {
    private GamePhaseType phase;
    
    /**
     * Vytvara hernu fazu
     */
    public GamePhase(GamePhaseType phase) {
        this.phase = phase;
    }
    
    /**
     * Vracia udaj o faze hry
     */
    public GamePhaseType getPhase() {
        return this.phase;
    }
    
    /**
     * Meni udaj o faze hry
     */
    public void setPhase(GamePhaseType phase) {
        this.phase = phase;
    }
}

