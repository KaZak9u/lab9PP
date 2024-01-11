import java.awt.*;

public class RegularPolygon extends Circle{
    private Point center;
    private int sides;
    private Point [] points;
    private int [] xOfPoints;
    private int [] yofPoints;
    private double angle;
    public RegularPolygon(Point position, boolean filled, int sides, int radius) {
        super(position, filled, radius);
        center = new Point(position.getX() + radius, position.getY() + radius);
        this.sides = sides;
        angle = 2 * Math.PI / sides;
        setPoints();
        setxOfPoints();
        setYofPoints();
        setBoundingBox(points);
    }
    private void setPoints(){
        points = new Point[sides];
        for(int i = 0; i < sides; i++) {
            points[i] = new Point((int)( center.getX() + Math.round(radius * Math.cos(i * angle))),  (int)( center.getY() + Math.round(radius * Math.sin(i * angle))));
        }
    }
    private void setxOfPoints(){
        xOfPoints = new int[sides];
        for(int i = 0; i < sides; i++){
            xOfPoints[i] = points[i].getX();
        }
    }
    private void setYofPoints(){
        yofPoints = new int[sides];
        for(int i = 0; i < sides; i++){
            yofPoints[i] = points[i].getY();
        }
    }
    @Override
    public void draw(Graphics g, boolean drawBBox) {
        g.setColor(itemColor);
        if(filled) g.fillPolygon(xOfPoints,yofPoints,sides);
        else g.drawPolygon(xOfPoints,yofPoints,sides);
        if(drawBBox) drawBoundingBox(g);
    }
    @Override
    public Item translate(Point p) {
        position.translate(p);
        return new RegularPolygon(position,filled,sides,radius);
    }
}
