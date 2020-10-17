
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Comida;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
	
	private PImage burrito;
	private PImage burger;
	private PImage hotDog;
	private PImage pizza;
	private UDPConection udp;
	private Comida food;
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
		comidas.add(new Comida ("burrito"));
		comidas.add(new Comida ("pizza"));
		comidas.add(new Comida ("burger"));
		comidas.add(new Comida ("hotdog"));
		
		udp = new UDPConection ();
		udp.start();
		
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
		
		
		
				
	}
	
	public void mousePressed () {
		udp.sendMessage("ENVIO");
	}
	
	public void recibir () {
		
	}

}
