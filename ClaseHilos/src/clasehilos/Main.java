package clasehilos;


public class Main {

    public static void main(String[] args) {
        Hilo competidor1 = new Hilo("Usain Bolt");
        Hilo competidor2 = new Hilo("Nery Breens");
        Hilo competidor3 = new Hilo("Bryan Ruiz");
        competidor1.start();
        competidor2.start();
        competidor3.start();
    }
    
}
