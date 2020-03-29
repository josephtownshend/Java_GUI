package java_GUI_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * A simple Swing program that creates a window with a button.
 * The button updates a counter each time it is clicked. There is a label
 * that displays the counter value.
 *
 * @author Joseph Townshend
 * @version Mar 29, 2020
 *
 */

public class GUI implements ActionListener{

  private int count = 0;
  private final JLabel label;
  private final JFrame frame;
  private final JButton upButton;
  private final JButton downButton;
  private final JPanel panel;

  public GUI() {

    frame = new JFrame();

    upButton = new JButton("Up");
    upButton.addActionListener(this);

    downButton = new JButton("Down");
    downButton.addActionListener(this);

    label = new JLabel("Number of clicks: 0", SwingConstants.CENTER);

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30 , 10 , 30));
    panel.setLayout(new GridLayout(2, 1));

    panel.add(upButton);
    panel.add(downButton);
    panel.add(label);

    frame.add(panel, BorderLayout.CENTER); // add panel to frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // behaviour for closing frame
    frame.setTitle("Our GUI"); // set title of frame
    frame.pack(); // set frame to certain size
    frame.setVisible(true); // set window to be visible and in focus

  }

  public static void main(String[] args) {
    new GUI();
  }


  /**
   * Increments the counter on each button click and displays
   * the new value.
   * @param event information about the button click
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == upButton) {
      count++;
      label.setText("Number of clicks: " + count);
    } else if (event.getSource() == downButton && count > 0) {
      count--;
      label.setText("Number of clicks: " + count);
    } else {
      return;
    }

  }
}

