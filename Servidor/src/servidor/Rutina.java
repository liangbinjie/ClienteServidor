package servidor;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Rutina {
    private static final int PUERTO = 5000;
    private ServerSocket sc;
    private Socket cl;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private String mensajeRecibido = "";
    private String mensajeEnviar = "";


    public void inicializarServidor() {
        Scanner lectura = new Scanner(System.in);
        try {
            sc = new ServerSocket(PUERTO);
            cl = new Socket();

            System.out.println("Waiting for connection");
            cl = sc.accept(); // accept() = habiliatr que el servidor pueda recibir conexiones
            System.out.println("New client connected");
            entrada = new DataInputStream(cl.getInputStream());
            salida = new DataOutputStream(cl.getOutputStream());
            while (!mensajeEnviar.equals("SALIR")) {
                mensajeRecibido = entrada.readUTF();
                System.out.println("New message: " + mensajeRecibido);
                System.out.print("Response: ");
                mensajeEnviar = lectura.nextLine();
                salida.writeUTF(mensajeEnviar);
            }


        } catch (IOException ex) {
            System.out.println("Error en el servidor");
        }
    }
    
    
}
