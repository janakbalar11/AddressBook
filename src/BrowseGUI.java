import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class BrowseGUI extends JFrame {
	private JPanel contentPane;
	private JButton btnDelete;
	private JButton btnClose;
	private JTable table;
	private DefaultTableModel model;

	
	public BrowseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int rowIndex = table.getSelectedRow();
		        if (rowIndex != -1) {
		            btnDelete.setEnabled(true);
		        }
		    }
		});
		model = new DefaultTableModel();
		model.addColumn("fname");
		model.addColumn("lname");
		model.addColumn("phonenum");
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 50, 440, 150);
		contentPane.add(scrollPane);
	    btnDelete = new JButton("Delete");
	    btnDelete.setFont(new Font("Dialog", Font.PLAIN, 13));
	    btnDelete.setBounds(80, 220, 117, 29);
	    btnDelete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            delete();
	        }
	    });

	    contentPane.add(btnDelete);

	    btnClose = new JButton("Cancel");
	    btnClose.setFont(new Font("Dialog", Font.PLAIN, 13));
	    btnClose.setBounds(220, 220, 117, 29);
	    btnClose.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	        }
	    });
	    contentPane.add(btnClose);
	    
	    try (Scanner scanner = new Scanner(new File("contacts.txt"))) {
			while (scanner.hasNextLine()) {
				String[] contactInfo = scanner.nextLine().split(",");
				model.addRow(new Object[]{contactInfo[0], contactInfo[1], contactInfo[2]});
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}


		
	}
	private void delete() {
		int[] selectedRows = table.getSelectedRows();
        try {
            File contactsFile = new File("contacts.txt");
            List<String> lines = Files.readAllLines(contactsFile.toPath());
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
                lines.remove(selectedRows[i]);
            }
            Files.write(contactsFile.toPath(), lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (table.getSelectedRowCount() == 0) {
            btnDelete.setEnabled(false);
        }
	}
}