package fr.thom.serverconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    public static String serverIp = "192.168.1.72";
    public static int port = 50000;
    public static Socket socket;
    public static BufferedReader in;
    public static PrintWriter out;
    public static void connect() throws IOException {
        socket = new Socket(serverIp, port);
        System.out.println("Connexion établie...");
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        String line;

        while ((line = in.readLine()) != null) {
            System.out.println("Message reçu du serveur : " + line);
        }
        System.out.println("Server Connection lost");
        System.exit(0);
    }
}
