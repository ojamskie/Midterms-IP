import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

  Draw drawing;
  Hero hero;

  public MyFrame(){
    this.drawing = new Draw();
    this.hero = drawing.hero1; 
  }

  public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_UP){
      hero.moveUp();
      System.out.println("pos: " + hero.x + ", " + hero.y);
    }
    else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      hero.moveRight();
      System.out.println("pos: " + hero.x + ", " + hero.y);
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
      hero.moveDown();
      System.out.println("pos: " + hero.x + ", " + hero.y);
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
      hero.moveLeft();
      System.out.println("pos: " + hero.x + ", " + hero.y);
    }
    else if(e.getKeyCode() == KeyEvent.VK_A){
      hero.attack();
      System.out.println("attack");
    }
  }

  public void keyReleased(KeyEvent e){

  }

  public void keyTyped(KeyEvent e){
    
  }

  public static void main(String args[]){
    MyFrame gameFrame = new MyFrame();
    gameFrame.setSize(600,600);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setVisible(true);
    gameFrame.getContentPane().add(gameFrame.drawing);
    gameFrame.addKeyListener(gameFrame);
    System.out.println("Gaming");
  }
}