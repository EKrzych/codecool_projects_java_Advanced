# NetChat project

## Requirements

- Command signature should look in a following way: java NetChat mode [address] port
- Application should have to modes: client, server.
- Application should allow bi-directional communication between server and client.
- Application should use TCP protocol.
- Communication should be done through exchanging Message objects not Strings.
- Message class has to be left unchanged. (You may temporary change it for debugging purposes).
- Application shoul use serialization
- When a client disconnects from a server, server should wait for the next client.
- When a server disconnects, client should be turned off gracefully.