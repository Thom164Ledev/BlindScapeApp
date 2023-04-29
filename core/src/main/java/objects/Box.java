package objects;

import mechanics.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Box extends objects.Objects {
    private static Image icon = null;

    static {
        try {
            icon = ImageIO.read(Objects.requireNonNull(Box.class.getClassLoader().getResourceAsStream("textures/box.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Box(Location l){
        super(l);
    }

    @Override
    public Location getLocation() {
        return l;
    }

    @Override
    public void setLocation(Location l) {
        this.l = l;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(icon, l.getX(), l.getY(), null);
    }
}
