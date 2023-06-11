package graphic.playground;

import player.Player;

/**
 * Rozhranie herných plôch ktoré vyžadujú osobitné dosadenie vytvoreného hráča
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public interface IPlayerNeeded {
    void attachPlayer(Player player);
}
