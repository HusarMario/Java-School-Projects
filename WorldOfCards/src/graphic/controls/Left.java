package graphic.controls;

/**
 * Trieda predstavujúca klikatelne tlacitko Vľavo
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Left extends Clickable {

    /**
     * Vytvorenie noveho vlavo tlacitka
     * @param x - suradnica x
     * @param y - suradnica y
     * @param size - veľkosť
     */
    public Left(int x, int y, int size) {
        super(x, y, size, "src/graphic/pictures/misc/Left.png");
    }
}
