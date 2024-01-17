import java.awt.*;

public class Triangle extends Shape{
    Point p1;
    Point p2;
    Point p3;

    public Triangle(boolean filled, Point p1, Point p2, Point p3) {
        super(Point.getTopLeft(new Point[]{p1,p2,p3}), filled);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        setBoundingBox(new Point[]{p1,p2,p3});
    }

    @Override
    public void draw(Graphics g) {
        int [] xTab = {p1.getX(), p2.getX(), p3.getX()};
        int [] yTab = {p1.getY(), p2.getY(), p3.getY()};
        g.setColor(itemColor);
        if(filled) {
            g.fillPolygon(xTab,yTab,3);
        } else {
            g.drawPolygon(xTab,yTab,3);
        }
    }

    @Override
    public Item translate(Point p) {
        p1.translate(p);
        p2.translate(p);
        p3.translate(p);
        return new Triangle(filled,p1,p2,p3);
    }
}
