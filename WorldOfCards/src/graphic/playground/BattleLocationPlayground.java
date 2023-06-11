package graphic.playground;

import battle.Battle;
import characters.enemy.Enemy;
import graphic.DisplayNumber;
import graphic.Obrazok;
import graphic.controls.CardIcon;
import graphic.controls.Clickable;
import graphic.controls.Discard;
import graphic.controls.Left;
import graphic.controls.Right;
import player.Player;


/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class BattleLocationPlayground extends Playground implements IPlayerNeeded {
    private Player player;
    private DisplayNumber playerHealth;
    private DisplayNumber playerEnergy;
    private DisplayNumber playerArmor;

    private Enemy enemy;
    private Obrazok enemyPicture;
    private DisplayNumber enemyHealth;
    private DisplayNumber enemyArmor;

    private Battle battle;
    private CardIcon pickedCard;

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public BattleLocationPlayground() {
        super();
    }

    /**
     * Metóda pre ovládanie s konkrétnou hernou plochou
     * @param x - súradnica x
     * @param y - súradnica y
     * @return vráti klikateľný objekt pre ďalšiu prácu s ním
     */
    @Override
    public Clickable findClickable(int x, int y) {
        Clickable clickable = super.findClickable(x, y);

        if (clickable instanceof Left) {
            this.pickedCard.changePicturePath(this.battle.getHand().prevCard().getPicturePath());
            this.pickedCard.setCard(this.battle.getHand().getCard());
            this.pickedCard.show();
        }

        if (clickable instanceof Right) {
            this.pickedCard.changePicturePath(this.battle.getHand().nextCard().getPicturePath());
            this.pickedCard.setCard(this.battle.getHand().getCard());
            this.pickedCard.show();
        }

        if (clickable instanceof Discard) {
            this.battle.discard(this.pickedCard.getCard());
            this.pickedCard.changePicturePath(this.battle.getHand().getCard(0).getPicturePath());
            this.pickedCard.setCard(this.battle.getHand().getCard(0));
            this.pickedCard.show();
            this.refresh();

            if (this.player.getHero().getHealth() < 0) {
                return clickable;
            }
        }

        if (clickable instanceof CardIcon) {
            if (this.battle.cardCost(this.pickedCard.getCard())) {
                if (this.battle.playerTurn(this.pickedCard.getCard())) {
                    this.player.getHero().refreshArmor();
                    this.player.getHero().refreshEnery();
                    return clickable;
                }
                this.pickedCard.changePicturePath(this.battle.getHand().getCard(0).getPicturePath());
                this.pickedCard.setCard(this.battle.getHand().getCard(0));
                this.pickedCard.show();
                this.refresh();
            }

        }

        return null;
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {
        this.playerHealth.hide();
        this.playerHealth.changeNumber(this.player.getHero().getHealth());
        this.playerHealth.show();
        this.playerArmor.hide();
        this.playerArmor.changeNumber(this.player.getHero().getArmor());
        this.playerArmor.show();
        this.playerEnergy.hide();
        this.playerEnergy.changeNumber(this.player.getHero().getEnergy());
        this.playerEnergy.show();
        this.enemyHealth.hide();
        this.enemyHealth.changeNumber(this.enemy.getHealth());
        this.enemyHealth.show();
        this.enemyArmor.hide();
        this.enemyArmor.changeNumber(this.enemy.getArmor());
        this.enemyArmor.show();
    }

    /**
     * Doplenenie nepriatela do hracej plochy
     * @param enemy - nepriatel
     */
    public void attachEnemy(Enemy enemy) {
        this.enemy = enemy;
        this.battle.setEnemy(this.enemy);
        this.battle.resetHand();

        if (this.enemyPicture == null) {
            this.enemyPicture = new Obrazok(this.enemy.getPicturePath());
            this.enemyPicture.zmenPolohu(1330, 20);
            this.enemyPicture.zmenVelkost(150, 150);
            this.addShowable(this.enemyPicture);
        } else {
            this.enemyPicture.zmenObrazok(this.enemy.getPicturePath());
            this.enemyPicture.show();
        }

        this.enemyHealth.changeNumber(this.enemy.getHealth());
        this.enemyHealth.show();

        this.refresh();
    }

    /**
     * Doplennie hráča do hernej plochy
     * @param player - hráč
     */
    @Override
    public void attachPlayer(Player player) {
        this.player = player;
        this.battle = new Battle(this.player);
        this.battle.resetHand();

        Obrazok playerPicture = new Obrazok(this.player.getHero().getPicturePath());
        playerPicture.zmenPolohu(20, 20);
        playerPicture.zmenVelkost(150, 150);
        this.addShowable(playerPicture);

        this.playerHealth.changeNumber(this.player.getHero().getHealth());
        this.playerEnergy.changeNumber(this.player.getHero().getEnergy());

        this.pickedCard = new CardIcon(475, 0, 550, 800, this.battle.getHand().getCard());
        this.pickedCard.setCard(this.battle.getHand().getCard());
        this.addShowable(this.pickedCard);
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        this.addShowable(new Discard(90, 700, 300, 50));
        this.addShowable(new Left(400, 375, 50));
        this.addShowable(new Right(1050, 375, 50));

        this.playerHealth = new DisplayNumber(60, 210, 8, 2);
        this.addShowable(this.playerHealth);
        this.playerArmor = new DisplayNumber(60, 260, 8 , 2);
        this.addShowable(this.playerArmor);
        this.playerEnergy = new DisplayNumber(60, 310, 8 , 2);
        this.addShowable(this.playerEnergy);

        this.enemyHealth = new DisplayNumber(1400, 210, 8, 2);
        this.addShowable(this.enemyHealth);
        this.enemyArmor = new DisplayNumber(1400, 260, 8, 2);
        this.addShowable(this.enemyArmor);

        Obrazok playerHealthIcon = new Obrazok("src/graphic/pictures/atributes/Health.png");
        playerHealthIcon.zmenPolohu(20, 200);
        playerHealthIcon.zmenVelkost(30, 30);
        this.addShowable(playerHealthIcon);

        Obrazok playerArmorIcon = new Obrazok("src/graphic/pictures/atributes/Armor.png");
        playerArmorIcon.zmenPolohu(20, 250);
        playerArmorIcon.zmenVelkost(30, 30);
        this.addShowable(playerArmorIcon);

        Obrazok playerEnergyIcon = new Obrazok("src/graphic/pictures/atributes/Energy.png");
        playerEnergyIcon.zmenPolohu(20, 300);
        playerEnergyIcon.zmenVelkost(30, 30);
        this.addShowable(playerEnergyIcon);



        this.enemyPicture = null;
        Obrazok enemyHealthIcon = new Obrazok("src/graphic/pictures/atributes/Health.png");
        enemyHealthIcon.zmenPolohu(1450, 200);
        enemyHealthIcon.zmenVelkost(30, 30);
        this.addShowable(enemyHealthIcon);

        Obrazok enemyArmorIcon = new Obrazok("src/graphic/pictures/atributes/Armor.png");
        enemyArmorIcon.zmenPolohu(1450, 250);
        enemyArmorIcon.zmenVelkost(30, 30);
        this.addShowable(enemyArmorIcon);
    }
}
