public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public void translate(Point p) {
        x += p.getX();
        y += p.getY();
    }

    public static Point getTopLeft(Point [] tab) {
        int resX = tab[0].x;
        int resY = tab[0].y;
        for(int i = 1; i < tab.length; i++) {
            if(tab[i].x < resX) resX = tab[i].x;
            if(tab[i].y < resY) resY = tab[i].y;
        }
        return new Point(resX,resY);
    }
    public static Point getTopRight(Point [] tab) {
        int resX = tab[0].x;
        int resY = tab[0].y;
        for(int i = 1; i < tab.length; i++) {
            if(tab[i].x > resX) resX = tab[i].x;
            if(tab[i].y < resY) resY = tab[i].y;
        }
        return new Point(resX,resY);
    }
    public static Point getBotLeft(Point [] tab) {
        int resX = tab[0].x;
        int resY = tab[0].y;
        for(int i = 1; i < tab.length; i++) {
            if(tab[i].x < resX) resX = tab[i].x;
            if(tab[i].y > resY) resY = tab[i].y;
        }
        return new Point(resX,resY);
    }
    public static Point getBotRight(Point [] tab) {
        int resX = tab[0].x;
        int resY = tab[0].y;
        for(int i = 1; i < tab.length; i++) {
            if(tab[i].x > resX) resX = tab[i].x;
            if(tab[i].y > resY) resY = tab[i].y;
        }
        return new Point(resX,resY);
    }
}
