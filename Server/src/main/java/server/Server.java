package server;

import service.Phone;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true) {
                try (Phone phone = new Phone(server)) {
                    String request = phone.readerLine();
                    System.out.println("Request: " + request);

                    String response = String.valueOf(Math.random() * 30 - 10);
                    System.out.println("Client connected");

                    phone.writeLine(response);
                    System.out.println("Response: " + response);

                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
