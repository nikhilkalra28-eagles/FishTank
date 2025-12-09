import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class BasicGameApp implements Runnable {

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Variable Definition Section
    Nemo nemo;
    Dory dory;
    Shark shark;
    Image background;

    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
        setUpGraphics();

        //variable and objects
        nemo = new Nemo(500, 350, 1.7, 1.4, 100, 100);
        nemo.name = "Nemo Nemo";
        dory = new Dory(350, 275, 2, 1.5, 100, 100);
        shark = new Shark(800, 325, 1.5,1.5 , 150, 150);
        // pictures of characters
        nemo.aliveImage = Toolkit.getDefaultToolkit().getImage("nemo.png");
        nemo.deadImage = Toolkit.getDefaultToolkit().getImage("together.jpg"); // image of Nemo and Dory together when they hit
        dory.image = Toolkit.getDefaultToolkit().getImage("dory.jpg");

        shark.image = Toolkit.getDefaultToolkit().getImage("shark.jpg"); // shark image
        background = Toolkit.getDefaultToolkit().getImage("fishtankk.jpg");
    }
    // end BasicGameApp constructor

    public void moveThings() {
        nemo.move();
        dory.move();
        shark.move();
    }

    public void checkCollision() {
        //System.out.print(nemo.hitbox);
        //System.out.print(dory.hitbox);
        if (nemo.hitbox.intersects(dory.hitbox)) { // text displays when Nemo and Dory hit
            nemo.isAlive = false;
            System.out.print("We are a Dynamic Dou!");

            if (nemo.dx < 0 && dory.dx > 0) {
                nemo.dx = -nemo.dx;
                dory.dx = -dory.dx;

            } else if (nemo.dx > 0 && nemo.dx < 0) {
                nemo.dx = -nemo.dx;
                dory.dx = -dory.dx;

                if (nemo.dy < 0 && nemo.dy > 0) {
                    nemo.dy = -nemo.dy;
                    dory.dy = -dory.dy;

                } else if (nemo.dy > 0 && dory.dy < 0) {
                    nemo.dy = -nemo.dy;
                    dory.dy = -dory.dy;
                }
            }
        } else {
            nemo.isAlive = true;
        }
        if (shark.hitbox.intersects(nemo.hitbox)) { // shark bounces off nemo dx
            if (shark.dx < 0 && nemo.dx > 0) {
                shark.dx = -shark.dx;
                nemo.dx = -nemo.dx;
            } else if (shark.dx > 0 && nemo.dx < 0) {
                shark.dx = -shark.dx;
                nemo.dx = -nemo.dx;
                if (shark.dy < 0 && nemo.dy > 0) { // shark bounces off nemo dyy
                    shark.dy = -shark.dy;
                    nemo.dy = -nemo.dy;
                } else if (shark.dy > 0 && nemo.dy < 0) {
                    shark.dy = -shark.dy;
                    nemo.dy = -nemo.dy;
                }
            }
        }
        if (shark.hitbox.intersects(dory.hitbox)) { // shark bounces of dory
            if (shark.dx < 0 && dory.dx > 0) {
                shark.dx = -shark.dx;
                dory.dx = -dory.dx;
            } else if (shark.dx > 0 && dory.dx < 0) {
                shark.dx = -shark.dx;
                dory.dx = -dory.dx;
                if (shark.dy < 0 && dory.dy > 0) {
                    shark.dy = -shark.dy;
                    dory.dy = -dory.dy;
                } else if (shark.dy > 0 && dory.dy < 0) {
                    shark.dy = -shark.dy;
                    dory.dy = -dory.dy;
                }
            }
        }
    }


    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
// draws nemo
        if (nemo.isAlive) {
            g.drawImage(nemo.aliveImage, nemo.xpos, nemo.ypos, nemo.width, nemo.height, null);
        } else {
            g.drawImage(nemo.deadImage, nemo.xpos, nemo.ypos, nemo.width, nemo.height, null);
        }
// draws dory and shark
        g.drawImage(dory.image, dory.xpos, dory.ypos, dory.width, dory.height, null);
        g.drawImage(shark.image, shark.xpos, shark.ypos, shark.width, shark.height, null);

        g.dispose();
        bufferStrategy.show();
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();
        new Thread(ex).start();
    }

    public void run() {
        while (true) {
            moveThings();
            checkCollision();
            render();
            pause(10);
        }
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename) {
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");

        panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}
