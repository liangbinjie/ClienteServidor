package cliente;
import java.io.*;
import java.util.Scanner;
import java.net.*;


public class Rutina {
    private static final String HOST = "localhost";
    private static int PUERTO = 5000;
    private Socket sc;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private String mensajeRecibido = "";
    private String mensajeEnviar = "";
    
    public void inicializarCliente() {
        try {
           Scanner lectura = new Scanner(System.in);
           sc = new Socket(HOST, PUERTO);
           entrada = new DataInputStream(sc.getInputStream());
           salida = new DataOutputStream(sc.getOutputStream());
           
           while (!mensajeEnviar.equals("SALIR")) {
               System.out.println("Message to send: ");
               mensajeEnviar = lectura.nextLine();
               salida.writeUTF(mensajeEnviar);
               mensajeRecibido = entrada.readUTF();
               System.out.println("Mensaje recibido: " + mensajeRecibido);
           }
           
        } catch (IOException ex) {
            
        }
    }
}
