package graphic.playground;

import graphic.controls.MapIcon;
import map.Location;
import map.World;

import java.util.ArrayList;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class ObservatoryPlayground extends Playground {
    private final World world;

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public ObservatoryPlayground(World world) {
        super();
        this.world = world;
        this.refresh();

    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {

        ArrayList<MapIcon> mapIcons = new ArrayList<>();
        int col = 0;
        int row = 1;
        for (Location location : this.world.getLocations()) {
            if ((this.world.getLocations().get(0).equals(location)) || (this.world.getLocations().get(this.world.getLocations().size() - 1).equals(location))) {
                mapIcons.add(new MapIcon(65 + (col * 65), 300, 50, location));
                col++;
            } else {
                switch (row) {
                    case 1 -> {
                        mapIcons.add(new MapIcon(65 + col * 65, 200, 50, location));
                        row++;
                    }
                    case 2 -> {
                        mapIcons.add(new MapIcon(65 + col * 65, 300, 50, location));
                        row++;
                    }
                    case 3 -> {
                        mapIcons.add(new MapIcon(65 + col * 65, 400, 50, location));
                        row = 1;
                        col++;
                    }
                }
            }
        }

        for (MapIcon mapIcon : mapIcons) {
            mapIcon.observe();
            this.addShowable(mapIcon);
        }
    }
}
