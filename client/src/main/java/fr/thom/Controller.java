package fr.thom;

import fr.thom.serverconnection.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField serverIpTextField;
    public TextField portTextField;
    public TextField widthTextField;
    public TextField heightTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serverIpTextField.setText(Connection.serverIp);
        portTextField.setText(String.valueOf(Connection.port));
        widthTextField.setText(String.valueOf(24));
        heightTextField.setText(String.valueOf(9));
    }

    public void playGame(ActionEvent actionEvent) throws IOException {
        Game.party = new Game(24, 10);
    }

}
