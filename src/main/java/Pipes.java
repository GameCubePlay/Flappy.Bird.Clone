import java.awt.*;
import java.util.Random;

public class Pipes implements Updatable, Renderable{

    private int pipeWidth = 100;
    private int pipeHorizontalSpacing = 210;
    private int pipeVerticalSpacing = 180;

    private float xVel = -5.0f;
    private float x1, x2, x3;
    private float y1, y2, y3;

    private int currentPipe;
    private float[][] pipeCoords = new float[3][2];

    private Random rand;

    public Pipes(){
        rand = new Random();
        resetPipes();
    }

    public void resetPipes(){
        //TODO
    }


    @Override
    public void render(Graphics2D g, float interpolation) {

    }

    @Override
    public void update(Input input) {

    }
}
