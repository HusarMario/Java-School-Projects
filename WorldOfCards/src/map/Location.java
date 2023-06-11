package map;

/**
 * Abstraktná trieda predstavujúca lokácie na mape
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Location {

    private boolean visited;
    private boolean shown;

    private String activePath;
    private final String locationPicturePath;
    private final String locationVisitedPath;
    private final String locationInfoPath;

    /**
     * Vytvorenie novej lokácie
     * @param locationPicturePath - cesta k obrázku lokácie
     * @param locationInfoPath - cesta k obrázku o infe lokácie
     */
    public Location(String locationPicturePath, String locationInfoPath) {
        this.visited = false;
        this.shown = false;

        String locationHiddenPath = "src/graphic/pictures/locations/QuestionMark.png";
        this.locationPicturePath = locationPicturePath;
        this.locationVisitedPath = "src/graphic/pictures/locations/CrossedMark.png";
        this.locationInfoPath = locationInfoPath;

        this.activePath = locationHiddenPath;
    }

    /**
     * Vstúpenie do miestnosti
     */
    public void enterLocation() {
        this.activePath = this.locationVisitedPath;
        this.visited = true;
    }

    /**
     * Zobrazenie danej miestnosti
     */
    public void showLoaction() {
        if (!this.visited) {
            this.activePath = this.locationPicturePath;
            this.shown = true;
        }

    }

    /**
     * Získanie aktívnej cesty k obrázku
     * @return aktívna cesta
     */
    public String getPicturePath() {
        return this.activePath;
    }

    /**
     * Získanie pravej cesty k obrázku
     * @return pravá cesta
     */
    public String getLocationPicturePath() {
        return this.locationPicturePath;
    }

    /**
     * Získanie cesty k infe o obrázku
     * @return cesta k infu o obrázku
     */
    public String getLocationInfoPath() {
        return this.locationInfoPath;
    }

    /**
     * Getter pre boolean navštivenosti
     * @return true ak lokácia bola navštívená
     */
    public boolean isVisited() {
        return this.visited;
    }

    /**
     * Getter pre booelan zobrazenia
     * @return true ak lokácia bola zobrazená
     */
    public boolean isShown() {
        return this.shown;
    }


}
