/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import Model.LoginModel;
import Views.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.*;
import Views.Dashboard;

/**
 *
 * @author Dell
 */
public class LoginController {
    private final UserDao userdao = new UserDao();
    private final Login login;
    
    public LoginController(Login login) {
        this.login = login;
        login.addLoginUserListener(new LoginUserListener());
    
    }
    
      public void open() {
        this.login.setVisible(true);
        
    }
    public void close() {
        this.login.dispose();
    }
    class LoginUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = login.getUsernameField().getText();
                String password = new String(login.getPasswordField().getPassword()); 
                LoginModel user = new LoginModel(username,password);
                boolean isValid = userdao.login(user);
                
                
            if (isValid) {
                JOptionPane.showMessageDialog(login, "Login successful!");
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                login.dispose();
            } else {
                JOptionPane.showMessageDialog(login, "Invalid username or password.");
                
            } 
            }
            catch(Exception ex) {
            System.out.println("Error adding user: " + ex.getMessage());
            JOptionPane.showMessageDialog(login, "Login failed: " + ex.getMessage());
            }
        
         }
    }
}
