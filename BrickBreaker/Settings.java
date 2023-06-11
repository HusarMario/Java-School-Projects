/**
 * Miesto pre zmenu nastaveni aplikacie
 */
public class Settings {
    private Tab title;
    private Tab size;
    private Tab sizeSmall;
    private Tab sizeLarge;
    private Tab lives;
    private Tab livesThree;
    private Tab livesFive;
    private Tab generate;
    private Tab all;
    private Tab paddle;
    private Tab back;
    
    private Tab[] underlines;
    
    /**
     * Vytvori miesto pre zmenu nastaveni aplikacie
     */
    public Settings(Configuration configuration) {
        this.setUpSettings();
        this.setUpUnderlines(configuration);
    }
    
    private void setUpSettings() {
        this.title = new Tab(150, 40, "settings", 200, 50, false);
        
        this.size = new Tab(20, 110, "size", 200, 45, false);
        this.sizeSmall = new Tab(50, 160, " small", 200, 45, true);
        this.sizeLarge = new Tab(275, 160, " large", 200, 45, true);
        
        this.lives = new Tab(20, 210, "lives", 200, 45, false);
        this.livesThree = new Tab(50, 260, " three", 200, 45, true);
        this.livesFive = new Tab(275, 260, "  five", 200, 45, true);
        
        this.generate = new Tab(20, 310, "generate", 200, 45, false);
        this.all = new Tab(50, 360, "  all", 200, 45, true);
        this.paddle = new Tab(275, 360, "paddle", 200, 45, true);
        
        
        this.back = new Tab(150, 440, " return", 200, 50, true);
    }
    
    private void setUpUnderlines(Configuration configuration) {
        this.underlines = new Tab[6];
        
        this.underlines[0] = new Tab(50, 160 + 45, "", 200, 2, !configuration.isBigSize());
        this.underlines[1] = new Tab(275, 160 + 45, "", 200, 2, configuration.isBigSize());
        
        this.underlines[2] = new Tab(50, 260 + 45, "", 200, 2, !configuration.isBonusLives());
        this.underlines[3] = new Tab(275, 260 + 45, "", 200, 2, configuration.isBonusLives());
        
        this.underlines[4] = new Tab(50, 360 + 45, "", 200, 2, configuration.isSidesGenerate());
        this.underlines[5] = new Tab(275, 360 + 45, "", 200, 2, !configuration.isSidesGenerate());
        
    }
    
    /**
     * Zabezpecuje vykonavanie prikazov jednotlivych okien
     */
    public boolean press(int x, int y, GamePhase phase, Configuration configuration) {
        if ((x > this.sizeSmall.getTabX() && x < this.sizeSmall.getTabX() + this.sizeSmall.getLength()) && ((y > this.sizeSmall.getTabY() && y < this.sizeSmall.getTabY() + this.sizeSmall.getWidth()))) {
            if (configuration.isBigSize()) {
                configuration.changeBigSize();
                this.underlines[0].toggle(true);
                this.underlines[1].toggle(false);
                return true;
            }
        }
        
        if ((x > this.sizeLarge.getTabX() && x < this.sizeLarge.getTabX() + this.sizeLarge.getLength()) && ((y > this.sizeLarge.getTabY() && y < this.sizeLarge.getTabY() + this.sizeLarge.getWidth()))) {
            if (!configuration.isBigSize()) {
                configuration.changeBigSize();
                this.underlines[0].toggle(false);
                this.underlines[1].toggle(true);
                return true;
            }
        } 
            
        if ((x > this.livesThree.getTabX() && x < this.livesThree.getTabX() + this.livesThree.getLength()) && ((y > this.livesThree.getTabY() && y < this.livesThree.getTabY() + this.livesThree.getWidth()))) {
            if (configuration.isBonusLives()) {
                configuration.changeBonusLives(); 
                this.underlines[2].toggle(true);
                this.underlines[3].toggle(false);
                return true;
            }
        } 
            
        if ((x > this.livesFive.getTabX() && x < this.livesFive.getTabX() + this.livesFive.getLength()) && ((y > this.livesFive.getTabY() && y < this.livesFive.getTabY() + this.livesFive.getWidth()))) {
            if (!configuration.isBonusLives()) {
                configuration.changeBonusLives();
                this.underlines[2].toggle(false);
                this.underlines[3].toggle(true);
                return true;
            }
        }
            
        if ((x > this.all.getTabX() && x < this.all.getTabX() + this.all.getLength()) && ((y > this.all.getTabY() && y < this.all.getTabY() + this.all.getWidth()))) {
            if (!configuration.isSidesGenerate()) {
                configuration.changeSidesGenerate(); 
                this.underlines[4].toggle(true);
                this.underlines[5].toggle(false);
                return true;
            }
        }
            
        if ((x > this.paddle.getTabX() && x < this.paddle.getTabX() + this.paddle.getLength()) && ((y > this.paddle.getTabY() && y < this.paddle.getTabY() + this.paddle.getWidth()))) {
            if (configuration.isSidesGenerate()) {
                configuration.changeSidesGenerate(); 
                this.underlines[4].toggle(false);
                this.underlines[5].toggle(true);
                return true;
            }
        }
            
        if ((x > this.back.getTabX() && x < this.back.getTabX() + this.back.getLength()) && ((y > this.back.getTabY() && y < this.back.getTabY() + this.back.getWidth()))) {
            phase.setPhase(GamePhaseType.MENU);
            return true;
        }
        
        return false;
    }
}
