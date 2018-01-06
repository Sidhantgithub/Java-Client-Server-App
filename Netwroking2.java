
package netwroking2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/*
Client
*/

public class Netwroking2 {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)){
            BufferedReader echoes = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(),
                    true);
            
            Scanner scanner = new Scanner(System.in);
            String response;
            String echoString;
            
            do {
                System.out.println("Enter string to be echoed");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);
                if(!echoes.equals("exit")){
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while(!echoes.equals("exit"));
	} catch (IOException e){
            System.out.println("Client error" + e.getMessage());
	} 
    }
    
}
