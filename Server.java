import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected" + socket.getRemoteSocketAddress());
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
                    System.out.println("Client disconnected");
                    break;
                }
                else
                    {
                        System.out.println("Client: " + str);
                    }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try
            {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
