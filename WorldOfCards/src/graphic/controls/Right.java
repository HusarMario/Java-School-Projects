package graphic.controls;

/**
 * Trieda predstavujúca klikatelne tlacitko Vpravo
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Right extends Clickable {

    /**
     * Vytvorenie noveho vpravo tlacitka
     * @param x - suradnica x
     * @param y - suradnica y
     * @param size - veľkosť
     */
    public Right(int x, int y, int size) {
        super(x, y, size, "src/graphic/pictures/misc/Right.png");
    }
}
