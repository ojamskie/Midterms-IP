import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;


public class Hero{

	public int x = 30;
	public int y = 30;
	public int height;
	public int width;

	public BufferedImage image;
	public URL resource = getClass().getResource("run0.png");

	public int state = 0;

	public Draw draw;

	public Hero(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	

	public Hero(int xPass, int yPass, Draw draw){
		x = xPass;
		y = yPass;
		this.draw = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		width = image.getWidth();
		height = image.getHeight();
	}

	public Rectangle heroCollision(){
		return(new Rectangle(x, y, width, height));
	}

	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        draw.repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void attack(){
		attackAnimation();
		bothCollision();
	}

	public void moveUp(){
		y = y - 5;
		reloadImage();
		draw.repaint();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		draw.repaint();
	}

	public void moveLeft(){
		x = x - 5;
		reloadImage();
		draw.repaint();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		draw.repaint();
	}

	public void bothCollision(){
		if(heroCollision().intersects(draw.monster1.monsterCollision())){
			draw.monster1.hp -= 5;
		}
	}
}