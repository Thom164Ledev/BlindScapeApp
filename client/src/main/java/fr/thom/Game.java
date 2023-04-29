package fr.thom;

import mechanics.Location;
import objects.IronBox;
import objects.Objects;
import objects.Box;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel {
    public static Game party;
    private final JFrame frame = new JFrame("Blind Scape Party");
    public static Location selectedLocation;
    private final int width;
    private final int height;


    public Game(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        start();
    }

    public void start() throws IOException {
        graphics();
        //ServerConnection.connect();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shuting Down...");
            /*try {
                ServerConnection.in.close();
                ServerConnection.out.close();
                ServerConnection.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }));
    }

    public void graphics() throws IOException {
        frame.setContentPane(this);
        frame.setSize(width * 40 + 16, height * 40 + 39);
        frame.setLocationRelativeTo(null);
        Image icon = ImageIO.read(java.util.Objects.requireNonNull(Controller.class.getClassLoader().getResourceAsStream("textures/box.png")));
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(selectedLocation != null) System.out.println(Location.touches(selectedLocation, new Location(((e.getX() - 8) / 40) * 40, ((e.getY() -  33) / 40) * 40)));
                selectedLocation = new Location(((e.getX() - 8) / 40) * 40, ((e.getY() -  33) / 40) * 40);
                /*System.out.println(e.getX() + " ; " + e.getY());
                System.out.println(((e.getX() - 8) / 40) * 40 + " ; " + ((e.getY() -  33) / 40) * 40);*/
                if (e.getButton() == 3){
                    new Box(new Location(((e.getX() - 8) / 40) * 40, ((e.getY() -  33) / 40) * 40));
                }else if(e.getButton() == 1){
                    new IronBox(new Location(((e.getX() - 8) / 40) * 40, ((e.getY() -  33) / 40) * 40));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        new Thread(() -> {
            while (true){
                frame.repaint();
            }
        }).start();
    }


    @Override
    public void paint(Graphics g) {
        /*System.out.println("repaint");
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 920, 400);*/
        for (float x = 1; x < (width + 1); x++) {
            for (float y = 1; y < (height + 1); y++) {
                int x1 = (int) x * 40 - 40;
                int y1 = (int) y * 40 - 40;
                if ((x + y) / 2 == Math.round((x + y) / 2)) {
                    g.setColor(new Color(24, 50, 84, 255));
                } else {
                    g.setColor(new Color(24, 70, 120, 255));
                }
                g.fillRect(x1, y1, 40, 40);
            }
        }
        try {
            /*g.drawImage(ImageIO.read(new File("src/Main/Textures/box.png")), 120, 120, null);
            g.drawImage(ImageIO.read(new File("src/Main/Textures/ironBox.png")), 200, 120, null);
            g.drawImage(ImageIO.read(new File("src/Main/Textures/portal.png")), 280, 120, null);
            g.drawImage(ImageIO.read(new File("src/Main/Textures/unknown.png")), 360, 120, null);*/
            Objects.drawObjects(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.setColor(Color.RED);
        if(selectedLocation != null) g.drawRect(selectedLocation.getX(), selectedLocation.getY(), 39, 39);
    }
}
