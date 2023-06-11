package graphic;

/**
 * Trieda vytvarajúca grafický dipslej čísiel
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class DisplayNumber implements IShowable {
    private int number;
    private SegmentChar[] display;


    /**
     * Vyvorenie nového displeja
     * @param x - súradnica x
     * @param y - súradnica y
     * @param a - dĺžka čisiel
     * @param b - šírka čisiel
     */
    public DisplayNumber(int x, int y, int a, int b) {
        this.setUpScoreDisplay(x, y, a, b);
        this.number = 0;
    }

    /**
     * Nastavenie displeja
     * @param x - súradnica x
     * @param y - súradnica y
     * @param a - dĺžka čisiel
     * @param b - šírka čísiel
     */
    private void setUpScoreDisplay(int x, int y, int a, int b) {
        this.display = new SegmentChar[3];
        
        for (int i = 0; i < 3; i++) {
            this.display[i] = new SegmentChar(x + i * 25, y, a, b);
        }
    }

    /**
     * Zmena zobrazeného čisla
     * @param number - dosadené čislo
     */
    public void changeNumber(int number) {
        this.number = number;
    }

    /**
     * Vyobrazenie čísiel a zmnea poďla počtu cifier
     */
    @Override
    public void show() {
        int helping = this.number;

        this.display[0].litNum(helping / 100, "black");
        helping = helping % 100;
        if (this.number < 100) {
            this.display[0].litNum(helping / 10, "black");
            helping = helping % 10;
            if (this.number < 10) {
                this.display[0].litNum(helping, "black");
            } else {
                this.display[1].litNum(helping, "black");
            }
        } else {
            this.display[1].litNum(helping / 10, "black");
            helping = helping % 10;
            this.display[2].litNum(helping, "black");
        }


    }

    /**
     * Skrytie displeja na plátne
     */
    @Override
    public void hide() {
        for (SegmentChar segmentChar : this.display) {
            segmentChar.unlit();
        }
    }
}