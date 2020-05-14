package Main;

import Client.Client;

import java.io.IOException;
import java.net.InetAddress;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Client client2 = new Client(InetAddress.getLocalHost(),3333,"Blo");
        client2.execute();
    }
}
