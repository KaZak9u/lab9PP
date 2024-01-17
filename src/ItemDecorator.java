import java.awt.*;

public class ItemDecorator implements Selectable{
    private Selectable wrapee;

    public ItemDecorator(Selectable item) {
        wrapee = item;
    }
    public void draw(Graphics g) {
        wrapee.draw(g);
        wrapee.drawBoundingBox(g);
    }

    @Override
    public boolean pointIntersects(Point point) {
        return wrapee.pointIntersects(point);
    }

    @Override
    public void drawBoundingBox(Graphics g) {
        wrapee.drawBoundingBox(g);
    }

    public Selectable getWrapee() {
        return wrapee;
    }
}
