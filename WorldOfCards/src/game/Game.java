package game;

import graphic.playground.*;
import map.BattleLocation;
import map.FallenBridgeLocation;
import map.Observatory;
import map.PotionMaker;
import player.Player;

import java.util.Random;

/**
 * Hlavné ovládanie hry.
 * Spočíva len v klikaní myšou cez metódu vyber súradnice.
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Game {
    private GamePhase gamePhase;

    private Player player;

    public Game() {
        Manazer manager = new Manazer();
        manager.spravujObjekt(this);

        this.changePhase(GamePhase.TITLE);
    }

    /**
     * Zabezpečuje výber súradníc vďaka manažérovi a určuje následne vykonávanie programu.
     * @param x x-ova suradnica
     * @param y y-ova suradnica
     */
    public void vyberSuradnice(int x, int y) {
        switch (this.gamePhase) {
            case TITLE -> {
                if (this.gamePhase.getPlayground().findClickable(x, y) != null) {
                    this.changePhase(GamePhase.CREATION);
                }
            }
            case CREATION -> {
                if (this.gamePhase.getPlayground().findClickable(x, y) != null) {
                    this.player = ((PlayerCreatorPlayground) this.gamePhase.getPlayground()).getPlayerCreator().getPlayer();
                    for (GamePhase phase : GamePhase.values()) {
                        if (phase.getPlayground() instanceof IPlayerNeeded) {
                            ((IPlayerNeeded) phase.getPlayground()).attachPlayer(this.player);
                        }
                    }
                    this.changePhase(GamePhase.MAP);
                }
            }
            case MAP -> {
                if (((WorldPlayground) this.gamePhase.getPlayground()).getObservatoryPlayground() != null) {
                    ((WorldPlayground) this.gamePhase.getPlayground()).observer();
                } else if (this.gamePhase.getPlayground().findClickable(x, y) != null) {
                    if (((WorldPlayground)this.gamePhase.getPlayground()).getEnter() instanceof BattleLocation) {
                        ((BattleLocationPlayground) GamePhase.BATTLE.getPlayground()).attachEnemy(((BattleLocation) ((WorldPlayground) this.gamePhase.getPlayground()).getEnter()).getEnemy());
                        this.gamePhase.getPlayground().refresh();
                        this.changePhase(GamePhase.BATTLE);
                    }
                    if (((WorldPlayground)this.gamePhase.getPlayground()).getEnter() instanceof PotionMaker) {
                        this.gamePhase.getPlayground().refresh();
                        this.changePhase(GamePhase.MARKET);
                    }
                    if (((WorldPlayground)this.gamePhase.getPlayground()).getEnter() instanceof FallenBridgeLocation) {
                        Random random = new Random();
                        if (random.nextInt(0,100) < 10) {
                            this.changePhase(GamePhase.END);
                        }
                        this.gamePhase.getPlayground().refresh();
                    }
                    if (((WorldPlayground)this.gamePhase.getPlayground()).getEnter() instanceof Observatory) {
                        if (this.player.getGold() >= 100) {
                            this.player.spendGold(100);
                            ((WorldPlayground) this.gamePhase.getPlayground()).observer();
                        }
                    }
                }
            }
            case BATTLE -> {
                if (this.gamePhase.getPlayground().findClickable(x, y) != null) {
                    if (this.player.getHero().getHealth() > 0) {
                        if (((WorldPlayground)GamePhase.MAP.getPlayground()).finalLocation()) {
                            this.changePhase(GamePhase.WIN);
                        } else {
                            this.changePhase(GamePhase.MAP);
                        }
                    } else {
                        this.changePhase(GamePhase.END);
                    }
                }
            }

            case MARKET -> {
                if (this.gamePhase.getPlayground().findClickable(x, y) != null) {
                    this.changePhase(GamePhase.MAP);
                }
            }

            case END, WIN -> System.exit(1);
        }
    }

    private void changePhase (GamePhase gamePhase) {
        if (this.gamePhase != null) {
            this.gamePhase.getPlayground().hidePlayground();
        }
        this.gamePhase = gamePhase;
        this.gamePhase.getPlayground().showPlayground();
    }
}
