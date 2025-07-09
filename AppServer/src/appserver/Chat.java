package appserver;

import java.util.List;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Chat extends Thread {
    private List<ClientHandler> clients;
    private ServerSocket serverSocket;
    private int port;
    private int clientCount;

    public Chat(int port) throws IOException {
        clients = new ArrayList<>();
        clientCount = 0;
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Cannot open server");
        }
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                clientCount++;
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " in chat " + this.port);
                ServerUI.getInstance().updateTable();
                ClientHandler client = new ClientHandler(socket, output, input, this);
                clients.add(client);
                client.start();

            } catch (Exception e) {

            }

        }

    }

    public void sendToAllClient(String msg, ClientHandler except) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler != except)
                clientHandler.sendMessage(msg);
        }
    }

    public int getPort() {
        return port;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void decreaseCount() {
        clientCount--;
        ServerUI.getInstance().updateTable();
    }

    public void checkDestroy() {
        if (clientCount == 0) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Cannot close chat server");
            }
            Server.chatMap.remove(port);
            ServerUI.getInstance().updateTable();
            this.interrupt();
        }
    }
}

class ClientHandler extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Chat chat;

    public ClientHandler(Socket socket, DataOutputStream outputStream, DataInputStream inputStream, Chat chat)
            throws IOException {
        this.input = inputStream;
        this.output = outputStream;
        this.socket = socket;
        this.chat = chat;
    }

    public void run() {
        while (true) {
            try {
                String str = input.readUTF();
                chat.sendToAllClient(str, this);
            } catch (Exception e) {

                if (chat != null) {
                    chat.decreaseCount();
                    chat.checkDestroy();
                }
                break;
            }
        }
    }

    public void sendMessage(String msg) {
        try {
            output.writeUTF(msg);
        } catch (IOException e) {
            System.out.println("Cannot send message from server to client");
        }
    }
}