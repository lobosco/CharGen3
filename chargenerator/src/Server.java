import java.io.IOException;
import java.net.ServerSocket;


public class Server extends Thread{

	/*
	 * Server, created to process incoming requests and to perform LaTeX- compilation
	 * 
	 * 
	 */
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();
    }
    
    public Server() {

    }

	public void run() {
		System.out.println("Server gestartet");
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		 try {
	            serverSocket = new ServerSocket(1337);
	            while (true) {
	                new ServerThread(serverSocket.accept()).run();
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
