/**
 * Hlavne menu aplikacie
 */
public class Menu {
    private Tab title;
    private Tab play;
    private Tab settings;
    private Tab highScore;
    private Tab exit;
    
    /**
     * Vytvori hlavne menu
     */
    public Menu() {
        this.setUpMenu();  
    }
    
    private void setUpMenu() {
        this.title = new Tab(100, 40, "brickbreaker", 300, 50, false);
        this.play = new Tab(150, 130, "  play", 200, 50, true);
        this.settings = new Tab(150, 230, "settings", 200, 50, true);
        this.highScore = new Tab(150, 330, "  score", 200, 50, true);
        this.exit = new Tab(150, 430, "  exit", 200, 50, true);           
    }

    /**
     * Zabezpecuje vykonavanie prikazov jednotlivych okien
     */
    public boolean press(int x, int y, GamePhase phase) {
        if ((x > this.play.getTabX() && x < this.play.getTabX() + this.play.getLength()) && ((y > this.play.getTabY() && y < this.play.getTabY() + this.play.getWidth()))) {
            phase.setPhase(GamePhaseType.GAME);
            return true;
        }
        
        if ((x > this.settings.getTabX() && x < this.settings.getTabX() + this.settings.getLength()) && ((y > this.settings.getTabY() && y < this.settings.getTabY() + this.settings.getWidth()))) {
            phase.setPhase(GamePhaseType.SETTINGS);
            return true;
        }
        
        if ((x > this.highScore.getTabX() && x < this.highScore.getTabX() + this.highScore.getLength()) && ((y > this.highScore.getTabY() && y < this.highScore.getTabY() + this.highScore.getWidth()))) {
            phase.setPhase(GamePhaseType.HIGHSCORE);
            return true;
        }
        
        if ((x > this.exit.getTabX() && x < this.exit.getTabX() + this.exit.getLength()) && ((y > this.exit.getTabY() && y < this.exit.getTabY() + this.exit.getWidth()))) {
            phase.setPhase(GamePhaseType.EXIT);
            return true;
        }
        
        return false;
    }
}
