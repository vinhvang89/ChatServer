package Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class WriterServer extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = null;
        while (true){
            String line = scanner.nextLine();
            try {
                for (Socket item : Server.sockets) {
                    dataOutputStream = new DataOutputStream(item.getOutputStream());
                    dataOutputStream.writeUTF("(God): "+line);
                    dataOutputStream.flush();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }
        }
    }
}
