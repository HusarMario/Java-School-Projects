/**
 * Graficke zobraznie jednotlivych pismenok alebo cisiel
 */
public class SegmentChar {
    private Obdlznik[] lines;
    private int a;
    private int b;

    /**
     * Vytvori segmentovy znak
     */
    public SegmentChar(int x, int y, int a, int b) {
        this.a = a;
        this.b = b;
        
        this.lines = new Obdlznik[7];
        for (int i = 0; i < 7 ;i++) {
            this.lines[i] = new Obdlznik();
            this.lines[i].posunVodorovne(x);
            this.lines[i].posunZvisle(y);
            
            if (i % 3 == 0) {
                this.lines[i].zmenStrany(this.a, this.b);
            } else {
                this.lines[i].zmenStrany(this.b, this.a);
            }
            
            switch (i) {
                case 0: {
                    this.lines[i].posunVodorovne(this.b);
                    break;
                }
                case 1: {
                    this.lines[i].posunVodorovne(this.b + this.a);
                    this.lines[i].posunZvisle(this.b);
                    break;
                }
                case 2: {
                    this.lines[i].posunVodorovne(this.b + this.a);
                    this.lines[i].posunZvisle(this.b + this.a + this.b);
                    break;
                }
                case 3: {
                    this.lines[i].posunVodorovne(this.b);
                    this.lines[i].posunZvisle(this.a + this.b + this.a + this.b);
                    break;
                }
                case 4: {
                    this.lines[i].posunZvisle(this.b + this.a + this.b);
                    break;
                }
                case 5: {
                    this.lines[i].posunZvisle(this.b);
                    break;
                }
                case 6: {
                    this.lines[i].posunVodorovne(this.b);
                    this.lines[i].posunZvisle(this.b + this.a);
                    break;
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
     * Zobrazuje znak od a-z
     */
    public void litChar(char c, String color) {
        this.unlit();
        this.changeColor(color);
        switch (c) {
            case 'a': {
                for (int i = 0; i <= 6; i++) {
                    if (i != 3) {
                        this.lines[i].zobraz();
                    }
                }
                break;
            }
            case 'b': {
                for (int i = 0; i < 7;i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'c': {
                for (int i = 3; i <= 5;i++) {
                    this.lines[i].zobraz();
                }
                this.lines[0].zobraz();
                break;
            }
            case 'd': {
                for (int i = 0; i < 5; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'e': {
                for (int i = 3; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[0].zobraz();
                break;
            }
            case 'f': {
                for (int i = 4; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[0].zobraz();
                break;
            }
            case 'g' : {
                for (int i = 2; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[0].zobraz();
                break;
            }
            case 'h' : {
                for (int i = 1; i < 3; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 4; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'i' : {
                for (int i = 4; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'j': {
                for (int i = 1; i < 4; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'k': {
                for (int i = 4; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[0].zobraz();
                this.lines[2].zobraz();
                break;
            }
            case 'l': {
                for (int i = 3; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'm': {
                for (int i = 0; i < 2; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[3].zobraz();
                this.lines[5].zobraz();
                break;
            }
            case 'n': {
                for (int i = 0; i < 3; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 4; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'o': {
                for (int i = 0; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'p': {
                for (int i = 0; i < 2; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 4; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'q': {
                for (int i = 0; i < 2; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 5; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[3].zobraz();
                break;
            }
            case 'r': {
                for (int i = 0; i < 2; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 3; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 's': {
                this.lines[0].zobraz();
                for (int i = 0; i < 7; i = i + 3) {
                    this.lines[i].zobraz();
                }
                for (int i = 2; i < 6; i = i + 3) {
                    this.lines[i].zobraz();
                } 
                break;
            }
            case 't': {
                this.lines[0].zobraz();
                for (int i = 4; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'u': {
                for (int i = 1; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'v': {
                for (int i = 1; i < 4; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[5].zobraz();
                break;
            }
            case 'w': {
                this.lines[0].zobraz();
                for (int i = 2; i < 5; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'x': {
                for (int i = 0; i < 7; i = i + 3) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 'y': {
                for (int i = 1; i < 7; i = i + 2) {
                    this.lines[i].zobraz();
                }
                this.lines[6].zobraz();
                break;
            }
            case 'z': {
                for (int i = 0; i < 2; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 3; i < 5; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[6].zobraz();
                break;
            }
        }
    }

    /**
     * Zobrazuje cislo od 0-9
     */
    public void litNum(int number, String color) {
        this.unlit();
        this.changeColor(color);
        switch (number) { 
            case 0: {
                for (int i = 0; i < 6; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 1: {
                for (int i = 1; i < 3 ; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 2: {
                for (int i = 0; i < 7 ; i++) {
                    if ((i != 2) && (i != 5)) {
                        this.lines[i].zobraz();
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < 4 ; i++) {
                    this.lines[i].zobraz();
                }
                this.lines[6].zobraz();
                break;
            }
            case 4: {
                for (int i = 1; i < 3 ; i++) {
                    this.lines[i].zobraz();
                }
                for (int i = 5; i < 7 ; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 5: {
                for (int i = 0; i < 7 ; i++) {
                    if ((i != 1 ) && (i != 4)) {
                        this.lines[i].zobraz();
                    }
                }
                break;
            }
            case 6: {
                for (int i = 0; i < 7 ; i++) {
                    if (i != 1) {
                        this.lines[i].zobraz();
                    }
                }
                break;
            }
            case 7: {
                for (int i = 0; i < 3 ; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 8: {
                for (int i = 0; i < 7; i++) {
                    this.lines[i].zobraz();
                }
                break;
            }
            case 9: {
                for (int i = 0; i < 7 ; i++) {
                    if (i != 4 ) {
                        this.lines[i].zobraz();
                    }
                }
                break;
            }
        }
    }
}
