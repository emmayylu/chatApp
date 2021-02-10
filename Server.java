package socketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static ArrayList<Socket> socketList = new ArrayList<Socket> (); 
	
	public static void main(String[] args) throws IOException {
			ServerSocket ss = new ServerSocket(9807);
			System.out.println("Waiting for clients to connect");
			while (true) {
				Socket soc = ss.accept();
				socketList.add(soc);
				try {
					ClientHandler client = new ClientHandler(soc, socketList);
					client.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}
}
