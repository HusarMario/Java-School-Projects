package graphic.controls;

/**
 * Trieda predstavujúca klikatelne tlacitko Enter
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Enter extends Clickable {

    /**
     * Vytvorenie noveho enter tlacitka
     * @param x - suradnica x
     * @param y - suradnica y
     * @param width - šírka
     * @param height - výška
     */
    public Enter(int x, int y, int width, int height) {
        super(x, y, width, height, "src/graphic/pictures/misc/Enter.png");
    }
}
