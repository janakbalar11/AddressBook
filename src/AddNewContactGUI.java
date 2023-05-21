import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;




public class AddNewContactGUI extends JFrame {
	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnReset;
	private JButton btnCancel;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	
	
	public AddNewContactGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSave = new JButton("Save");
		
	
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnSave.setBounds(20, 150, 117, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		
		contentPane.add(btnSave);
		
		btnReset = new JButton("Reset");

		btnReset.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnReset.setBounds(145, 150, 117, 29);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			reset();
			}
		});
		contentPane.add(btnReset);
		
		btnCancel = new JButton("Cancel");
	
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnCancel.setBounds(270, 150, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblFirstName.setBounds(20, 19, 100, 26);
		contentPane.add(lblFirstName);
		
		 txtFirstName = new JTextField();
	        txtFirstName.setToolTipText("First Name");
	        txtFirstName.setBounds(140, 19, 130, 26);
	        contentPane.add(txtFirstName);
	        txtFirstName.setColumns(15);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLastName.setBounds(20, 65, 100, 26);
		contentPane.add(lblLastName);
		
		  txtLastName = new JTextField();
	        txtLastName.setToolTipText("Last Name");
	        txtLastName.setBounds(140, 65, 130, 26);
	        contentPane.add(txtLastName);
	        txtLastName.setColumns(15);
		
		JLabel lblPhoneNum = new JLabel("Phone Number");
		lblPhoneNum.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPhoneNum.setBounds(20, 111, 100, 26);
		contentPane.add(lblPhoneNum);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setToolTipText("Phone Number");
		txtPhoneNumber.setBounds(140, 111, 130, 26);
	    contentPane.add(txtPhoneNumber);
	    txtPhoneNumber.setColumns(15);
		
	}
	 private void save() {
	        String firstName = txtFirstName.getText();
	        String lastName = txtLastName.getText();
	        String phoneNumber = txtPhoneNumber.getText();
	        
	        try (PrintWriter writer = new PrintWriter(new FileWriter("contacts.txt", true))) {
	            writer.println(firstName + "," + lastName + "," + phoneNumber);
	            writer.flush();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        
	        txtFirstName.setText("");
	        txtLastName.setText("");
	        txtPhoneNumber.setText("");
	    }
	 
	 private void reset() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtPhoneNumber.setText("");
	 }
}