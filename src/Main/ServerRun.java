package Main;

import Server.Server;

import java.io.IOException;

public class ServerRun {
    public static void main(String[] args) throws IOException {
        Server server = new Server(3333);
        server.execute();
    }
}
