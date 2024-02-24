
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* FrameDemo.java requires no other files. */
public class FrameDemo {
	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel emptyLabel = new JLabel("");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().addNotify();
		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	private static void createAndShowGUI1() {
		// Create and set up the window.
		JFrame frame1 = new JFrame("FrameDemo");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel emptyLabel = new JLabel("");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		frame1.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		// Display the window.
		frame1.pack();
		frame1.setVisible(true);
	}

	// question 4
	public static void main(String args[]) {
		// basic
		try {
			int arr[] = new int[2];
			System.out.println("Access element three :" + arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown :" + e);
		}
		System.out.println("Out of the block");

		// multi-catch
		int x = 0;
		try {
			x = Integer.parseInt("abc");
		} catch (NumberFormatException | ArithmeticException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}
		// nested
		try {
			try {
				x = 10 / 0;
			} catch (ArithmeticException e) {
				System.out.println("An arithmetic exception occurred: " + e.getMessage());
				throw e;
			}
		} catch (ArithmeticException e) {
			System.out.println("An arithmetic exception occurred: " + e.getMessage());
		}

		// multiple catch
		try {
			x = Integer.parseInt("abc");
		} catch (NumberFormatException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

	}
}