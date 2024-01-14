import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scene  {
    private List<Item> itemList;
    public Scene(){
        itemList = new ArrayList<>();
    }
    public void addItem(Item item) {
        if (item instanceof Singleton singleton) {
            singleton.removeFromScene(this);
        }
        itemList.add(item);
    }
    public void removeSingleton(Class<? extends Singleton> singletonClass) {
        List<Item> itemsToRemove = itemList.stream()
                .filter(singletonClass::isInstance)
                .toList();
        itemList.removeAll(itemsToRemove);
    }
    public void drawScene(Graphics g) {
        for(Item item:itemList) {
            item.draw(g,true);
        }
    }

}
