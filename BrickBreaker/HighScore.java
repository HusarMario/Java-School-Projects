import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Zobrazuje najlepsie skore hracov hry
 */
public class HighScore {
    private Tab title;
    private Tab[] names;
    private Tab[] scores;
    private Tab back;
    
    private File file;
    private Scanner scanner;
    
    /**
     * Vytvori miesto na zobrazenie najlepsieho skore
     */
    public HighScore() throws IOException {
        this.setUpFile();
        this.setUpHighScore();
    }
    
    private void setUpFile() throws IOException {
        this.file = new File("Highscore.txt");
        this.scanner = new Scanner(this.file);
    }
    
    private void setUpHighScore() {
        this.title = new Tab(130, 40, "highscore", 300, 50, false);
        this.names = new Tab[3];
        this.scores = new Tab[3];
        
        for (int i = 0; i < 3; i++) {
            this.names[i] = new Tab(40, 150 + (i * 100), (i + 1 + " " + this.scanner.nextLine()), 200, 50, true);
            this.scores[i] = new Tab(260, 150 + (i * 100), (" " + this.scanner.nextLine()), 200, 50, true);
        }
        
        this.back = new Tab(150, 440, " return", 200, 50, true);
    }
    
    /**
     * Zabezpecuje vykonavanie prikazov jednotlivych okien
     */
    public boolean press(int x, int y, GamePhase phase) {
        if ((x > this.back.getTabX() && x < this.back.getTabX() + this.back.getLength()) && ((y > this.back.getTabY() && y < this.back.getTabY() + this.back.getWidth()))) {
            phase.setPhase(GamePhaseType.MENU);
            return true;
        }
        
        return false;
    }
}