package Main;

import Client.Client;

import java.io.IOException;
import java.net.InetAddress;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Client client1 = new Client(InetAddress.getLocalHost(),3333,"Alo");
        client1.execute();
    }
}
