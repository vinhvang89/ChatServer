package Client;

import Server.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriterClient extends Thread {
    private  Socket socket;
    private String name;
    public WriterClient(Socket socket,String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                String line = scanner.nextLine();
                dataOutputStream.writeUTF("("+name+"): "+line);
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
