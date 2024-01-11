import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Scene  {
    private ArrayList<Item> itemList;
    public Scene(){
        itemList = new ArrayList<>();
    }
    public void addItem(Item item) {
        itemList.add(item);
    }
    public void drawScene(Graphics g) {
        for(Item item:itemList) {
            item.draw(g,true);
        }
    }

}
