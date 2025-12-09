import java.awt.*;

public class Dory {
    String name;
    Image image;
    int xpos;
    int ypos;
    int speed;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;

    public Dory(){
        hitbox = new Rectangle(xpos,ypos, width,height);
        // convention for making a rectangle
    }
// Dory characteristics
    public Dory(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput){
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
// dory bounces
        xpos = xpos + (int)dx;
        ypos = ypos + (int)dy;
        if (xpos == 700) {
            dx = -dx;
            //xpos = 0;
        }
        if (xpos == 0) {
            dx = -dx;
            //xpos = 0;
        }
        if (ypos == 500){
            dy = -dy;
            //pos = 0;


        }
        if (ypos == 0){
            dy = -dy;
            //ypos = 0;


        }
        hitbox = new Rectangle(xpos,ypos, width,height);
    }
}



