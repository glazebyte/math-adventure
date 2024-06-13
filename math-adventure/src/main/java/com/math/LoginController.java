package com.math;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Button bebas;
    
    @FXML
    private void switchToMain() throws IOException {
        String name = username.getText();
        String pass = password.getText();

        System.out.println(name);

        User loggedInUser = AppData.LoginUser(name, pass);

        if(loggedInUser != null){
            UserHolder userHolder = UserHolder.getInstance();
            userHolder.setLoggedInUser(loggedInUser);
            System.out.println("berhasil login");
            if(userHolder.getLoggedInUser().isAdmin()){
                System.out.println("login sebagai admin");
                App.setRoot("dashboard");
            }else{
                System.out.println("loggin sebagai user");
                App.setRoot("game_view");
            }
        }else{
            System.out.println("invalid username or password");
        }
    }
}
