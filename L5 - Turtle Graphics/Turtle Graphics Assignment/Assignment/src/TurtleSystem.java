import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.TurtleGraphics;

@SuppressWarnings("serial")
public class TurtleSystem extends TurtleGraphics implements ActionListener {
		
		//BufferedImage img;
		boolean save = false;
		public JFileChooser chooser;
		
	
		/* JMenuBar menuBar;
		JMenu colourMenu;
		JMenuItem White;
		JMenuItem Green; */
		
		/* public void menuBarMethod() {
			menuBar.add(colourMenu);
			colourMenu.add(White);
			colourMenu.add(Green);
		} */
	
		public TurtleSystem() {
		        JFrame MainFrame = new JFrame();                
		        MainFrame.setLayout(new FlowLayout());     
		        MainFrame.add(this);                                        
		        MainFrame.pack(); 
		        MainFrame.setVisible(true);
		        MainFrame.setResizable(false);
		        //MainFrame.setSize(1025,472);
		        MainFrame.setTitle("Turtle Graphics v2.0 [Aryan Prince]");
		        this.chooser = new JFileChooser();
		        
		        /* MainFrame.setJMenuBar(menuBar);
		        menuBar = new JMenuBar(); 
		        colourMenu = new JMenu("Colour"); menuBar.add(colourMenu);
		        White = new JMenuItem("White"); White.addActionListener(this); colourMenu.add(White);
		        Green = new JMenuItem("Green"); Green.addActionListener(this); colourMenu.add(Green);
		        menuBarMethod(); */
		        
		        setTurtleImage("C:\\Users\\aryan\\Downloads\\Turtle.png");
		        turnLeft(90);
				penDown();
				displayMessage("Welcome to Turtle Graphics!");
		}
		
		/* public void actionPerformed(ActionEvent e) {
			if(e.getSource() == White) {
				forward(100);
			}
		} */
		
