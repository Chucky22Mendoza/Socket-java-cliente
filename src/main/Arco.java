/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Images;
import model.Lectura;
import model.User;
import model.SendLecturas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.ArcoConfiguracion;
import model.Carril;
import model.Coordenadas;
import model.InformacionDispositivo;
import model.RecibirConfiguracion;

/**
 *
 * @author Lenovo
 */
public class Arco {
    public static void socketConnection() {
        String url = "http://localhost:3005/"; //URL A CONSUMIR SERVIDOR SOCKETS
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            options.reconnectionAttempts = 10;// Number of failed retries
            options.reconnectionDelay = 1000;// Time interval for failed reconnection
            options.timeout = 500;// Connection timeout (ms)
            final Socket socket = IO.socket(url, options);
            
            // Listening for custom subscription events    
            socket.on("connect", arg -> {
                User user = new User();
                user.setNegocio("Xilion");
                user.setClientType("reader-client");
                
                socket.emit("user_token", gson.toJson(user));
                System.out.println("client: successful connection ID -> " + socket.id());
            });
            
            socket.on(Socket.EVENT_CONNECT_ERROR, arg -> {
                System.out.println("client: connection failure");
            });
            
            socket.on("server_java_message", arg -> {
                System.out.println(arg[0]);
            });
            
            socket.on("configuracion_arco", arg -> {
                try {
                    JsonElement jelem = gson.fromJson(arg[0].toString(), JsonElement.class); //Convertir String a JsonElement
                    JsonObject jobj = jelem.getAsJsonObject(); //Convertir a JsonObject
                    String codigo = jobj.get("codigo").toString().replace("\"", ""); //Key codigo del JSON generado
                    
                    if (codigo.equals("001")) {
                        RecibirConfiguracion configuracion = gson.fromJson(arg[0].toString(), RecibirConfiguracion.class);
                        System.out.println(configuracion.getMensaje());

                        ArcoConfiguracion arco = configuracion.getDatos();
                        Coordenadas coordenadas = arco.getCoordenadas();
                        List<Carril> carriles = arco.getCarriles();
                        System.out.println("\t\t\t\tCONFIGURACIÓN DEL ARCO");
                        System.out.println("");
                        System.out.println("\tARCO");
                        System.out.println("\t\tNombre: " + arco.getNombre_arco());
                        System.out.println("\t\tDescripción: " + arco.getDescripcion());
                        System.out.println("\t\tLatitud: " + coordenadas.getLat());
                        System.out.println("\t\tLongitud: " + coordenadas.getLng());
                        System.out.println("\t\tFrecuencia de sincronización: " + arco.getFrecuencia_sincronizacion());
                        System.out.println("\t\tIP servidor: " + arco.getIp_servidor());
                        System.out.println("\t\tIP RFID: " + arco.getIp_rfid());
                        System.out.println("\t\tDirección log: " + arco.getDireccion_log());
                        System.out.println("\t\tTipo arco: " + arco.getTipo_arco());
                        System.out.println("\t\tNombre entidad: " + arco.getNombre_entidad());
                        
                        for (Carril carril: carriles) {
                            System.out.println("");
                            System.out.println("\t\tCARRIL");
                            InformacionDispositivo informacion = carril.getInformacion();
                            System.out.println("\t\t\tTipo carril: " + carril.getTipo());
                            System.out.println("\t\t\tNombre carril: " + carril.getNombre());
                            System.out.println("\t\t\tDescripcioncarril: " + carril.getDescripcion());
                            System.out.println("\t\t\tOrientación carril: " + carril.getOrientacion());
                            System.out.println("");
                            System.out.println("\t\t\t\tINFORMACIÓN");
                            System.out.println("\t\t\t\t\tIP: " + informacion.getIp());
                            System.out.println("\t\t\t\t\tDispositivo: " + informacion.getDispositivo());
                            System.out.println("\t\t\t\t\tDirección log: " + informacion.getDireccion_log());
                        }

                    } else {    
                        String mensaje = jobj.get("mensaje").toString().replace("\"", ""); //Key codigo del JSON generado
                        String error = jobj.get("datos").toString().replace("\"", ""); //Key codigo del JSON generado
                        System.out.println(codigo);
                        System.out.println(mensaje);
                        System.out.println(error);
                    }
                } catch (JsonSyntaxException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            
            socket.on("disconnect", arg -> {
                System.out.println("client: disconnected");
                if (arg[0].equals("io server disconnect")) {
                    socket.connect();
                }
            });
            
            socket.connect();
            
            List<Images> images = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Images image = new Images();
                image.setUrl("c:/images");
                images.add(image);
            }
            
            List<Lectura> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Lectura lectura = new Lectura();
                lectura.setId("0406f920-2235-11ec-83ed-f76b9b0eb572");
                lectura.setFecha_hora("2021-09-02 11:37:20.176");
//                lectura.setFecha_hora(null);
                lectura.setId_carril("371ebf4a-f3bf-11eb-a56d-2ffb0d6687b6");
                lectura.setCve_arco("e7fc3cee-f3af-11eb-9727-7f68dc8f338a");
                lectura.setImg_vehiculo(images);
                lectura.setNum_placa("DF-922DS");
                lectura.setNiv("12548532158423458");
                lectura.setTid(null);
                lectura.setNci(null);
                lectura.setId_sis_entidades("3115626e-eef8-11eb-ad1d-1bfaf8b7862e");
                list.add(lectura);
            }
            
            SendLecturas lecturas = new SendLecturas();
            lecturas.setNegocio("Xilion");
            lecturas.setLecturas(list);
            socket.emit("lectura_repuve", gson.toJson(lecturas));
            
            socket.emit("identificador_configuracion", "d2227c98-f3b0-11eb-9728-bfbade101a06");
        } catch (URISyntaxException ex) {
            System.err.println(ex.getMessage());
        }
    }
}