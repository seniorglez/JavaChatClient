/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ReadMessage extends Thread {

    public ObjectInputStream ois;

    public ReadMessage(ObjectInputStream ois) {
        this.ois = ois;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ChatMessage chmsg = (ChatMessage) ois.readObject();
                System.out.println(chmsg.getAuthor() + " dice: " + chmsg.getHeader() + chmsg.getText());
            } catch (IOException ex) {
                Logger.getLogger(ReadMessage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
