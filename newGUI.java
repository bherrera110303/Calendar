/*
 * GUI design for calendar
@file newGUI.java
@author Brianna Herrera
@version Eclipse Version: 2024-03 (4.31.0)
 */

package Calendar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;
import javax.swing.JTextArea;

public class newGUI {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    newGUI window = new newGUI();
                    window.createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public newGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setEnabled(false);
        frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
        
        JLabel lblNewLabel = new JLabel("Enter Year:");
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        
        JLabel lblEnterMonth = new JLabel("Enter Month:");
        lblEnterMonth.setFont(new Font("Serif", Font.PLAIN, 20));
        
        textField = new JTextField();
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        

        JButton btnNewButton = new JButton("GENERATE");
        btnNewButton.setBackground(new Color(202, 255, 255));
        btnNewButton.setFont(new Font("Serif", Font.PLAIN, 20));
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);    

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(textField.getText());
                    int month = Integer.parseInt(textField_1.getText());

                    if (year < 1800 || year > 3000) {
                        JOptionPane.showMessageDialog(frame, "Please enter a year between 1800 and 3000.", "Invalid Year", JOptionPane.ERROR_MESSAGE);
                    } else if (month < 1 || month > 12) {
                        JOptionPane.showMessageDialog(frame, "Please enter a month between 1 and 12.", "Invalid Month", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String calendar = CalendarGenerator.generateCalendar(year, month);
                        textArea.setText(calendar);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numerical values for year and month.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton btnUserLog = new JButton("User Log");
        btnUserLog.setFont(new Font("Serif", Font.PLAIN, 20));
        

        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(10)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(lblEnterMonth, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGap(10)
        									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textField_1, 0, 0, Short.MAX_VALUE)
        								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(32)
        							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)
        					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(btnUserLog)
        					.addGap(43)
        					.addComponent(scrollPane)))
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblEnterMonth, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(9)
        					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(64)
        					.addComponent(btnUserLog, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(26)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
        			.addGap(26))
        );
        
        JTextArea userlogarea = new JTextArea();
        scrollPane.setViewportView(userlogarea);
        userlogarea.setEditable(false);
        frame.getContentPane().setLayout(groupLayout);
        
        
       btnUserLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Convert text field values to int
                    int year = Integer.parseInt(textField.getText());
                    int month = Integer.parseInt(textField_1.getText());
                    String calendar = CalendarGenerator.generateCalendar(year, month);
                    CalendarLogger instance = new CalendarLogger();
                    instance.logCalendar(year, month, calendar);
                    userlogarea.setText(instance.logRead());
                } catch (NumberFormatException ex) {
                	userlogarea.setText("Please enter valid numbers for year and month.");
                }
            }
        });


        frame.setBounds(100, 100, 758, 516);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


	public void createAndShowGUI() {
        frame.setVisible(true);
    }
}

