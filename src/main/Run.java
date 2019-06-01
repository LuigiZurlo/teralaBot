/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author LuigiZ
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Task t = new Task();

        switch (args[0]) {
            case "sl": // upload locations e sensori
                t.createJsonSensor();
                break;
            case "past":
                t.runPast();
                break;
            case "default":
                t.runDefault();
                break;
            default:
                break;
        }
    }

}
