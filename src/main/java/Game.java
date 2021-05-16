import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game {
    public final static int WIDTH = 800, HEIGHT = 600;

    private String gameName = "Flappy Bird";
    private Input input;
    private ArrayList<Updatable> updatables = new ArrayList<>();
    private ArrayList<Renderable> renderables = new ArrayList<>();

    public void addUpdatable(Updatable u){
        updatables.add(u);
    }

    public void removeUpdatable(Updatable u){
        updatables.remove(u);
    }

    public void addRenderable(Renderable r){
        renderables.add(r);
    }

    public void removeRenderable(Renderable r){
        renderables.remove(r);
    }

    private Canvas game = new Canvas();
    public void Start(){
        Dimension gameSize = new Dimension(Game.WIDTH, Game.HEIGHT);
        JFrame gameWindow = new JFrame(gameName);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        gameWindow.setResizable(false);

        gameWindow.setVisible(true);
        game.setSize(gameSize);
        game.setMinimumSize(gameSize);
        game.setMaximumSize(gameSize);
        game.setPreferredSize(gameSize);

        gameWindow.add(game);
        gameWindow.setLocationRelativeTo(null);

        input = new Input();

        final int TICK_PER_SECOND = 60;
        final int TIME_PER_TICK = 1000 / TICK_PER_SECOND;
        final int MAX_FRAMESKIPS = 5;

        long nextGameTick = System.currentTimeMillis();
        int loops;
        float interpolation;

        long timeAtLastFPSCheck = 0;
        int ticks = 0;


        boolean running = true;
        while (running){
            // Updating

            // Rendering

            // FPS Check
        }
    }

    private void update(){
        for(Updatable u : updatables){
            u.update(input);
        }
    }

    private void render(float interpolation){
        BufferStrategy b = game.getBufferStrategy();
        if(b == null){
            game.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) b.getDrawGraphics();
        g.clearRect(0,0,game.getWidth(), game.getWidth());

        for(Renderable r : renderables){
            r.render(g, interpolation);
        }
        g.dispose();
        b.show();
    }

    public static void main(String[] args){
        Game g = new Game();
        g.renderables.add(new Renderable() {
            @Override
            public void render(Graphics2D g, float interpolation) {
                g.setColor(Color.RED);
                g.drawRect(300, 250, 50, 100);
            }
        });

        g.Start();
    }

}
