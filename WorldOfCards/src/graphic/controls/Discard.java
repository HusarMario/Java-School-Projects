package graphic.controls;

/**
 * Trieda predstavujúca klikatelne tlacitko Discard
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Discard extends Clickable {

    /**
     * Vytvorenie noveho discard tlacitka
     * @param x - suradnica x
     * @param y - suradnica y
     * @param width - šírka
     * @param height - výška
     */
    public Discard(int x, int y, int width, int height) {
        super(x, y, width, height, "src/graphic/pictures/misc/Discard.png");
    }
}
