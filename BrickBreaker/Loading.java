/**
 * Uvodna strana aplikacie
 */
public class Loading {
    private Tab title;
    private Tab text;
    private Tab creator;
    
    /**
     * Vytvori uvodnu stranu
     */
    public Loading() {
        this.setUpLoading();  
    }
    
    private void setUpLoading() {
        this.title = new Tab(100, 40, "brickbreaker", 300, 50, false);
        this.text = new Tab(5, 250, "press enter or space", 500, 50, false);
        this.creator = new Tab(5, 450, "by       mario husar", 500, 50, false);
    }
}
