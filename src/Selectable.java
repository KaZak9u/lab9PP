import java.awt.*;

public interface Selectable {

    public void draw(Graphics g);

    public boolean pointIntersects(Point point);

    public void drawBoundingBox(Graphics g);
}
