import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Hilo extends Thread{
	
	 String nombre;
	 Socket sock;
	 DataInputStream entrada;

	public Hilo(Socket sock, String nombre) {
		this.sock = sock;
		this.nombre = nombre;
	}
	
	public void run() {
		String mensaje;
		Boolean parar = false;
		
		try {
			entrada = new DataInputStream(sock.getInputStream());
			System.out.println("Se ha conectado " + sock);
			
			do {
				mensaje = entrada.readUTF();
				System.out.println(nombre+" dice: "+mensaje);
				
				if(mensaje.toLowerCase().equals("parar")) {
					System.out.println("Adios "+nombre);
					parar = true;
				}
			}while(!parar);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
