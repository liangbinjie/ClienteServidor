package servidor;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Servidor {
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

            System.out.println("Esperando conexiones");
            cl = sc.accept();
            System.out.println("Nuevo cliente conectado!");
            entrada = new DataInputStream(cl.getInputStream());
            salida = new DataOutputStream(cl.getOutputStream());
            while (!mensajeEnviar.equals("SALIR")) {
                System.out.print("Servidor: ");
                mensajeEnviar = lectura.nextLine();
                
                salida.writeUTF(mensajeEnviar);
                mensajeRecibido = entrada.readUTF();
                System.out.println("Respuesta del cliente: " + mensajeRecibido);
                double res = resolver(mensajeEnviar);
                if (Double.parseDouble(mensajeRecibido) == res) {
                    salida.writeUTF("CORRECTO!");
                } else {
                    System.out.println("Respuesta emitida por el servidor: " + res);
                    salida.writeUTF("INCORRECTO");
                }

            }


        } catch (IOException ex) {
            System.out.println("Error en el servidor");
        }
    }
    
    public double resolver(String operacion) {
        String s = operacion.replace(" ", "");
        s += "+0";
        String numero = "";
        String operador = "";
        double res = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numero += c;
            }
            if (!Character.isDigit(c)) {

                int a = Integer.parseInt(numero);
                if (operador.equals("")){
                    res = a;
                } else {
                    if (operador.equals("+")) {
                        res += a;
                    } else if (operador.equals("-")) {
                        res -= a;
                    } else if (operador.equals("*")) {
                        res *= a;
                    } else if (operador.equals("/")) {
                        res /= a;
                    } 
                }
                numero = "";
                operador = "" + c;
            }
        }
        return res;
    }
}
