package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client{
    private String name;
    private InetAddress host;
    private int port;

    public Client(InetAddress host, int port,String name) {
        this.host = host;
        this.port = port;
        this.name = name;
    }

    public void execute() throws IOException {
        Socket socket = new Socket(host,port);
        WriterClient writerClient = new WriterClient(socket,name);
        writerClient.start();
        ReaderClient readerClient = new ReaderClient(socket);
        readerClient.start();
    }
}
