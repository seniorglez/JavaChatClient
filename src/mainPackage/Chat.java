/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Chat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your alias:");
        String author = sc.nextLine();
        try {
            Socket s = new Socket("localhost", 1234);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            SendMessage sm = new SendMessage(author, oos, sc);
            ReadMessage rm = new ReadMessage(ois);
            sm.start();
            rm.start();
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
