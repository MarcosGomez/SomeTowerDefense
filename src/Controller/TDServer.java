package Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

import Model.Tile;
import command.Command;
import command.DisconnectCommand;
import command.UpdateClientCommand;




public class TDServer {
	private ServerSocket socket;
	private int port;
	private Vector<Vector<Tile>> map1;
	private Vector<Vector<Tile>> map2;
	private int masterBaseHP;
	private HashMap<String, ObjectOutputStream> outputs; // map of all connected
															// users' output
															// streams
	private boolean player1Connected;
	private boolean player2Connected;
	private String player1Name;
	private String player2Name;

	/**
	 * Constructor for NPServer. Creates a new ServerSocket on port 4007 and
	 * then creates a new thread to accept clients.
	 */
	public TDServer() {
		port = 4444;
		map1 = new Vector<Vector<Tile>>();
		map2 = new Vector<Vector<Tile>>();
		outputs = new HashMap<String, ObjectOutputStream>();
		player1Connected = false;
		player2Connected = false;

		try {
			socket = new ServerSocket(port);
			System.out.println("Server up on port " + port);

			new Thread(new ClientAccepter()).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This thread listens for and sets up connections to new clients.
	 */
	private class ClientAccepter implements Runnable {
		public void run() {
			try {
				while (true) {
					Socket client = socket.accept();
					if(!(player1Connected && player2Connected)){
						// accept a new client, get output & input streams
						
						System.out.println("Client accepted");
						ObjectInputStream fromClient = new ObjectInputStream(
								client.getInputStream());
						ObjectOutputStream toClient = new ObjectOutputStream(
								client.getOutputStream());

						// read the client's name
						String clientUsername = (String) fromClient.readObject();

						// map client name to output stream
						outputs.put(clientUsername, toClient);

						// spawn a thread to handle communication with this client
						new Thread(new ClientHandler(fromClient)).start();
						
						System.out.println("Added new client" + ((player1Connected) ? "(Player2)": "(Player1)")+ ": " + clientUsername );
						if(!player1Connected){
							player1Connected = true;
							player1Name = clientUsername;
						}else{
							player2Connected = true;
							player2Name = clientUsername;
						}
					}else{
						System.out.println("Sorry, you cannot join at this time. This game already has 2 players");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This thread reads and executes commands sent by a client.
	 */
	private class ClientHandler implements Runnable {
		private ObjectInputStream input; // the input stream from the client

		public ClientHandler(ObjectInputStream input) {
			this.input = input;
		}

		public void run() {
			try {
				updateClients();
				while (true) {
					// read a command from the client, execute on the server
					Command command = (Command) input
							.readObject();
					command.serverExecute(TDServer.this);

					// terminate if client is disconnecting
					if (command instanceof DisconnectCommand) {
						input.close();
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//	public void addShapes(Shapes shapes) {
//		masterList.add(shapes);
//		updateClients();
//	}
	/**
	 * Sends the command to all other clients except for itself
	 * 
	 * @param command  the command to be sent
	 */
	public void transferCommand(Command command){
		for(String username: outputs.keySet()){
			if(!command.getSender().equals(username)){
				try {
					outputs.get(username).writeObject(command);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void updateClients() {
		// make an UpdateClientCommmand, write to all connected users
		UpdateClientCommand update = new UpdateClientCommand("?");
		try {
			for (ObjectOutputStream out : outputs.values())
				out.writeObject(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect(String clientName) {
		try {
			outputs.get(clientName).close(); // close output stream
			outputs.remove(clientName); // remove from map

			// add notification message
			System.out.println(clientName + " disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(clientName.equals(player1Name)){
			player1Connected = false;
			player1Name = null;
		}else{
			player2Connected = false;
			player2Name = null;
		}
		
		
	}
	
	public void masterHealthTakeDamage(int amountDamaged){
		masterBaseHP -= amountDamaged;
		shareBaseHP();
	}
	
	private void shareBaseHP(){
		
	}

	public static void main(String[] args) {
		new TDServer();
	}

}
