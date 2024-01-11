import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ComplexItem extends Item{
    private ArrayList<Item> children;
    public ComplexItem( ArrayList<Item> children) {
        super(new Point(0,0));
        this.children = children;
        setComplexBoundingBox();
        position = boundingBox[0];
    }
    private void setComplexBoundingBox() {
        boundingBox = new Point[4];
        Point [] topLeftArray = getCornerChildrenArray(0);
        Point [] botLeftArray = getCornerChildrenArray(1);
        Point [] botRightArray = getCornerChildrenArray(2);
        Point [] topRightArray = getCornerChildrenArray(3);
        boundingBox[0] = Point.getTopLeft(topLeftArray);
        boundingBox[1] = Point.getBotLeft(botLeftArray);
        boundingBox[2] = Point.getBotRight(botRightArray);
        boundingBox[3] = Point.getTopRight(topRightArray);
    }
    private Point [] getCornerChildrenArray(int index) {
        Point [] tab = new Point[children.size()];
        for(int i = 0; i < children.size(); i++){
            tab[i] = children.get(i).boundingBox[index];
        }
        return tab;
    }
    public ArrayList<Item> getChildren() {
        return children;
    }

    @Override
    public void draw(Graphics g, boolean drawBBox) {
        for (Item child : children) {
            child.draw(g, false);
        }
        if(drawBBox) drawBoundingBox(g);
    }

    @Override
    public Item translate(Point p) {
        children.replaceAll(item -> item.translate(p));
        return new ComplexItem(children);
    }

}
