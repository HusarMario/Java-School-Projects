import java.io.IOException;

/**
 * Spravuje hru BrickBreaker
 */
public class BrickBreaker {
    private GamePhase phase;    
    private PlayGround playGround;
    private Configuration configuration;

    private Loading loading;
    private Menu menu;
    private Settings settings;
    private HighScore highscore;
    private Manazer manager;

    private Paddle paddle;
    private Ball ball;
    private Wall wall;

    private PowerUp powerUp;
    private Lives lives;
    private Score score;

    /**
     * Vytvori hru BrickBreaker
     */
    public BrickBreaker() {
        this.playGround = new PlayGround(500, 500);
        this.phase = new GamePhase(GamePhaseType.MENU);
        this.configuration = new Configuration();
        this.manage();
        this.loadLoading();
    }

    /**
     * Pohybuje doskou dolava stlacenim klavesy LEFT
     */
    public void posunVlavo () {
        if (this.phase.getPhase() == GamePhaseType.GAME) {
            this.paddle.posunVlavo();
        }
    }

    /**
     * Pohybuje doskou doprava stlacenim klavesy RIGHT
     */
    public void posunVpravo () {
        if (this.phase.getPhase() == GamePhaseType.GAME) {
            this.paddle.posunVpravo();
        }
    }

    /**
     * Vykonava vyber prikazov v ovladani MENU kliknutim mysi
     */
    public void vyberSuradnice(int x, int y) throws IOException {
        switch (this.phase.getPhase()) {
            case MENU: {
                if (this.menu.press(x, y, this.phase)) {
                    this.playGround.reset();
                    
                    switch (this.phase.getPhase()) {
                        case GAME: {
                            this.loadObjects();
                            this.loadStats();
                            break;
                        }
                        case SETTINGS: {
                            this.loadSettings();
                            break;
                        }
                        case HIGHSCORE: {
                            this.loadHighScore();
                            break;
                        }
                        case EXIT: {
                            System.exit(0);
                            break;
                        }
                    }
                }
                break;
            }
            case SETTINGS: {
                if (this.settings.press(x, y, this.phase, this.configuration)) {
                    if (this.phase.getPhase() == GamePhaseType.MENU) {
                        this.playGround.reset();
                        this.loadMenu();
                    }
                }
                break;
            }
            case HIGHSCORE: {
                if (this.highscore.press(x, y, this.phase)) {
                    this.playGround.reset();
                    this.loadMenu();
                }
                break;
            }
        }
    }

    /**
     * Vracia sa do MENU stlacenim klavesu ESC
     */
    public void zrus() {
        if (this.phase.getPhase() != GamePhaseType.MENU) {
            this.phase.setPhase(GamePhaseType.MENU);
            this.playGround.reset();
            this.loadMenu();
        }
    }

    /**
     * Vstupuje do hry po zobrazeni uvodnej ukazky stlacenim klavesu SPACE alebo ENTER
     */
    public void aktivuj() {
        if (this.phase.getPhase() == GamePhaseType.MENU) {
            this.playGround.reset();
            this.loadMenu(); 
        }
    }

    /**
     * Ovlada samostatnu hru po jej zapnuti a riesi vsetky kolizie a kontroly konca hry
     */
    public void tik() throws IOException {
        if (this.phase.getPhase() == GamePhaseType.GAME) {
            this.ball.move();

            if (this.playGround.hit(this.ball)) {
                if (this.configuration.isSidesGenerate()) {
                    this.wall.generate(true);
                }
            }

            if (this.playGround.miss(this.ball)) {
                this.lives.removeLife();
                this.paddle.deattach();
                this.score.reset();
                this.powerUp.deattach();
                this.wall.getBonus(this.score);
                this.ball = new Ball(250, 300);
            }

            if (this.paddle.hit(this.ball)) { 
                this.wall.generate();
                this.score.addScore();
                this.score.reset();
                this.ball.reset();
                if (this.powerUp != null) {
                    this.powerUp.activate(this.lives, this.score, this.ball);
                    this.paddle.deattach();
                    this.powerUp.deattach();
                }
            }

            if (this.wall.hit(this.ball, this.score, this.powerUp)) {
                if (this.powerUp.getPowerUp() != null) {
                    this.paddle.attach(this.powerUp.getPowerUp());
                }
            }

            if (this.lives.getLives() == 0) {
                this.score.rewriteScore();
                this.zrus();
            }
        }
    }

    private void loadObjects() {
        this.paddle = new Paddle(250, 490, this.configuration.isBigSize());
        this.ball = new Ball(250, 350);
        this.wall = new Wall(10, 150);
    }

    private void loadStats() {
        if (this.configuration.isBonusLives()) {
            this.lives = new Lives(10, 40, 5);
        } else {
            this.lives = new Lives(10, 40, 3);
        }
        this.score = new Score(350, 35);
        this.powerUp = new PowerUp();
    }

    private void loadSettings() {
        this.settings = new Settings(this.configuration);
    }

    private void loadHighScore() throws IOException {
        this.highscore = new HighScore();
    }

    private void loadMenu() {
        this.menu = new Menu();
    }

    private void loadLoading() {
        this.loading = new Loading();
    }

    private void manage() {
        this.manager = new Manazer();
        this.manager.spravujObjekt(this);
    }
}
