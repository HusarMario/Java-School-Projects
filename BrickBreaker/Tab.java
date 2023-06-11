/**
 * Spustatelne graficke okno, ktore dokaze sluzit ako vlozenie textu alebo aj ako spinac aplikacie
 */
public class Tab {
    private Obdlznik outline;
    private Obdlznik inside;
    private SegmentChar[] name;
    private boolean array;
    private int x;
    private int y;
    private int length;
    private int width;
    
    /**
     * Vytvara graficke okno
     */
    public Tab(int x, int y, String text, int length, int width, boolean array) {
        this.loadUpStats(x, y, length, width);
        this.setUpTab(array);
        this.setUpName(text);
    }
    
    private void loadUpStats (int x, int y, int length, int width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }
    
    private void setUpTab(boolean array) {
        this.outline = new Obdlznik();
        this.inside = new Obdlznik();
        
        this.outline.zmenStrany(this.length, this.width);
        this.inside.zmenStrany(this.length - 2, this.width - 2);
        
        this.outline.posunVodorovne(this.x);
        this.inside.posunVodorovne(this.x + 1);
        
        this.outline.posunZvisle(this.y);
        this.inside.posunZvisle(this.y + 1);
        
        this.outline.zmenFarbu("blue");
        this.inside.zmenFarbu("black");
        
        if (array) {
            this.outline.zobraz();
            this.inside.zobraz();
        }
        
    }
    
    private void setUpName(String text) {
        this.name = new SegmentChar[text.length()];
    
        for (int i = 0; i < text.length(); i++) {
            this.name[i] = new SegmentChar(this.x + i * 25 + 5, this.y + 15, 10, 2);
            
            if ((text.charAt(i) >= '0') && (text.charAt(i) <= '9')) {
                this.name[i].litNum((int)text.charAt(i) - 48, "red");   // ASCIITABLE NUMBER - ASCIITABLE for '0' returns exact number
            } else {
                this.name[i].litChar(text.charAt(i), "blue");
            }
            
        }
    }
    
    /**
     * V pripade pouzivania formou spinacu, zapne a vypne vypln
     */
    public void toggle(boolean on) {
        if (on) {
            this.outline.zobraz();
            this.inside.zobraz();
        } else {
            this.outline.skry();
            this.inside.skry();
        }
        
    }
    
    /**
     * Ukryva okno aplikacie spolu s jeho textom
     */
    public void hide() {
        this.outline.skry();
        this.inside.skry();
        for (int i = 0; i < this.name.length; i++) {
            this.name[i].unlit();
        }
    }
    
    /**
     * Vracia udaj o polohe na xovej osi
     */
    public int getTabX() {
        return this.x;
    }
    
    /**
     * Vracia udaj o polohe na yovej osi
     */
    public int getTabY() {
        return this.y;
    }
    
    /**
     * Vracia dlzku okna
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Vracia sirku okna 
     */
    public int getWidth() {
        return this.width;
    }
}
