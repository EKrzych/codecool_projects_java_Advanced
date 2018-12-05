package com.codecool.networking;

import com.codecool.networking.modes.Client;
import com.codecool.networking.modes.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class NetChat {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        if(args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "client":
                    handleClientMode(args);
                    break;

                case "server":
                    handleServerMode(args);
                    break;

                default:
                    System.err.println("Incompatible mode, use: server or client");
                    System.exit(1);

            }
        } else {
            System.err.println("Try again - Command signature should look in a following way: java NetChat mode [address] port");
            System.exit(1);
        }
    }

    private static void handleClientMode(String[] args) {
        if (args.length != 3) {
            System.err.println(
                    "Usage: java NetChat mode [address] port");
            System.exit(1);
        }


        String hostName = args[1];
        int portNumber = Integer.parseInt(args[2]);
        String author = getName();
        try {
            new Client(hostName, portNumber,author).talk();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void handleServerMode(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java NetChat mode port");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[1]);
        boolean listening = true;
        String author = getName();

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new Server(serverSocket.accept(), author).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);

            System.exit(-1);
        }
    }

    private static String getName() {
        System.out.println("What's your name?: ");
        return reader.nextLine();
    }
}
