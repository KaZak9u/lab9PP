import java.awt.*;

public class Rect extends Shape{
    private int width;
    private int height;
    public Rect(Point position, boolean filled, int width, int height) {
        super(position,filled);
        this.height = height;
        this.width = width;
        setBoundingBox(new Point[]{position, new Point(position.getX() + width, position.getY()),
                new Point(position.getX() , position.getY() + height),
                new Point(position.getX() + width, position.getY() + height)});
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(itemColor);
        if(filled) {
            g.fillRect(position.getX(), position.getY(), width, height);
        } else {
            g.drawRect(position.getX(), position.getY(), width, height);
        }
    }

    @Override
    public Item translate(Point p) {
        position.translate(p);
        return new Rect(position,filled,width,height);
    }
}
