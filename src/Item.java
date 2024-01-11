import java.awt.*;

public abstract class Item {
    protected Point position;
    protected Point [] boundingBox;
    protected Color itemColor = new Color(0, 0, 0);

    public Item(Point position) {
        this.position = position;
    }
    protected void setBoundingBox(Point [] points){
        boundingBox = new Point[4];
        boundingBox[0] = Point.getTopLeft(points);
        boundingBox[1] = Point.getBotLeft(points);
        boundingBox[2] = Point.getBotRight(points);
        boundingBox[3] = Point.getTopRight(points);
    }
    public abstract void draw(Graphics g, boolean drawBBox);
    protected void drawBoundingBox(Graphics g) {
        g.setColor(new Color(255,0,0));
        //g.drawRect(position.getX(), position.getY(), Math.abs(boundingBox[3].getX() - position.getX()), Math.abs(boundingBox[1].getY() - position.getY()));
        g.drawPolygon(new int[]{boundingBox[0].getX(), boundingBox[1].getX(), boundingBox[2].getX(), boundingBox[3].getX()},
                new int[]{boundingBox[0].getY(), boundingBox[1].getY(), boundingBox[2].getY(), boundingBox[3].getY()}, 4);
    }
    public Point getPosition() {return position;}

    public Point [] getBoundingBox(){return boundingBox;}

    public abstract Item translate(Point p);

}
