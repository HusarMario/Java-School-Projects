package characters.hero;

import cards.Card;
import cards.packs.CardPack;
import characters.Character;

/**
 * Abstraktná trieda predstavujúceho hrdinu
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Hero extends Character {
    private int energy;
    private int energyLimit;

    private int experience;
    private int level;

    private final CardPack cardPack;

    /**
     * Vytvorenie hrdinu (postavy)
     * @param health - život postavy
     * @param cardPack - pridelený začiatočný balíček
     * @param energyLimit - limit energie
     * @param picturePath - cesta k obrázku postavy
     */
    public Hero(int health, CardPack cardPack, int energyLimit, String picturePath) {
        super(health, picturePath);
        this.experience = 0;
        this.level = 1;
        this.energyLimit = energyLimit;
        this.energy = energyLimit;
        this.cardPack = cardPack;
    }

    /**
     * Zabezpečuje zahranie karty
     * @param card - zahraná karta
     * @param target - postava na ktorá je karta používaná
     */
    @Override
    public void useCard(Card card, Character target) {
        card.use(this, target);
    }

    /**
     * Getter pre energiu
     * @return hodnota energie
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * Zníženie energie
     * @param amount veľkost zníženia
     */
    public void lowerEnergy(int amount) {
        this.energy -= amount;
    }

    /**
     * Getter pre limit energie
     * @return hodnota limtu
     */
    public int getEnergyLimit() {
        return this.energyLimit;
    }

    /**
     * Getter pre balíček kariet
     * @return balíček kariet
     */
    public CardPack getCardPack() {
        return this.cardPack;
    }

    /**
     * Pridanie skúseností pre zvýšenie levelu a zabezpečenie levelovania
     * @param amount - veľkosť skúseností
     */
    public void addExperience(int amount) {
        if (this.level == 3) {
            return;
        }
        this.experience += amount;


        if (this.experience >= 100) {
            int rest = this.experience - 100;
            this.level++;
            this.energyLimit++;
            this.experience = rest;
        }
    }

    /**
     * Resetovanie energie vzhľadom na limit energie
     */
    public void refreshEnery() {
        this.energy = this.energyLimit;
    }
}
