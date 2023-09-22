package ie.atu.sw;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MorseWindow {
	private Colour[] colours = Colour.values(); 
	private ThreadLocalRandom rand = ThreadLocalRandom.current(); 
	private JFrame win; //The GUI Window
	private JTextArea txtOutput = new JTextArea(); 
	private JTextField txtFilePath; 
	private Morse morse;
	
	public MorseWindow(){
		
		win = new JFrame();
		morse = new Morse();
		win.setTitle("Data Structures & Algorithms 2023 - Morse Encoder/Decoder");
		win.setSize(650, 400);
		win.setResizable(false);
		win.setLayout(new FlowLayout());
		
        /*
         * The top panel will contain the file chooser and encode / decode buttons
         */
        var top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Select File"));
        top.setPreferredSize(new Dimension(600, 80));

        txtFilePath =  new JTextField(20);
		txtFilePath.setPreferredSize(new Dimension(100, 30));

		
		var chooser = new JButton("Browse...");
		chooser.addActionListener((e) -> {
			var fc = new JFileChooser(System.getProperty("user.dir"));
			var val = fc.showOpenDialog(win);
			if (val == JFileChooser.APPROVE_OPTION) {
				var file = fc.getSelectedFile().getAbsoluteFile();
				txtFilePath.setText(file.getAbsolutePath());
			}
		});
		
		var btnEncodeFile = new JButton("Encode");
		btnEncodeFile.addActionListener(e -> {
			  FileReader fr;
			  String result = "";
		try {
				fr = new FileReader(txtFilePath.getText());
				BufferedReader br=new BufferedReader(fr);
				int i;    
		          while((i=br.read())!=-1){  
		        	  result+=(char)i;  
		          }  
		          br.close();    
		          fr.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}   
	          
			replaceText(morse.encodeString(result));

			
		});
		
		var btnDecodeFile = new JButton("Decode");
		btnDecodeFile.addActionListener(e -> {
			
			replaceText("Decoding....." + morse.decode(txtOutput.getText()));
		});
		
		//Add all the components to the panel and the panel to the window
        top.add(txtFilePath);
        top.add(chooser);
        top.add(btnEncodeFile);
        top.add(btnDecodeFile);
        win.getContentPane().add(top); //Add the panel to the window
        
        
        /*
         * The middle panel contains the coloured square and the text
         * area for displaying the outputted text. 
         */
        var middle = new JPanel(new FlowLayout(FlowLayout.LEADING));
        middle.setPreferredSize(new Dimension(600, 200));

        var dot = new JPanel();
        dot.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        dot.setBackground(getRandomColour());
        dot.setPreferredSize(new Dimension(140, 150));
        dot.addMouseListener(new MouseAdapter() { 
        	
        	public void mousePressed( MouseEvent e ) {  
        		dot.setBackground(getRandomColour());
        	}
        });
        
        //Adding the text area
		txtOutput.setLineWrap(true);
		txtOutput.setWrapStyleWord(true);
		txtOutput.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		
		var scroller = new JScrollPane(txtOutput);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setPreferredSize(new Dimension(450, 150));
		scroller.setMaximumSize(new Dimension(450, 150));
		
		//Adding all the components to the panel and the panel to the window
		middle.add(dot);
		middle.add(scroller);
		win.getContentPane().add(middle);
		
		
		/*
		 * The bottom panel contains the clear and quit buttons.
		 */
		var bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));

        //Create and adding Clear and Quit buttons
        var clear = new JButton("Clear");
        clear.addActionListener((e) -> txtOutput.setText(""));
        
        var quit = new JButton("Quit");
        quit.addActionListener((e) -> System.exit(0));
        
        //Add all the components to the panel and the panel to the window
        bottom.add(clear);
        bottom.add(quit);
        win.getContentPane().add(bottom);       
        
        
        /*
         Now showing the configured Window.
         */
		win.setVisible(true);
	}
	
	private Color getRandomColour() {
		Colour c = colours[rand.nextInt(0, colours.length)];
		return Color.decode(c.hex() + "");
	}
	
	protected void replaceText(String text) {
		txtOutput.setText(text);
	}
	
	protected void appendText(String text) {
		txtOutput.setText(txtOutput.getText() + " " + text);
	}
}
