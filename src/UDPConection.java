import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import model.Comida;

public class UDPConection extends Thread {
	
	private DatagramSocket socket;
	private Main main;
	private OnMessageListener observer;
	
	
	public void setObserver (Main main) {
		this.main = main;
	}
 
    public void run () {

        try {
            socket = new DatagramSocket(5001);

            while (true) {

                byte[] buffer = new byte[100];

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("WAITIIIING");
                
                socket.receive(packet);

                String mensaje = new String(packet.getData()).trim();
                System.out.println(mensaje);
                
                Gson gson = new Gson();
                
                Comida food = gson.fromJson(mensaje, Comida.class);
                
                
                
               
                
                
                
                
                
                
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public void setObserver (OnMessageListener observer) {
    	this.observer = observer;
    }

    public void sendMessage (String mensaje) {
        new Thread (
        		() -> {
        			try {
						InetAddress ip = InetAddress.getByName("127.0.0.1");
						DatagramPacket packet = new DatagramPacket (mensaje.getBytes(), mensaje.getBytes().length, ip, 6001);
						socket.send(packet);
						System.out.println("MANDEMFK");
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		).start();
    }
    
    

}
