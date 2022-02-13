import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true) {
                try (Socket socket = server.accept();
                     BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    String request = reader.readLine();
                    String response = String.valueOf(Math.random() * 30 - 10);

                    System.out.println("Client connected");

                    sw.write(response);
                    sw.newLine();
                    sw.flush();

                    System.out.println(response);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
