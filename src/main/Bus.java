/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Bus {
    public void socketConnection() {
        String url = "http://localhost:6000/";
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            options.reconnectionAttempts = 10;// Number of failed retries
            options.reconnectionDelay = 1000;// Time interval for failed reconnection
            options.timeout = 500;// Connection timeout (ms)
            final Socket socket = IO.socket(url, options);
            
            // Listening for custom subscription events    
            socket.on("connect", arg -> {
                socket.emit("client-type", "java-client");
                System.out.println("client: successful connection ID -> " + socket.id());
            });
            
            socket.on(Socket.EVENT_CONNECT_ERROR, arg -> {
                System.out.println("client: connection failure");
            });
            socket.on("disconnect", arg -> {
                System.out.println("client: disconnected");
                if (arg[0].equals("io server disconnect")) {
                    socket.connect();
                }
            });
            
            socket.connect();
            
            List<String> listaTest = new ArrayList<>();
            listaTest.add("ec18e4be-8134-11eb-8c69-42010a800006");
            listaTest.add("[['19.308374998146444', '-103.7534351165693']]");
            
            socket.emit("clientCoordinates", listaTest);
        } catch (URISyntaxException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
