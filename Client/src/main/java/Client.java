import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socketClient = new Socket("127.0.0.1", 8000);
             BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()))
        ) {
            System.out.println("Connected to Server");
            String request = "Spb";
            System.out.println("Request: " + request);

            sw.write(request);
            sw.newLine();
            sw.flush();

            String response = reader.readLine();
            System.out.println("Response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
