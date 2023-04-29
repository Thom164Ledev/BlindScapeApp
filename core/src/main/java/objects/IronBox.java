package objects;

import mechanics.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class IronBox extends Objects{
    private static Image icon = null;

    static {
        try {
            icon = ImageIO.read(java.util.Objects.requireNonNull(Box.class.getClassLoader().getResourceAsStream("textures/ironBox.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IronBox(Location l){
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
