import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ActionHandler extends Thread{


    Socket socket; // The socket after accepting the connection with the server

    public static ArrayList<Accommodation> accommodations = new ArrayList<>(); // List of accommodations in the application

    public ActionHandler(Socket connection){
        this.socket = connection;
    }

    public void run(){
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {// The request and response of the client and the server respectively

            Accommodation accommodation = (Accommodation) in.readObject();// Converts the serialized input into an Accommodation object
            accommodations.add(accommodation);
            
            String accommodationJson=convertToJson(accommodation);

            saveJsonToFile(accommodationJson, "accommodations.json");
            
            System.out.println("Received and added accommodation: " + accommodation.getName());

            // Sending confirmation to the client
            out.writeObject("Accommodation " + accommodation.getName() + " added successfully");

            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static String convertToJson(Accommodation accommodation) {
        // Basic JSON conversion. In a real-world scenario, use a library like Gson or Jackson.
        return "{" +
                "\"name\": \"" + accommodation.getName() + "\"," +
                "\"location\": \"" + accommodation.getLocation() + "\"," +
                "\"capacity\": " + accommodation.getCapacity() + "," +
                "\"pricePerNight\": " + accommodation.getPricePerNight() + "," +
                "\"rating\": " + accommodation.getRating() + "," +
                "\"reviews\": " + accommodation.getReviews() + "," +
                "\"imagePath\": \"" + accommodation.getImagePath().replace("\\", "\\\\") + "\"" + // Escaping backslashes in file paths
                "}";
    }

    private static void saveJsonToFile(String json, String filename) {
        // Appends the JSON string to the given file.
        try (FileWriter fileWriter = new FileWriter(filename, true)) { // true to append, false to overwrite.
            fileWriter.write(json + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

