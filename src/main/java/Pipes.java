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
        currentPipe = 0;
        x1 = Game.WIDTH * 2;
        x2 = x1 + pipeWidth + pipeHorizontalSpacing;
        x3 = x2 + pipeWidth + pipeHorizontalSpacing;

        y1 = getRandomY();
        y2 = getRandomY();
        y3 = getRandomY();
    }

    private int getRandomY(){
        return rand.nextInt((int)(Game.HEIGHT * 0.4f)) + (Game.HEIGHT / 10);

    }


    @Override
    public void update(Input input) {
        x1 += xVel;
        x2 += xVel;
        x3 += xVel;

        if(x1 + pipeWidth < 0){
            x1 = Game.WIDTH;
            y1 = getRandomY();
            currentPipe = 1;
        }
        if(x2 + pipeWidth < 0){
            x2 = Game.WIDTH;
            y2 = getRandomY();
            currentPipe = 2;
        }

        if(x3 + pipeWidth < 0){
            x3 = Game.WIDTH;
            y3 = getRandomY();
            currentPipe = 0;
        }

        switch (currentPipe){
            case 0:
                pipeCoords[0][0] = x1;
                pipeCoords[0][1] = y1;
                break;
            case 1:
                pipeCoords[1][0] = x2;
                pipeCoords[1][1] = y2;
                break;
            case 2:
                pipeCoords[2][0] = x3;
                pipeCoords[2][1] = y3;
                break;
        }
    }

    @Override
    public void render(Graphics2D g, float interpolation) {}
        public float[] getCurrentPipe(){
            return pipeCoords[currentPipe];
        }

        public int getCurrentPipeID() {
            return currentPipe;
        }

        public int getPipeWidth() {
            return pipeWidth;
        }

        public int getPipeHorizontalSpacing(){
            return pipeHorizontalSpacing;
        }

        public int getPipeVerticalSpacing() {
            return pipeVerticalSpacing;
        }
}
