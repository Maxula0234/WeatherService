package client;

import hor.Phone;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to Server");
            String request = "Spb";
            System.out.println("Request: " + request);

            phone.writeLine("Request: " + request);

            String response = phone.readerLine();
            System.out.println("Response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
