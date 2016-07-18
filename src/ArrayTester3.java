/*
 *  I have provided you with some working code. With a partner, look though
 *  the code to determine what is happening. Document your findings within the
 *  code. We will make MANY changes to this and it is important to know what is
 *  happening before we do.
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;

import javax.swing.Timer;

public class ArrayTester3 extends Applet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//**********************************************************************************
	//Used for double buffering purposes. Double buffering eliminates screen flickering. 
	//Drawing all of the circles to the display causes a "lag" and flickering occurs. 
	//Double buffering is a method where all of the circles are "drawn" before they
	//are displayed to the screen
	
	private Image backbuffer;
	private Graphics2D g2d;
	//**********************************************************************************
	
	
	private final int DELAY = 1000/20; //100
	private final int MAXSIZE = 4; //4
	private final int MAXCIRCLES = 100000/5; //100000
	private final int MAXVELOCITY = 15;

	private Particle[] allParticles;

	public void init() 
	{

		this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		//****************************************************************
		//This will be used for demo purposes. If you uncomment these lines
		//comment out the corresponding lines in the paint method
		backbuffer = createImage(getSize().width, getSize().height);
		g2d = (Graphics2D) backbuffer.getGraphics();
		//****************************************************************

		this.setBackground(Color.black);
		
		allParticles = new Particle[MAXCIRCLES];

		for(int count = 0;count < MAXCIRCLES; count++)
		{
			resetCircle(count);
		}

		//I needed this to use "repaint" the screen. It users a timer which calls an ActionListener
		ActionListener taskPerformer = new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				repaint();
			}
		};

		new Timer(DELAY, taskPerformer).start();
	}

	private void resetCircle(int index)
	{
		
		allParticles[index] = new Particle(this.getWidth() / 2,
										this.getHeight() / 2,
										(int)(Math.random()*2*MAXVELOCITY-MAXVELOCITY),
										(int)(Math.random()*2*MAXVELOCITY-MAXVELOCITY),
										(int)(Math.random()*MAXSIZE),
										randomColor());
		
		//This method does...?
		/*y[index] = this.getHeight() / 2;
		x[index] = this.getWidth() / 2;
		xvelocity[index] = (int)(Math.random()*2*MAXVELOCITY-MAXVELOCITY);
		yvelocity[index] = (int)(Math.random()*2*MAXVELOCITY-MAXVELOCITY);
		size[index] = (int)(Math.random()*MAXSIZE);	
		colors[index] = randomColor();*/
	}

	public Color randomColor()
	{
		//int value = (int)(Math.random()*5);

		/*if(value==0)
			return Color.blue;
		else if(value==1)
			return Color.red;
		else if(value==2)
			return Color.green;
		else if(value==3)
			return Color.magenta;
		else
			return Color.pink;*/
		return new Color((int) (Math.random()*256),
						(int) (Math.random()*256),
						(int) (Math.random()*256));

	}
	

	public void update(Graphics g) 
	{ 
		paint(g); 
	} 

	public void paint(Graphics g) 
	{	
		//****************************************************************
		//This will be used for demo purposes. If you comment these lines
		//uncomment out the corresponding lines in the init method
		
		backbuffer = createImage(getSize().width, getSize().height);
		g2d = (Graphics2D)backbuffer.getGraphics();
		//****************************************************************
		
		Ellipse2D circle;

		for(int count = 0;count < MAXCIRCLES; count++)
		{
			
			allParticles[count].updateY();
			allParticles[count].updateX();

			if(allParticles[count].getMyY()>this.getHeight()  || allParticles[count].getMyY()<0)
			{
				//yvelocity[count]=-yvelocity[count];
				this.resetCircle(count);
			}

			if(allParticles[count].getMyX()>this.getWidth()  || allParticles[count].getMyX()<0)
			{
				//xvelocity[count]=-xvelocity[count];
				this.resetCircle(count);
			}
			
			g2d.setPaint(allParticles[count].getMyColor());	
			circle = new Ellipse2D.Double(allParticles[count].getMyX(), allParticles[count].getMyY(), allParticles[count].getMySize(), allParticles[count].getMySize());	
			g2d.fill(circle);



		}

		//Copy the "undisplayed" screen to the active display
		g.drawImage(backbuffer, 0, 0, null);
	}
}



