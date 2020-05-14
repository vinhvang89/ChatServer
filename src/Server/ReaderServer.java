package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReaderServer extends Thread {
    private final Socket socket;
    public ReaderServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis =new  DataInputStream(socket.getInputStream());
            while (true) {
                String line = dis.readUTF();
                if (line.equals("Exit")) {
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("Quit");
                    dos.flush();
                } else {
                    for (Socket item : Server.sockets) {
                        if (item.getPort() != socket.getPort()) {
                            DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                            dos.writeUTF(line);
                            dos.flush();
                        }
                    }
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
