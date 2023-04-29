package mechanics;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return this.getX() + " ; " + this.getY();
    }

    public static boolean touches(Location l1, Location l2){
        /*System.out.println(l1.toString() + " and " + l2.toString());
        System.out.println((l1.getY() - l2.getX()) < 41);
        System.out.println((l1.getX() - l2.getX()) > -41);
        System.out.println((l1.getY() - l2.getY()) < 41);
        System.out.println((l1.getY() - l2.getY()) > -41);*/
        return ((l1.getY() - l2.getX()) < 41 && (l1.getX() - l2.getX()) > -41 && (l1.getY() - l2.getY()) < 41 && (l1.getY() - l2.getY()) > -41);
    }
}
