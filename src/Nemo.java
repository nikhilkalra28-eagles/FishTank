import java.awt.*;

public class Nemo {
    String name;
    Image aliveImage;
    Image deadImage;
    int xpos;
    int ypos;
    int speed;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;
    boolean isAlive = true;

    public Nemo(){
        hitbox = new Rectangle(xpos,ypos, width,height);
        // convention for making a rectangle
    }
// nemo characteristics
    public Nemo(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput){
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos,ypos, width,height);
        // Overload constructor = more than 1 constructor. must give inputs
        //

    }
    public void move(){ //exam
// nemo wraps and bounces
        xpos = xpos + (int)dx;
        ypos = ypos + (int)dy;
        if (xpos == 1000) {
            dx = -dx;
            xpos = 0;
        }
        if (xpos == 0) {
            dx = -dx;
            xpos = 0;
        }
        if (ypos == 700){
            dy = -dy;
            ypos = 0;

        }
        if (ypos == 0){
            dy = -dy;
            ypos = 0;
        }
        hitbox = new Rectangle(xpos,ypos, width,height);
    }
}


    /*
        public void move(char key) {
            if (key == 'w') { // move forward
                ypos = ypos + speed;
            }
            if (key == 's') { // move backwards
                ypos = ypos - speed;
            }
            if (key == 'a') { // move left
                xpos = xpos - speed;
            }
            if (key == 'd') { // move right
                xpos = xpos + speed;
            }
    /*
    public static void main(String[] args) {
     */
