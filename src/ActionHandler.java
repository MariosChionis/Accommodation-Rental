import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ActionHandler extends Thread{

    Socket socket; // The socket after accepting the connection with the server

    private ArrayList<Accommodation> accommodations = new ArrayList<>(); // List of accommodations in the application

    public ActionHandler(Socket connection){
        this.socket = connection;
    }

    public void run(){
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {// The request and response of the client and the server respectively

            Accommodation accommodation = (Accommodation) in.readObject();// Converts the serialized input into an Accommodation object
            accommodations.add(accommodation);
            System.out.println("Received and added accommodation: " + accommodation.getName());

            // Sending confirmation to the client
            out.writeObject("Accommodation " + accommodation.getName() + " added successfully");
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

