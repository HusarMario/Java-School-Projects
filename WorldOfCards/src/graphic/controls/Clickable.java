package graphic.controls;

import graphic.IShowable;
import graphic.Obrazok;

/**
 * Trieda predstavujúca klikateľný obrázok pre ovládanie hry
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Clickable implements IShowable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    private final Obrazok picutre;

    /**
     * Vytvorenie nového klikateľného obrázku
     * @param x - súradnica x
     * @param y - súradnica y
     * @param size - veľosť obrázku (šírka rovná výške)
     * @param picutrePath - cesta k obrázku
     */
    public Clickable(int x, int y, int size, String picutrePath) {
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;

        this.picutre = new Obrazok(picutrePath);
        this.picutre.zmenVelkost(this.width, this.height);
        this.picutre.zmenPolohu(this.x, this.y);
    }

    /**
     *
     * @param x - súradnica x
     * @param y - súradnica y
     * @param width - širka obrázku
     * @param height - výška obrázku
     * @param picutrePath - cesta k obrázku
     */
    public Clickable(int x, int y, int width, int height, String picutrePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.picutre = new Obrazok(picutrePath);
        this.picutre.zmenVelkost(this.width, this.height);
        this.picutre.zmenPolohu(this.x, this.y);
    }

    /**
     * Zmena obrázku
     * @param picutrePath - cesta k novému obrázku
     */
    public void changePicturePath(String picutrePath) {
        this.picutre.zmenObrazok(picutrePath);
        this.picutre.show();
    }

    /**
     * Ukáže obrázok na plátne
     */
    public void show() {
        this.picutre.show();
    }

    /**
     * Skryje obrázok na plátne
     */
    public void hide () {
        this.picutre.hide();
    }

    /**
     * Vráti x-ovú súradnicu
     * @return x-ová súradnica
     */
    public int getX() {
        return this.x;
    }

    /**
     * Vráti y-ovú súradnicu
     * @return y-ová súradnica
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vráti šírku obrázka
     * @return - šírka obrázka
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Vráti výšku obrázka
     * @return - výška obrázka
     */
    public int getHeight() {
        return this.height;
    }
}
