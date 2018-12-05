package com.codecool.networking.modes;

import com.codecool.networking.data.Message;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    String hostName;
    int portNumber;
    String author;

    public Client(String hostName, int portNumber, String author) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.author = author;
    }

    public void talk() throws ClassNotFoundException {

        try (
                Socket socket = new Socket(hostName, portNumber);
                SocketChannel socketChannel = SocketChannel.open(socket.getLocalSocketAddress());
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


        ) {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            Message fromServer;
            String fromUser;

            while ((fromServer = (Message) socketChannel.) != null) {
                System.out.println(fromServer);
                if (fromServer.getContent().equalsIgnoreCase("Bye."))
                    break;
                System.out.print("Provide message: ");
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    Message message = new Message(fromUser, author);
                    ByteBuffer buffer = ByteBuffer.wrap(message.toString().getBytes());
                    socketChannel.write(buffer);
                    buffer.clear();
                   // objectOutputStream.writeObject(message);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
