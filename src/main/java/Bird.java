import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird implements Updatable, Renderable{

    private float x, y;
    private float yVel;
    private float baseYVel = -6.0f;
    private float gravity = 0.25f;

    private Pipes pipes;
    private int scoredPipe = 0;
    private int score = 0;
    private Font gameFont = new Font("Arial", Font.BOLD, 30);

    private BufferedImage flapUp;
    private BufferedImage flapDown;

    public Bird(Pipes pipes) {
        resetBird();

        this.pipes = pipes;
    }

    public void resetBird(){
        x = 100;
        y = 200;
        yVel = baseYVel;
    }

    public void flap(){
        yVel = baseYVel;
    }

    @Override
    public void render(Graphics2D g, float interpolation) {

    }

    @Override
    public void update(Input input) {

    }
}
