import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket sock;
		Scanner sc = new Scanner(System.in);
		DataOutputStream salida;
		String mensaje;
		InetAddress ip;
		int puerto;
		
		
		System.out.println("Elije el puerto que vas a usar");
		puerto = sc.nextInt();
		sc.nextLine();
		Boolean parar = true;
		
		try {
			ip = InetAddress.getByName("localhost");
			sock = new Socket(ip,puerto);
			System.out.println(sock);
			salida = new DataOutputStream(sock.getOutputStream());
			while(parar){
				System.out.println("Que mensaje quieres enviar?");
				mensaje = sc.nextLine();
				salida.writeUTF(mensaje);
				
				if(mensaje.toLowerCase().equals("parar")) {
					parar = false;
					sock.close();
				}
					
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
