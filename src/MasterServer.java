import java.io.*;
import java.net.*;

public class MasterServer {

    ServerSocket initialSocket; // The initial socket connection with the client (IP/port)
    Socket connection = null;  // The connection created between client/server

public static void main(String[] args) {
    new MasterServer().openServer(); // Creating the server
}

void openServer(){

    int port = 4321; // The identifier of the server 
    
    try {
        initialSocket = new ServerSocket(port); // Initializing the server 
        System.out.println("Server is listening to the port: "+ port);


        while(true){
            connection = initialSocket.accept(); // Accepting client/server communication
            System.out.println("New Client Connected");

            Thread t = new ActionHandler(connection); // Creating a thread for each client's request/action
            t.start();
            
            }
        }catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				initialSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
     }
}
