/**
 * Uchovava nastavenie pre hru, ktore moze byt zmenene
 */
public class Configuration {
    private boolean bonusLives;
    private boolean bigSize;
    private boolean sidesGenerate;
    
    /**
     * Vytvori nastavenia
     */
    public Configuration() {
        this.bonusLives = false;
        this.bigSize = false;
        this.sidesGenerate = true;
    }
    
    /**
     * Vracia informaciu o zmene nastavenia o bonusovych zivotoch
     */
    public boolean isBonusLives() {
        return this.bonusLives;
    }
    
    /**
     * Vracia informaciu o zmene nastavenia o velkosti odrazadla
     */
    public boolean isBigSize() {
        return this.bigSize;
    }
    
    /**
     * Vracia informaciu o zmene nastavenia o sposobe generovania
     */
    public boolean isSidesGenerate() {
        return this.sidesGenerate;
    }
    
    /**
     * Meni nastavenie o bonusovych zivotoch
     */
    public void changeBonusLives() {
        if (this.bonusLives) {
            this.bonusLives = false;
        } else {
            this.bonusLives = true;
        }
    }
    
    /**
     * Meni nastavenie o velkosti odrazadla 
     */
    public void changeBigSize() {
        if (this.bigSize) {
            this.bigSize = false;
        } else {
            this.bigSize = true;
        }
    }
    
    /**
     * Meni nastavenie o sposobe generovania
     */
    public void changeSidesGenerate() {
        if (this.sidesGenerate) {
            this.sidesGenerate = false;
        } else {
            this.sidesGenerate = true;
        }
    }
}
