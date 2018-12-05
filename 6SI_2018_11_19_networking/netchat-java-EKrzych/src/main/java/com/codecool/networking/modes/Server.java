package com.codecool.networking.modes;

import com.codecool.networking.data.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Server extends Thread {
    private Socket socket;
    private String name;

    public Server(Socket socket, String name) {
        this.name = name;
        this.socket = socket;
    }

    public void run() {


        try (
                SocketChannel socketChannel = SocketChannel.open(socket.getLocalSocketAddress());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


        ) {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));


            Message message = new Message("HI", name);

//            objectOutputStream.writeObject(message);
//            objectOutputStream.flush();

            Message fromUser;
            String fromServer;

            while ((fromUser = (Message) objectInputStream.readObject()) != null) {
                System.out.println(fromUser);
                if (fromUser.getContent().equalsIgnoreCase("Bye.")) {
                    break;
                }
                System.out.print("Provide message: ");
                fromServer = stdIn.readLine();
                if (fromServer != null) {
                    message = new Message(fromServer, name);

                    //objectOutputStream.writeObject(message);
                }
            }
            socket.close();
        } catch (EOFException | SocketException e) {
            System.out.println("Someone has disconnectted!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
