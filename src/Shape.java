public abstract class Shape extends Primitive{
    protected boolean filled;
    public Shape(Point position, boolean filled) {
        super(position);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }
}
