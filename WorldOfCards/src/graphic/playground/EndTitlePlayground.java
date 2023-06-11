package graphic.playground;

import graphic.Obrazok;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class EndTitlePlayground extends Playground {

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public EndTitlePlayground() {
        super();
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        Obrazok text = new Obrazok("src/graphic/pictures/misc/Died.png");
        text.zmenVelkost(1000, 200);
        text.zmenPolohu(250, 300);
        this.addShowable(text);
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {

    }
}
