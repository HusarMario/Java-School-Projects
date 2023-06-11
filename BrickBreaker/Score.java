import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

/**
 * Herne skore ziskavane pocas hrania hry
 * Kazda dalsia tehlicka ktoru lopticka znici od momentu odrazenia od odrazadla po dalsie odrazenie od odrazadla navysuje pocet bodov za tehlicku o 1
 * Skore je priratane len ak lopticka nepadne ale uspesne sa znova odrazi
 * V pripade straty lopticky je skore priratane formou bonusu za kazdy cely uspesny zniceny rad ktory sa nasledne znova zregneruje pri novom zivote
 */
public class Score {
    private ScoreDisplay display;
    private int score;
    private int additon;
    private int streak;
    private boolean doubleUp;
    
    /**
     * Vytvori skore
     */
    public Score(int x, int y) {
        this.setUpScore(x, y);
    }
    
    private void setUpScore(int x, int y) {
        this.score = 0;
        this.reset();
        this.display = new ScoreDisplay(x, y);
    }
       
    /**
     * Vracia udaj o aktivovani schopnosti o zdvojnasobeni skore po odraze
     */
    public void doubleUp() {
        this.doubleUp = true;
    }
    
    /**
     * Pridava body po bode
     */
    public void additon() { // Adds 1 point per brick .. Increase the value per brick for each next brick
        this.additon += this.streak;
        this.streak++;
    }
    
    /**
     * Ulozi body do finalneho skore
     */
    public void addScore() {    //Resets streaks and add all score the player (Can be lost if u lose ball)
        if (this.doubleUp) {
            this.additon *= 2;
        }
        this.score += this.additon;
        this.updateDisplay();
    }
    
    /**
     * Prida urcite vlozene skore
     */
    public void addScore(int value) {  // Add score imidatelly
        this.score += value;
        this.updateDisplay();
    }
    
    /**
     * Restartuje pridel skore ( nie jeho celkove skore)
     */
    public void reset() {
        this.doubleUp = false;
        this.additon = 0;
        this.streak = 1;
    }
    
    private void updateDisplay() {  //Updates display .. for fastest runtime will change only numbers that are needed to changed without refreshing whole display
        int divider = 100000;
        int number = 0;
        int value = this.score;
        
        for (int i = 0; i < 6; i++) {
            number = value / divider;
            if (number != this.display.getNumber(i)) {
                this.display.changeSegement(i, number);
            }
            value %= divider;
            divider /= 10;
        }        
    }
    
    /**
     * Zistuje najvyssie dosiahnute skore, v pripade ze toto skore bolo prekonane uchova skore a nahradi starsie uchovane skore a zaroven zoradi prve 3 miesta podla skore
     * Zaroven je toto jedine miesto kde sa meni dokument so skore a v pripade ze nim nebolo nijak zasahovane mimo fungovania aplikace vzdy bude spravne zapisane
     */
    public void rewriteScore() throws IOException {  //In the end of the game check leadareborads and rewrites if achieved higher score
        File file = new File("Highscore.txt");
        Scanner scanner = new Scanner(file);
        String[] names = new String[3];
        int[] values = new int[3];
        
        for (int i = 0; i < 3; i++) {   //Loads 3 best players
            names[i] = scanner.nextLine();
            String scoreInString = scanner.nextLine();
            values[i] = 0;
            int numeric = 100000;
            for (int j = 0; j < 6; j++) {
                values[i] += (((int)scoreInString.charAt(j) - 48) * numeric);
                numeric /= 10;
            }
        }
        scanner.close();
        
        if (this.score > values[2]) {   // If score was beaten save this score
            String text = JOptionPane.showInputDialog(null, "Insert your name (5 characters needed!): "); //Limit 5 characters for later proper showing on leaderboards
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 5; i++) { 
                name.append(text.charAt(i));
            }
            String finalName = name.toString();
            finalName.toLowerCase();
            
            names[2] = finalName;
            values[2] = this.score;
            
            if (this.score > values[1]) {   //If score was better than 2nd place
                String storeName = names[1];
                int storeValue = values[1];
                    
                names[1] = names[2];
                values[1] = values[2];
                    
                names[2] = storeName;
                values[2] = storeValue;
                
                if (this.score > values[0]) {   //If score was better than 3rd place
                    storeName = names[0];
                    storeValue = values[0];
                    
                    names[0] = names[1];
                    values[0] = values[1];
                    
                    names[1] = storeName;
                    values[1] = storeValue;
                }
            }
            
            PrintWriter writer = new PrintWriter(file); //Saving all scores back into the file 
            for (int i = 0; i < 3; i++) {
                writer.write(names[i] + "\n");
                StringBuilder value = new StringBuilder();
                int numeric = 100000;
                for (int j = 0; j < 6; j++) {
                    value.append(values[i] / numeric);
                    values[i] %= numeric;
                    numeric /= 10;
                    
                }
                writer.write(value + "\n");
            }
            
            writer.close();
        } 
    }
}
