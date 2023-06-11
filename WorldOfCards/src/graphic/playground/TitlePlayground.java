package graphic.playground;

import graphic.Obrazok;
import graphic.controls.Clickable;
import graphic.controls.Enter;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class TitlePlayground extends Playground {

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public TitlePlayground() {
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
        return super.findClickable(x, y);
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        Obrazok title = new Obrazok("src/graphic/pictures/Title.png");
        title.zmenVelkost(1000, 200);
        title.zmenPolohu(250, 300);
        this.addShowable(title);

        this.addShowable(new Enter(600, 700, 300, 50));
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {

    }
}