		public void processCommand(String command) {     
				String[] split = command.split(" ");
		    	String mainCommand = new String();
		        int parameter, parameterRed, parameterGreen, parameterBlue;
		        
		        if(split.length == 1)  
			        	switch(command) {
			        	case "about":about(); displayMessage("Current command: about");
				    	break;
			        	case "superabout": super.about(); displayMessage("Current command: super.about");
			        	break;
			        	case "getdir":displayMessage("Current direction: " + getDirection());
			        	break;
			        	case "Reset":reset(); displayMessage("Current command: Reset");			
			        	break;
				    	case "New": setBackground_Col(Color.black); clear(); displayMessage("Current command: New");
			        	break;  
				    	case "clearall": reset(); setBackground_Col(Color.black); clear(); displayMessage("Current command: clearall");
				    	break;
				    	case "newall": reset(); setBackground_Col(Color.black); clear(); displayMessage("Current command: newall");
				    	break;
				    	case "resetall": reset(); setBackground_Col(Color.black); clear(); displayMessage("Current command: resetall");
				    	break;
				    	case "save": save(); displayMessage("Image has been saved succesfully!");
				    	break;
				    	case "load": 
				    		{
					    			if (save == true) {
					    				load(); 
						    			displayMessage("Image was loaded succesfully.");
						    			break;
					    			}
					    			
					    			else {
					    				displayMessage("You must save before loading!!");
					    				break;
					    			}
				    			
				    		}
				    	case "Pendown":penDown(); displayMessage("Current command: Pendown");
				    	break;
			        	case "Penup":penUp(); displayMessage("Current command: Penup");
			        	break;    	
				    	case "turnleft":turnLeft(90); displayMessage("Current command: turnleft");
			        	break;
			        	case "turnright":turnRight(90); displayMessage("Current command: turnright");
				    	break;
			        	case "circle" : circle(getGraphicsContext()); displayMessage("Current command: circle");
			        	break;
			        	case "pattern1": pattern1(); displayMessage("Current command: pattern1");
			        	break;
			        	case "octagon": octagon(); displayMessage("Current command: octagon");
			        	break;
			        	case "pentagon": pentagon(); displayMessage("Current command: pentagon");
			        	break;
					    case "forward": displayMessage("forward() requires a parameter!!");
					    break;
					    case "backward": displayMessage("backward() requires a parameter!!");
					    break;   	
			        	case "Black":setPenColour(Color.black); displayMessage("Changed color to: Black");
			        	break;	
				    	case "White":setPenColour(Color.white); displayMessage("Changed color to: White");
			        	break;
			        	case "Red":setPenColour(Color.red); displayMessage("Changed color to: Red");
				    	break;
			        	case "Green":setPenColour(Color.green); displayMessage("Changed color to: Green");
			        	break;
				    	case "Blue":setPenColour(Color.blue); displayMessage("Changed color to: Blue");
			        	break;
			        	case "Pink":setPenColour(Color.pink); displayMessage("Changed color to: Pink");
				    	break;   	
			        	case "Yellow":setPenColour(Color.yellow); displayMessage("Changed color to: Yellow");
				    	break;
			        	case "Magenta":setPenColour(Color.magenta); displayMessage("Changed color to: Magenta");
				    	break;
			        	case "Orange":setPenColour(Color.orange); displayMessage("Changed color to: Orange");
				    	break;
			        	default:displayMessage("Invalid Command!!"); 
			        	}    
			    
			        
			    if(split.length == 2) {
			        	mainCommand = (split[0]);
			        	
			        	if (split[1].matches("^[0-9]*$")) { 
		        		parameter = Integer.parseInt(split[1]);
				        		
        				if (parameter > 1000) {
        				displayMessage("Invalid parameter: Integers over 1000 not allowed!!");
		        		}
        		
		        		else {
	        			switch(mainCommand) {
				        case "turnleft":turnLeft(parameter); displayMessage("Current command: turnLeft "+parameter+" degrees");
				        break;
				        case "turnright":turnRight(parameter); displayMessage("Current command: turnRight "+parameter+" degrees");
				        break;
				        case "forward":forward(parameter); displayMessage("Current command: forward "+parameter+"px");
				        break;
				        case "backward": backward(parameter); displayMessage("Current command: backward "+parameter+"px");
				        break;	
				        case "circle": circle(parameter); displayMessage("Current command: circle of diameter "+parameter);
				        break;
				        default:displayMessage("Invalid Command!!"); 	
			        	}
		        		}
			        	
			        	}
			        	
			        	else {
        				displayMessage("Invalid parameter: Only positive integers allowed!!");
			        	}
			    }   
			    
			    if(split.length == 4) {
			    		mainCommand = (split[0]);
			    		parameterRed = Integer.parseInt(split[1]);
			    		parameterGreen = Integer.parseInt(split[2]);
			    		parameterBlue = Integer.parseInt(split[3]);
			    		
			    		float[] hsbvals = {0,0,0};
			    		hsbvals = Color.RGBtoHSB(parameterRed, parameterGreen, parameterBlue, hsbvals);
			    		
			    		switch(mainCommand) {
				        case "colour":setPenColour(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2])); displayMessage("Custom colour has been set"); 
				        break;
				        case "color":setPenColour(Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2])); displayMessage("Custom color has been set"); 
				        break;
				        default: displayMessage("Invalid Command!!"); 
			    		}
			    }
		}

		
		
		public void about() {
				for (int i = 0; i < 50; i++)
				{
		    	forward(5*i);
		    	turnRight(90);
				}
		}
		
		public void reset() {
		    	setxPos(500);
		    	setyPos(200);
		    	
		    	switch(getDirection()) {
		    	case 0:   turnRight(90);	//right
		    	break;
		    	case 18:  turnRight(72); 	//pentagon
		    	break;
		    	case 288: turnRight(72+90); //pentagon
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
		
		public void circle(int radius) {
				Graphics g = getGraphicsContext();
				g.setColor(Color.green);
				g.drawOval(getxPos(),getyPos(),radius,radius);
		}
		
		public void circle(Graphics g) {
				g = getGraphicsContext();
				g.setColor(Color.green);
				g.drawOval(350,50,300,300);
		}
		
		public void backward(int parameter) {
		    	turnRight(180);
			    forward(parameter);
			    turnRight(180);
		}
		
		public void save() {
		    	save = true;
		    	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    	chooser.setDialogTitle("Save a File");
		    	int status = chooser.showSaveDialog(null);
		    	if (status != JFileChooser.APPROVE_OPTION) {
		    		
		    	}
		    	else {
			    		try {
			    			File outputFile = chooser.getSelectedFile();
			    			ImageIO.write(getBufferedImage(), "png", outputFile);
			    		} 
			    		catch (IOException e) {
			    			
			    		}
		    	}
		}
	
		public void load() {
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setDialogTitle("Open a File");
				int status = chooser.showOpenDialog(null);
				if (status != JFileChooser.APPROVE_OPTION) {
					
				}
				else {
						File inputFile = chooser.getSelectedFile();
						try {
								BufferedImage img = ImageIO.read(inputFile);
								setBufferedImage(img);
						}
						catch (IOException e) {
							
						}
				}
					
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
		
		public void pattern1() {
			//setxPos(450);
			//setyPos(200);
			setPenColour(Color.yellow);
			turnLeft(90);
			for (int i = 0; i < 8; i++) {
			    turnLeft(45);
			    for (int j = 0; j < 8; j++) {
			        forward(50);
			        turnLeft(45);
			    }    
			}        
		}
		
		public void octagon() {
			setxPos(450);
			setyPos(80);
			turnLeft(90);
			setPenColour(Color.magenta);
			
			for (int j = 0; j < 8; j++) {
		        forward(100);
		        turnRight(45);
		    }
		}    
		
		public void pentagon() {
			setxPos(450);
			setyPos(80);
			turnLeft(72);
			setPenColour(Color.blue);
			
			for (int j = 0; j < 5; j++) {
				forward(150);
				turnRight(72);
		    }
		}
}

//Not Asked For
// 1. Custom commmands - Circle, Octagon, Pentagon, pattern1
// 2. Basic commands - TurnRight and TurnLeft work with/without parameters, super.about
// 3. More pen color commands
// 4. Window - cannot be resized, custom title name