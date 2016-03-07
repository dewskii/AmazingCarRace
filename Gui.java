//Fred Dolan

//its a gui
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame{

    private Race race;
    public static int XS;
    public static int YS;

    public Gui() {
        //resolution
        XS = 800;
        YS = 600;
        //creating the race object
        //int xSize, int ySize, int minSpeed, int maxSpeed, int nStops, int nCars, int nDinos
        race = new Race(XS,YS,2,8,5,7,2);
        setSize(XS, YS);
        setVisible(true);
        int ind = 0;
        while(!race.getOver()){
            race.go();
            try {
                //the tick rate
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Everything's broken cry");
            }
            repaint();
            ind++;
            //System.out.println(ind);
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0,0,XS,YS);
        g.setColor(Color.BLACK);
        race.draw(g);
    }

    public static void main(String argv[]) {
        Gui c = new Gui();
    }
}
