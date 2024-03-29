package appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private int port = 12345;
    public static Map<Integer, Chat> chatMap;

    public Server() throws IOException {
        chatMap = new HashMap<>();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    CreateServerRequest request = new CreateServerRequest(socket, output, input);
                    request.start();
                } catch (Exception e) {
                    System.out.println("A chat disconnected");
                }
            }

        } catch (IOException e) {
            System.out.println("Cannot open server");
        }
    }

    public String getPort() {
        return "" + port;
    }

    public void closeServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Cannot close");
        }
    }
}

class CreateServerRequest extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;

    public CreateServerRequest(Socket socket, DataOutputStream outputStream, DataInputStream inputStream)
            throws IOException {
        this.input = inputStream;
        this.output = outputStream;
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try {
                String str = input.readUTF();
                if (str.equals("connect@")) {
                    output.writeUTF("getPort@");
                }
                Integer port = input.readInt();
                if (Server.chatMap.containsKey(port) == false) {
                    System.out.println("Initialize chat " + port);
                    Chat chat = new Chat(port);
                    chat.start();
                    Server.chatMap.put(port, chat);
                }
                output.writeUTF("opened@");
                output.flush();
                System.out.println("test");
                break;

            } catch (Exception e) {
                ServerUI.getInstance().updateTable();
                break;
            }
        }
    }
}