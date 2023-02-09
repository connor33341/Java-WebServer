import java.io.*;
import java.net.*;

public class SimpleWebServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("Server started on port 8080");

    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("Accepted connection from " + clientSocket.getInetAddress().getHostAddress());

      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      OutputStream out = clientSocket.getOutputStream();

      String request = in.readLine();
      System.out.println("Received request: " + request);

      String response = "HTTP/1.1 200 OK\r\n\r\nHello, World!";
      out.write(response.getBytes());

      clientSocket.close();
    }
  }
}
