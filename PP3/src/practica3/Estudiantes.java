package practica3;


public class Estudiantes {
    private String nombre;
    private int edad;
    private int estatura;
    private String grado;
    
    public Estudiantes() {
        this.nombre = "";
        this.edad = 0;
        this.estatura = 0;
        this.grado = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    
}
