import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import uk.ac.leedsbeckett.oop.TurtleGraphics;

@SuppressWarnings("serial")
public class TurtleSystemTest extends TurtleGraphics{
		public TurtleSystemTest() {
		        JFrame MainFrame = new JFrame();                //create a frame to display the turtle panel on
		        MainFrame.setLayout(new FlowLayout());      //not strictly necessary
		        MainFrame.add(this);                                        //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
		        MainFrame.pack();                                           //set the frame to a size we can see
		        MainFrame.setVisible(true);                         //now display it
		        //about();                                                            //call the TurtleGraphics about method to display version information.
		        turnLeft(90);
				penDown();
				//System.out.println(getDirection());
		}


		public void processCommand(String command) {     //this method must be provided because TurtleGraphics will call it when it's JTextField is used
				String[] split = command.split(" ");
		    	String mainCommand = new String();
		        int parameter;
		        
		        if(split.length == 1)  
			        	switch(command) {
			        	//case "reset": resetCentre();
			       		//break;
			        	case "about":about();
				    	break;
			        	case "Reset":reset(); 			// Fix reset to face turtle down
			        	break;
				    	case "New": clear2();
			        	break;  
				    	case "save": save();
				    	break;
				    	//case "load": load();
				    	//break;
				    	case "Pendown":penDown();
				    	break;
			        	case "Penup":penUp();
			        	break;    	
				    	case "turnleft":turnLeft(90);
			        	break;
			        	case "turnright":turnRight(90);
				    	break;
			        	case "circle" : circle(getGraphicsContext());
			        	break;
					    /* case "forward":forward(100);
					    break;
					    case "backward":
					    {
					    turnRight(180);
					    forward(100);
					    turnRight(180);
					    }
					    break; */    	
			        	case "Black":setPenColour(Color.black);
			        	break;	
				    	case "White":setPenColour(Color.white);
			        	break;
			        	case "Red":setPenColour(Color.red);
				    	break;
			        	case "Green":setPenColour(Color.green);
			        	break;
				    	case "Blue":setPenColour(Color.blue);
			        	break;
			        	case "Pink":setPenColour(Color.pink);
				    	break;   	
			        	default:System.out.println("Invalid Command!");
			        	}    
			    
			        
			    while (withinBound()) {
			        if(split.length == 2) {
				        	mainCommand = (split[0]);
				        	parameter = Integer.parseInt(split[1]);
				        	
				        	switch(mainCommand) {
					        case "turnleft":turnLeft(parameter);
					        break;
					        case "turnright":turnRight(parameter);
					        break;
					        case "forward":forward(parameter);
					        break;
					        case "backward": backward(parameter);
					        break;	
					        default:System.out.println("Invalid Command2!"); 	//Rename to Invalid Command when done
				        	}
				    }
			    }    
		}

		public void save() {
		    	try {
		        BufferedImage bi = getBufferedImage();
		        File outputfile = new File("saved.png");
		        ImageIO.write(bi, "png", outputfile);
		        } catch (IOException e) {
			    System.out.println("Exception occured :" + e.getMessage());
		        }
		    	System.out.println("Images were written succesfully.");
		}
		
		/* public void load() {
		    	BufferedImage img = null;
		    	try {
		    	img = ImageIO.read(new File("C:/Users/aryan/eclipse-workspace/saved.png")); // eventually C:\\ImageTest\\pic2.jpg
		    	} 
		    	catch (IOException e) {
		    	e.printStackTrace();
		    	}
		} */
		
		public void about() {
				for (int i = 0; i < 50; i++)
				{
		    	forward(5*i);
		    	turnRight(90);
				}
				//System.out.println("After about: " + getDirection());
		}
		
		public void circle(Graphics g) {
				g = getGraphicsContext();
				g.setColor(Color.green);
				g.drawOval(350,50,300,300);
		}
		
		public void reset() {
		    	setxPos(500);
		    	setyPos(200);
		    	
		    	switch(getDirection()) {
		    	case 0: turnRight(90);		//right
		    	break;
		    	case 180: turnRight(270);	//left
		    	break;
		    	case 270: turnRight(180); 	//up
		    	break;
		    	case -90: turnRight(180); 	//up
		    	break;
		    	
		    	default:
		    	}
			
		}
		
		public void clear2() {
				clear();
				setBackground_Col(Color.white);
		}
		
		public void backward(int parameter) {
		    	turnRight(180);
			    forward(parameter);
			    turnRight(180);
		}
		
		public boolean withinBound() {
				if (getxPos() > 1000 || getxPos() < 0 || getyPos() > 400 || getyPos() < 0) {
						return false;
				}
				
				else
				{
						return true;
				}
				
		}
}