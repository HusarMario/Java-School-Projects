/**
 * Graficky displej zobrazovania aktualneho skore
 */
public class ScoreDisplay {
    private SegmentChar[] display;
    private int[] numbers;
    
    /**
     * Vytvori displej skore
     */
    public ScoreDisplay(int x, int y) {
        this.setUpScoreDisplay(x, y);
    }
    
    private void setUpScoreDisplay(int x, int y) {
        this.display = new SegmentChar[6];
        this.numbers = new int[6];
        
        for (int i = 0; i < 6; i++) {
            this.display[i] = new SegmentChar(x + i * 25, y, 10, 5);
            this.display[i].litNum(0, "red");
            this.numbers[i] = 0;
        }
    }
    
    /**
     * Meni jednotlive cisla na displeji
     */
    public void changeSegement(int index, int number) {
        this.display[index].litNum(number, "red");
        this.numbers[index] = number;
    }
    
    /**
     * Vrati uchovane cislo na konkretnom mieste v displeji
     */
    public int getNumber(int index) {
        return this.numbers[index];
    }
}