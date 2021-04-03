import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
    private static final String serverAddress="localhost";
    private static final int serverPort=8189;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Socket socket= null;
        try {
            socket=new Socket(serverAddress,serverPort);

            System.out.println("Client connected to server: " + socket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner in = new Scanner(socket.getInputStream());
            Thread threadReader = new Thread(()->
            {
                try
                {
                    while (true)
                    {
                        outputStream.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            threadReader.start();

            while (true)
            {
                String str = inputStream.readUTF();
                if(str.equals("/end"))
                {
                    System.out.println("Disconnected");
                    break;
                }
                else
                {
                    System.out.println("Server: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
