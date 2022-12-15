
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class BombHouse implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[25];
    JButton resetButton;
	boolean player1_turn;
    int bomb1 = (int)(Math.random() * 14) + 0;
    int bomb2 = (int)(Math.random() * 25) + 14;

	BombHouse(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("Trebuchet MS",Font.BOLD,70));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Bomb House");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);

        resetButton = new JButton();
        resetButton.setText("Restart");
        resetButton.setSize(100,50);
        resetButton.setLocation(0, 18);
        resetButton.addActionListener(this);
        title_panel.add(resetButton);
        resetButton.setVisible(false);

		
		button_panel.setLayout(new GridLayout(5,5));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<25;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Trebuchet MS",Font.BOLD,40));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		for(int i=0;i<25;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
						buttons[i].setForeground(new Color(255,0,0));
						if(bomb1 == i || bomb2 == i){
							buttons[bomb1].setBackground(Color.RED);
							buttons[bomb1].setText("Bomb");
							buttons[bomb2].setBackground(Color.RED);
							buttons[bomb2].setText("Bomb");
							blueWins();
						}
						else {
							buttons[i].setEnabled(false);
							buttons[i].setBackground(Color.GREEN);
							buttons[i].setText("Safe");
							player1_turn=false;
							textfield.setText("Blue turn");
							textfield.setBackground(Color.BLUE);
							
						}
				}
				else {
						buttons[i].setForeground(new Color(0,0,255));
						if(bomb1 == i || bomb2 == i){
							buttons[bomb1].setBackground(Color.RED);
							buttons[bomb1].setText("Bomb");
							buttons[bomb2].setBackground(Color.RED);
							buttons[bomb2].setText("Bomb");
							redWins();
						}
						else {
							buttons[i].setEnabled(false);
							buttons[i].setBackground(Color.GREEN);
							buttons[i].setText("Safe");
							player1_turn=true;
							textfield.setText("Red turn");
							textfield.setBackground(Color.RED);
							
						}
				}
			}			
		}  
          
	}
	
	public void firstTurn() {
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("Red turn");
		}
		else {
			player1_turn=false;
			textfield.setText("Blue turn");
		}


	}
	
	public void blueWins() {

		
		for(int i=0;i<25;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Blue wins");
		textfield.setBackground(Color.BLUE);
        resetButton.setVisible(true);
        
        
	}
	public void redWins() {

		
		for(int i=0;i<25;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setBackground(Color.RED);
		textfield.setText("Red wins");
        resetButton.setVisible(true);
 
	}

}