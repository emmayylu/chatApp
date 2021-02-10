package socketChat;
import java.io.*;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			//Create a socket and connect to server
			Socket soc = new Socket("localhost", 9807);
			System.out.println("Client connected");
			ServerConnection getResponse = new ServerConnection(soc);
			getResponse.start();
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

			while (true) {
				System.out.println("> ");
				String command = keyboard.readLine();
			
				if(command.equals("quit")) {
					break;
				}
			
			out.println(command);
			}
		}
			
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
