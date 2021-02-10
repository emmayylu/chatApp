package socketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection extends Thread{
	private Socket soc;
	private BufferedReader in;
	
	
	public ServerConnection(Socket soc) throws IOException {
		this.soc = soc;		
		this.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

	}
	
	@Override
	public void run() {
		while(true) {
			String serverResponse = null;
			try {
				serverResponse = in.readLine();
				System.out.println(serverResponse);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
