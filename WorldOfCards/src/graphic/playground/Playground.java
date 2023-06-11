package graphic.playground;

import graphic.IShowable;
import graphic.controls.Clickable;

import java.util.ArrayList;

/**
 * Abstraktná trieda pre grafické vyobrazenie hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public abstract class Playground {
    private final ArrayList<IShowable> obrazky;
    private final ArrayList<Clickable> clickables;

    /**
     * Vytvorenie novej hracej plochy
     */
    public Playground() {
        this.obrazky = new ArrayList<>();
        this.clickables = new ArrayList<>();

        this.setUp();
    }

    /**
     * Abstraktná metóda pre prípravu danej hernej plochy
     */
    public abstract void setUp();

    /**
     * Abstraktná metóda pre refreshnutie prvkov na hernej ploche
     */
    public abstract void refresh();

    /**
     * Pridanie zobraziteľného objeku hracej plochy
     * @param obrazok - zobraziteľný objekt
     */
    public void addShowable(IShowable obrazok) {
        if (obrazok instanceof Clickable) {
            this.clickables.add((Clickable)obrazok);
        }
        this.obrazky.add(obrazok);
    }

    /**
     * Skrytie celej hernej plochy z plátna
     */
    public void hidePlayground() {
        for (IShowable obrazok : this.obrazky) {
            obrazok.hide();
        }
    }

    /**
     * Vyobrazenie celej hernej plochy na plátne
     */
    public void showPlayground() {
        this.refresh();
        for (IShowable obrazok : this.obrazky) {
            obrazok.show();
        }
    }

    /**
     * Metóda spravujúca ovládanie hernej plochy
     * @param x - súradnica x
     * @param y - súradnica y
     * @return - vráti klikateľný objekt pre ďalšie používanie
     */
    public Clickable findClickable(int x, int y) {
        for (Clickable clickable : this.clickables) {
            if (((clickable.getX() <= x) && (clickable.getX() + clickable.getWidth() >= x)) && ((clickable.getY() <= y) && (clickable.getY() + clickable.getHeight() >= y))) {
                return clickable;
            }
        }
        return null;
    }
}
