import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();
        Item seg = new Segment(new Point(500, 500), new Point(1000, 800));
        Item triangle = new Triangle(false, new Point(100, 150), new Point(200, 800), new Point(800, 100));
        Item circle = new Circle(new Point(50, 50), true, 100);
        Item txt = new TextItem(new Point(510, 520), "XDDDDdsad", new Font(Font.SANS_SERIF, Font.BOLD, 50));
        Item regPol = new RegularPolygon(new Point(300, 300), false, 4, 150);
        Item triangle2 = new Triangle(false, new Point(300,400), new Point(400,400), new Point(300,500));
        //circle = circle.translate(new Point(200,200));
        ArrayList<Item> lst = new ArrayList<>();
        lst.add(seg);
        //lst.add(triangle);
        Item complexIt = new ComplexItem(lst);
        //complexIt = complexIt.translate(new Point(100,100));
        scene.addItem(triangle);
        scene.addItem(triangle2);
        scene.addItem(triangle);
        scene.addItem(complexIt);
        scene.addItem(regPol);
        scene.addItem(circle);
        scene.addItem(txt);
        //rysowanie sceny
        JFrame frame = new JFrame("Scene Viewer");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                scene.drawScene(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

}