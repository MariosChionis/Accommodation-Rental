import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;

public class ClientConsoleDummy {
    private String host;
    private int port;

    public ClientConsoleDummy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;

            System.out.println("Enter 'add' to add a new accommodation, or 'exit' to quit:");
            while (!(userInput = consoleInput.readLine()).equals("exit")) {
                if ("add".equals(userInput)) {
                    System.out.println("Enter accommodation name:");
                    String name = consoleInput.readLine();

                    System.out.println("Enter location:");
                    String location = consoleInput.readLine();

                    System.out.println("Enter capacity (number of guests):");
                    int capacity = Integer.parseInt(consoleInput.readLine());

                    
                    //ArrayList<Date> availableDates = new ArrayList<>();

                    System.out.println("Enter price per night:");
                    double pricePerNight = Double.parseDouble(consoleInput.readLine());

                    System.out.println("Enter rating (1-5):");
                    float rating = Float.parseFloat(consoleInput.readLine());

                    System.out.println("Enter reviews:");
                    int reviews = Integer.parseInt(consoleInput.readLine());

                    System.out.println("Enter image path:");
                    String imagePath = consoleInput.readLine();

                    Accommodation accommodation = new Accommodation(name, location, capacity, pricePerNight, rating,reviews, imagePath);
                    out.writeObject(accommodation);

                    String response = (String) in.readObject();
                    System.out.println("Server response: " + response);
                } else {
                    System.out.println("Unknown command.");
                }
                System.out.println("Enter 'add' to add a new accommodation, or 'exit' to quit:");
            }

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Input error: Please make sure you enter valid numbers for capacity, price, and rating.");
        }
    }

    public static void main(String[] args) {
        ClientConsoleDummy client = new ClientConsoleDummy("192.168.31.188", 4321);
        client.start();
    }
}
