package server;

import java.util.Scanner;

public class ServerStarter {

    private static Server server;

    public static void main(String[] args){
        System.out.println("Digite o nome do repositório");
        Scanner s = new Scanner(System.in);
        String repName = s.nextLine();
        System.out.println("Digite a porta do repositório");
        int repPort = s.nextInt();
        server = new Server(repName, repPort);
        server.init();
    }
}
