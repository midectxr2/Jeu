package be.ac.umons.emile.jeu.logique;

public abstract class Cases {
    protected int value;
    protected int x;
    protected int y;
    public Cases(int x, int y){
        this.x=x;
        this.y=y;
        this.value=value;
    }

    public abstract int getX();

    public abstract int getY();

    public abstract boolean isMovable();

    protected abstract int[] color();

    public abstract void rotate();

    public abstract String toString();

}