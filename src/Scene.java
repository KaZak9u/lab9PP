import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Scene  {
    private ArrayList<Selectable> itemList;
    public Scene(){
        itemList = new ArrayList<>();
    }
    public void addItem(Item item) {
        itemList.add(item);
    }
    public void drawScene(Graphics g) {
        for(Selectable item:itemList) {
            item.draw(g);
        }
    }
    public void selectItems(Point point) {
        for(int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).pointIntersects(point)) {
                itemList.set(i, new ItemDecorator(itemList.get(i)));
            }
        }
    }
    public void clearSelection() {
        for(int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i) instanceof ItemDecorator) {
                itemList.set(i, ((ItemDecorator) itemList.get(i)).getWrapee());
            }
        }
    }

}
