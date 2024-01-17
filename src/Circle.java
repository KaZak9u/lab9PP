import java.awt.*;

public class Circle extends Shape{
    protected int radius;
    public Circle(Point position, boolean filled, int radius) {
        super(position,filled);
        this.radius = radius;
        Point p1 = new Point(position.getX() + 2 * radius, position.getY() + 2 * radius);
        setBoundingBox(new Point[]{position,p1});
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(itemColor);
        if(filled) {
            g.fillOval(position.getX(), position.getY(), 2 * radius, 2 * radius);
        } else {
            g.drawOval(position.getX(), position.getY(), 2 * radius, 2* radius);
        }
    }
    @Override
    public Item translate(Point p) {
        position.translate(p);
        return new Circle(position, filled, radius);
    }
}
