package socketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
	private Socket soc;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<Socket> socketList;
	
	public ClientHandler(Socket soc, ArrayList<Socket> socketList) throws IOException{
		this.soc = soc;
		this.socketList = socketList;
		this.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		this.out = new PrintWriter(soc.getOutputStream(), true);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				String request = in.readLine();
				System.out.println(request);
				
				outToAll();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void outToAll() throws IOException {
		for(Socket soc: socketList) {
			PrintWriter out2 = new PrintWriter(soc.getOutputStream(), true);
			out2.println("a response from server to client");

		}
	}
	
	
	
	
	
	
}