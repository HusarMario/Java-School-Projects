package graphic;

/**
 * Grafické zobrazenie cifier
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class SegmentChar {
    private final Obdlznik[] lines;

    /**
     * Vytvori segmentovy znak
     */
    public SegmentChar(int x, int y, int a, int b) {

        this.lines = new Obdlznik[7];
        for (int i = 0; i < 7 ;i++) {
            this.lines[i] = new Obdlznik();
            this.lines[i].posunVodorovne(x);
            this.lines[i].posunZvisle(y);
            
            if (i % 3 == 0) {
                this.lines[i].zmenStrany(a, b);
            } else {
                this.lines[i].zmenStrany(b, a);
            }

            switch (i) {
                case 0 -> this.lines[i].posunVodorovne(b);
                case 1 -> {
                    this.lines[i].posunVodorovne(b + a);
                    this.lines[i].posunZvisle(b);
                }
                case 2 -> {
                    this.lines[i].posunVodorovne(b + a);
                    this.lines[i].posunZvisle(b + a + b);
                }
                case 3 -> {
                    this.lines[i].posunVodorovne(b);
                    this.lines[i].posunZvisle(a + b + a + b);
                }
                case 4 -> this.lines[i].posunZvisle(b + a + b);
                case 5 -> this.lines[i].posunZvisle(b);
                case 6 -> {
                    this.lines[i].posunVodorovne(b);
                    this.lines[i].posunZvisle(b + a);
                }
            }
        }
    }
    
    private void changeColor(String color) {
        for (int i = 0; i < 7 ;i++) {
            this.lines[i].zmenFarbu(color);
        }
    }
    
    /**
     * Ukryva jendotlivy znak
     */
    public void unlit() {
        for (int i = 0; i < 7; i++) {
            this.lines[i].skry();
        }
    }

    /**
     * Zobrazuje cislo od 0-9
     */
    public void litNum(int number, String color) {
        this.unlit();
        this.changeColor(color);
        switch (number) {
            case 0 -> {
                for (int i = 0; i < 6; i++) {
                    this.lines[i].zobraz();
                }
            }
            case 1 -> {
                for (int i = 1; i < 3; i++) {
                    this.lines[i].zobraz();
                }
            }
            case 2 -> {
                for (int i = 0; i < 7; i++) {
                    if ((i != 2) && (i != 5)) {
                        this.lines[i].zobraz();
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < 4; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[6].zobraz();
            }
            case 4 -> {
                for (int i = 1; i < 3; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 5; i < 7; i++) {
                    this.lines[i].zobraz();
                }
            }
            case 5 -> {
                for (int i = 0; i < 7; i++) {
                    if ((i != 1) && (i != 4)) {
                        this.lines[i].zobraz();
                    }
                }
            }
            case 6 -> {
                for (int i = 0; i < 7; i++) {
                    if (i != 1) {
                        this.lines[i].zobraz();
                    }
                }
            }
            case 7 -> {
                for (int i = 0; i < 3; i++) {
                    this.lines[i].zobraz();
                }
            }
            case 8 -> {
                for (int i = 0; i < 7; i++) {
                    this.lines[i].zobraz();
                }
            }
            case 9 -> {
                for (int i = 0; i < 7; i++) {
                    if (i != 4) {
                        this.lines[i].zobraz();
                    }
                }
            }
        }
    }
}
