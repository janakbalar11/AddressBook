import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class SearchGUI extends JFrame {
	private JPanel contentPane;
	private JButton btnSearch;
	private JButton btnReset;
	private JButton btnCancel;
	private JList list;
	private DefaultListModel pl;
	private JTextField txtData;
	
	public SearchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 250, 434, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearch = new JButton("Search");
	
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnSearch.setBounds(11, 19, 117, 29);
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        search();
		    }
		});

		contentPane.add(btnSearch);
		
		btnReset = new JButton("Reset");
	
		btnReset.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnReset.setBounds(11, 50, 117, 29);
		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     reset();
		    }
		});
		contentPane.add(btnReset);
		
		btnCancel = new JButton("Cancel");
		
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnCancel.setBounds(11, 81, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		    }
		});
		contentPane.add(btnCancel);
		
		list = new JList();
		list.setFont(new Font("Dialog", Font.PLAIN, 12));
		list.setBounds(141, 57, 257, 137);
		contentPane.add(list);
		pl= new DefaultListModel();
		list.setModel(pl);
		
		
		txtData = new JTextField();
		txtData.setToolTipText("Data");
		txtData.setBounds(141, 19, 257, 26);
		contentPane.add(txtData);
		txtData.setColumns(100);
		
		txtData.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btnSearch.doClick();
		    }
		});
	}
	private void search() {
		String name = txtData.getText().trim();
        if (name.length() == 0) {
            return;
        }
        
        pl.clear(); 
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String firstName = fields[0].trim();
                String lastName = fields[1].trim();
                if (firstName.toLowerCase().contains(name.toLowerCase()) || lastName.toLowerCase().contains(name.toLowerCase())) {
                    pl.addElement(line);
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	private void reset() {
		txtData.setText("");
       pl.clear();
       txtData.requestFocusInWindow();
	
}
}
