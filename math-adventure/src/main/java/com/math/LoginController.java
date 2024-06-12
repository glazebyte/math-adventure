package com.math;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private void switchToMain() throws IOException {
        String name = username.getText();
        String pass = password.getText();

        System.out.println(name);

        User user = AppData.LoginUser(name, pass);

        if(user.isAdmin()){
            App.setRoot("primary");
        }else if(!user.isAdmin()){
            App.setRoot("secondary");
        }else{
            System.out.println("Invalid username or password.");
        }
    }
}
