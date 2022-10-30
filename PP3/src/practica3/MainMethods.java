package practica3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;


public class MainMethods {
    String mayores = "";
    String menores = "";
    int cant = 0;
    double estaturas = 0;
        
    public void filter(){
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("estudiantes.dat"));
            try {
                Estudiantes estudiante = new Estudiantes();
                while (true) {
                    estudiante.setNombre(entrada.readUTF());
                    estudiante.setEdad(entrada.readInt());
                    estudiante.setEstatura(entrada.readInt());
                    estudiante.setGrado(entrada.readUTF());

                    if (estudiante.getEdad() < 10) {
                        menores += "* " + estudiante.getNombre() + "\n";
                        estaturas += estudiante.getEstatura();
                        cant++;
                    } else if (estudiante.getEdad() >= 10) {
                        mayores += "* " + estudiante.getNombre() + "\n";
                        estaturas += estudiante.getEstatura();
                        cant++;
                    }

                }
            } catch (EOFException ex02) {
                entrada.close();
                JOptionPane.showMessageDialog(null, "Cantidad de estudiantes inscritos: " + cant);
                JOptionPane.showMessageDialog(null, "Estudiantes menores de 10 años\n" + menores);
                JOptionPane.showMessageDialog(null, "Estudiantes igual o mayores de 10 años\n" + mayores);
                JOptionPane.showMessageDialog(null, "Estatura promedio de los estudiantes: " + estaturas/cant);
            };
        } catch (FileNotFoundException ex03) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado, revise!",
                    "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex04) {
            JOptionPane.showMessageDialog(null, "¡Error general, revise!",
                    "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
