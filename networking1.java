/* 
Server
*/
import java.io.*;
import java.net.*;

class networking1 {
	public static void main(String[] args){
		try(ServerSocket serverSocket = new ServerSocket(5000)){
		//Get client instance
		Socket socket = serverSocket.accept();
		System.out.println("Client connected");
		BufferedReader input = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		
		while(true){
			String echoString = input.readLine();
			if(echoString.equals("exit"))
				break;
			output.println("Echo from server" + echoString);
		}
	} catch(IOException e){
		System.out.println("Server exception");
		e.printStackTrace();
	}
	}
}