
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Comida;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements OnMessageListener {
	
	private PImage burrito;
	private PImage burger;
	private PImage hotDog;
	private PImage pizza;
	private UDPConection udp;
	private Comida food;
	private String miComida;
	private ArrayList <Comida> comidas;  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");

	}
	
	public void settings () {
		size (700,700);
		
	}
	
	public void setup () {
		
		burrito = loadImage("img/burrito.jpg");
		burger = loadImage ("img/hamburguesa.jpg");
		hotDog = loadImage ("img/hotdog.jpg");
		pizza = loadImage ("img/pizza.jpg");
		
		comidas = new ArrayList <Comida> ();
		
		
		udp = new UDPConection ();
		udp.start();
		
		udp.setObserver(this);
		
		
		 try {
             InetAddress n = InetAddress.getLocalHost();
             String ip = n.getHostAddress();
             System.out.println(ip);

         } catch (UnknownHostException e) {
             e.printStackTrace();
         }
		
		 food = new Comida ();
		
		
		
	}
	
	public void draw() {
		background (255);
		
		for (int i =0; i<comidas.size(); i++) {
		Comida comida = comidas.get(i);
		System.out.println(comida);
			if (comida.getType().equals("burrito")) {
				image (burrito, 0, 0, 50, 50);
				ellipse(100, 100, 50, 50);
			}
		}
		
		
		
				
	}
	
	public void mousePressed () {
		udp.sendMessage("ENVIO");
	}


	@Override
	public void recibirMensaje(Comida comida) {
		// TODO Auto-generated method stub
		comidas.add(comida);
		
	}

}
