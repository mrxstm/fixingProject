/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package khatarnakproject;

import Controller.LoginController;
import Database.Database;
import Database.MySqlConnection;
import Views.*;
import controller.*;

/**
 *
 * @author Dell
 */
public class KhatarnakProject {

    /**
     * @param args the command line arguments
     */
 
public static void main(String[] args) {
        // TODO code application logic here
        Database db = new MySqlConnection();
        if(db.openConnection() !=null) {
            System.out.println("Database connection successfull");
        } 
        else {
            System.out.println("Database connection failed");
        }
        
        Register registerform = new Register();
        RegistrationController controller = new RegistrationController(registerform);
        controller.open();
//      
//        Login loginform = new Login();
//        LoginController logincontroller = new LoginController(loginform);
//        logincontroller.open();

        
        


    }

}
    

