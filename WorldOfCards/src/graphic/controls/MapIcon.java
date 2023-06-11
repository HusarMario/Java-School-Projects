package graphic.controls;

import map.Location;

/**
 * Trieda predstavujuca klikatelny obrazok lokácii mapy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class MapIcon extends Clickable {

    private final Location location;

    /**
     * Vytvorenie novej ikony
     * @param x - suradnica x
     * @param y - suradnica y
     * @param size - veľkosť
     * @param location - lokácia pod ikonu
     */
    public MapIcon(int x, int y, int size, Location location) {
        super(x, y, size, location.getPicturePath());
        this.location = location;
    }

    /**
     * Obnovenie obrázku lokácie
     */
    public void refresh() {
        this.changePicturePath(this.location.getPicturePath());
    }

    /**
     * Zobrazenie lokácie observatoriom
     */
    public void observe() {
        this.changePicturePath(this.location.getLocationPicturePath());
    }

    /**
     * Getter pre uloženú lokáciu
     * @return konkrétnu lokáciu
     */
    public Location getLocation() {
        return this.location;
    }


}
