package objects;

import mechanics.Location;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Objects {
    public static ArrayList<Objects> objects = new ArrayList<>();

    public static void drawObjects(Graphics g) throws IOException {
        for (Objects o:
             objects) {
            o.draw(g);
        }
    }
    public static void addObject(Objects object){
        if(getObjectAt(object.getLocation()) != null) System.out.println("There is already an object in" + object.getLocation().toString());
        else objects.add(object);
    }
    
    public static Objects getObjectAt(Location l){
        for (Objects obj:
             objects)
            if (obj.getLocation().getX() == l.getX() && obj.getLocation().getY() == l.getY()) {
                return obj;
            }
        return null;
    }

    public Location l;

    public Objects(Location location){
        this.l = location;
        Objects.addObject(this);
        //System.out.println(objects);
    }

    public abstract Location getLocation();

    public abstract void setLocation(Location l);

    public abstract void draw(Graphics g) throws IOException;
}
