import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComponent;

@SuppressWarnings("serial")

public class FunPaint
{  
	public static void draw(Graphics g)
	{  
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Grid Dimension:");
		int GridDimension = 6;
		GridDimension = in.nextInt();
	    
		for (int row = 0;row<GridDimension;row++)
		{
			for (int column = 0;column<GridDimension;column++)
		    {
				if(column < GridDimension/2 && row < GridDimension/2){
					g.setColor(Color.GREEN);
				}
				else if(column >= GridDimension/2 && row >= GridDimension/2){
					g.setColor(Color.RED);
				}
				else{
					g.setColor(Color.BLACK);
				}
				g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
		    }
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent component = new JComponent()
		{
			public void paintComponent(Graphics graph)
			{
				draw(graph);
			}
		};     
		frame.add(component);
		frame.setVisible(true);
   }   
}

