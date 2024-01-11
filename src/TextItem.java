import java.awt.*;
import java.awt.image.BufferedImage;

public class TextItem extends Item{
    private String text;
    private Font font;
    public TextItem(Point position, String text, Font font){
        super(position);
        this.text = text;
        this.font = font;
        setBoundingBox();
    }
    private void setBoundingBox() {
        boundingBox = new Point[4];
        Graphics g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).createGraphics();
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int highY = position.getY() - fontMetrics.getHeight() / 2 - (font.getSize() / 20) * 2;
        int height = fontMetrics.getHeight() / 2 + (font.getSize() / 20) * 7;
        int width = fontMetrics.stringWidth(text);
        boundingBox[0] = new Point(position.getX(), highY);
        boundingBox[1] = new Point(position.getX(), highY + height);
        boundingBox[2] = new Point(position.getX() + width, highY + height);
        boundingBox[3] = new Point(position.getX() + width, highY);
    }
    public String getText(){return text;}

    public void draw(Graphics g, boolean drawBBox){
        g.setColor(itemColor);
        g.setFont(font);
        g.drawString(text, position.getX(), position.getY());
        if(drawBBox) {
            drawBoundingBox(g);
       }
    }

    @Override
    public Item translate(Point p) {
        position.translate(p);
        return new TextItem(position,text,font);
    }
}
