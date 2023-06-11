package characters;

import cards.Card;
import graphic.Obrazok;

/**
 * Abstraktná trieda predstavujúca postavu hry
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Character {

    private final int maxHealth;
    private int health;
    private int armor;

    private Obrazok picture;
    private final String picturePath;


    /**
     * Vytvorenie postavy hry
     * @param health - herný život
     * @param picturePath - cesta k obrázku postavy
     */
    public Character(int health, String picturePath) {

        this.maxHealth = health;
        this.health = health;
        this.armor = 0;

        this.picturePath = picturePath;

        this.loadPicture();
    }

    /**
     * Abstraktná metóda zabezpečuje používanie kariet postavami
     * @param card - zahraná karta
     * @param character - postava, na ktorú je karta používaná
     */
    public abstract void useCard(Card card, Character character);

    /**
     * Metóda resetujúca armor postavy
     */
    public void refreshArmor() {
        this.armor = 0;
    }

    /**
     * Metoda pridávania armoru postavy
     * @param amount - veľkost armoru
     */
    public void gainArmor(int amount) {
        this.armor += amount;
    }


    /**
     * Metóda uberajúca zdravie postavy
     * @param amount - veľkosť poškodenia
     */
    public void lowerHealth(int amount) {
        int truedamage = amount;
        if (this.armor > 0) {
            truedamage -= this.armor;
            this.armor -= amount;
            if (this.armor <= 0) {
                this.armor = 0;
            }
        }

        if (truedamage > 0) {
            this.health -= amount;
        }
    }

    /**
     * Getter pre armor
     * @return hodnota armoru
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Getter pre život
     * @return hodnota života
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Refreshnutie obrázku postavy
     */
    private void loadPicture() {
        this.picture = new Obrazok(this.picturePath);
    }

    /**
     * Getter k obrázku postavy
     * @return Obrázok postavy
     */
    public Obrazok getPicture() {
        return this.picture;
    }

    /**
     * Getter pre cestu k obrázku postavy
     * @return String cesty k obrázku
     */
    public String getPicturePath() {
        return this.picturePath;
    }

    /**
     * Doplnenie životov
     * @param amount - veľkost doplnenia
     */
    public void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
}
