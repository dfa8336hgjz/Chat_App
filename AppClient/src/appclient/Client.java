package appclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends Thread {
    private int port;
    private String username;
    private DataInputStream chatInput;
    private DataOutputStream chatOutput;
    private DataInputStream input;
    private DataOutputStream output;
    private Socket chatClient;
    private Socket mainClient;

    public Client() throws UnknownHostException, IOException {
        mainClient = new Socket("localhost", 12345);
        input = new DataInputStream(mainClient.getInputStream());
        output = new DataOutputStream(mainClient.getOutputStream());
        System.out.println("Connected to main server");
    }

    @Override
    public void run() {
        try {
            connecting();
            mainClient.close();
            input.close();
            output.close();

            chatClient = new Socket("localhost", port);
            System.out.println("Connected to chat");

            chatInput = new DataInputStream(chatClient.getInputStream());
            chatOutput = new DataOutputStream(chatClient.getOutputStream());
            while (true) {
                String str = chatInput.readUTF();
                ClientUI.instance.addMessage(str);
            }

        } catch (IOException | InterruptedException e) {
            try {
                chatInput.close();
                chatOutput.close();
                chatClient.close();
            } catch (IOException e1) {
                System.out.println("Cannot delete client");
            }
        }
    }

    public synchronized void connecting() throws IOException, InterruptedException {
        while (true) {
            output.writeUTF("connect@");
            String str = input.readUTF();
            if (str.equals("getPort@")) {
                wait();
                output.writeInt(port);
            }
            if (str.equals("opened@")) {
                System.out.println("break");
                break;
            }
        }
    }

    public synchronized void continueThread() {
        notify();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void sendMessageToServer(String msg) throws IOException {
        String str = username + ": " + msg + "\n";
        chatOutput.writeUTF(str);
        ClientUI.instance.addMessage(str);
    }

}