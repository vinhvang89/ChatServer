package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    public static  List<Socket> sockets;
    public Server(int port) {
        this.port = port;
        sockets = new ArrayList<>();
    }

    public void execute() throws IOException {
        ServerSocket server = new ServerSocket(port);
        WriterServer writerServer = new WriterServer();
        writerServer.start();
        while (true) {
            Socket socket = server.accept();
            sockets.add(socket);
            ReaderServer readerServer = new ReaderServer(socket);
            readerServer.start();

        }

    }

}
