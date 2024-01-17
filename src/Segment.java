import java.awt.*;

public class Segment extends Primitive{
    private Point start;
    private Point end;
    public Segment(Point start, Point end) {
        super(Point.getTopLeft(new Point[]{start, end}));
        this.start = start;
        this.end = end;
        setBoundingBox(new Point[] {start,end});
    }
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
    public double getLength() {
        return Math.sqrt(Math.pow(end.getX()-start.getX(),2) + Math.pow(end.getY()-start.getY(),2));
    }
    public void draw(Graphics g){
        g.setColor(itemColor);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    @Override
    public Item translate(Point p) {
        position.translate(p);
        start.translate(p);
        end.translate(p);
        return new Segment(start,end);
    }
}
