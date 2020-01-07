/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class SendMessage extends Thread {

    private String author;
    private ObjectOutputStream oos;
    private Scanner sc;

    public SendMessage(String author, ObjectOutputStream oos, Scanner sc) {
        this.author = author;
        this.oos = oos;
        this.sc = sc;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("Insert header: ");
            String header = sc.nextLine();
            System.out.print("Insert the text: ");
            String text = sc.nextLine();
            try {
                oos.writeObject(new ChatMessage(header, text, author));
            } catch (IOException ex) {
                Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
