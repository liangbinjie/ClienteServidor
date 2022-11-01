package clasehilos;


public class Hilo extends Thread {
    private String competidor;
    
    public Hilo(String competidor) {
        this.competidor = competidor;
    }
    
    @Override
    public void run() {
        System.out.println("El competidor " + competidor + " llego a la meta");
    }
}
