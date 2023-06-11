package game;

import graphic.playground.BattleLocationPlayground;
import graphic.playground.EndTitlePlayground;
import graphic.playground.MarketPlayground;
import graphic.playground.PlayerCreatorPlayground;
import graphic.playground.Playground;
import graphic.playground.TitlePlayground;
import graphic.playground.WinPlayground;
import graphic.playground.WorldPlayground;

/**
 * Enum určuje momentálne správanie sa hry.
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public enum GamePhase {
    TITLE (new TitlePlayground()),
    MAP(new WorldPlayground()),
    CREATION(new PlayerCreatorPlayground()),
    BATTLE(new BattleLocationPlayground()),
    END(new EndTitlePlayground()),
    MARKET(new MarketPlayground()),
    WIN(new WinPlayground());

    private final Playground playground;

    GamePhase(Playground playground) {
        this.playground = playground;
    }

    public Playground getPlayground() {
        return this.playground;
    }


}
