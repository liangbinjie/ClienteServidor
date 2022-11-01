package claseHilos2;

public class Hilo extends Thread {
    private String competidor;
    
    public Hilo(String competidor) {
        this.competidor = competidor;
    }
    
    @Override
    public void run() {
        for (int i=1; i<4; i++) {
            System.out.println("El competidor " + competidor + " ha superado el obstaculo " + i);
        }
        System.out.println("El competidor " + competidor + " llego a la meta");
        
    }
}
