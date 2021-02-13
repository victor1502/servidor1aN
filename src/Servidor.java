import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ServerSocket servidor;
		 Socket sock;
		 Scanner sc = new Scanner(System.in);
		 Boolean parar = true;
		 int puerto;
		 int numeroCliente = 0;
		 String nombre;
		 
		 System.out.println("En que puerto quieres trabajar?");
		 puerto = sc.nextInt();
		 sc.nextLine();
		 
		 try {
			servidor = new ServerSocket(puerto);
			
			while(true) {
				numeroCliente++;
				nombre = "Cliente "+numeroCliente;
				sock = servidor.accept();
				Hilo h1 = new Hilo(sock,nombre);
				h1.start();
			}
			/*Thread hilo = new Thread(h1);
			hilo.start();*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
