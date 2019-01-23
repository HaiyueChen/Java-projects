import java.util.*;

class Main{

    public static void main(String[] args) {
        Regneklynge abel = new Regneklynge("Abel", 12);
        abel.addNode(650, 1, 64);
        abel.addNode(16, 2, 1024);
        System.out.println("Node med minst 32 GB med RAM: " + abel.nodeMram(32));
        System.out.println("Node med minst 64 GB med RAM: " + abel.nodeMram(64));
        System.out.println("Node med minst 128 GB med RAM: " + abel.nodeMram(128));
        System.out.println("Antall prosessorer: " + abel.hentCPU());
        System.out.println("Antall rack: " + abel.hentAntRack());
    }
}