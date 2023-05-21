import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainGUI extends JFrame {
	private JPanel contentPane;
	private JButton btnAddNew;
	private JButton btnSearch;
	private JButton btnBrowse;
	public mainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AddNewContactGUI addNewContactGUI = new AddNewContactGUI();
		        addNewContactGUI.setVisible(true);
		    }
		});
	
		btnAddNew.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnAddNew.setBounds(65, 19, 117, 29);
		contentPane.add(btnAddNew);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        SearchGUI SearchGUI = new SearchGUI();
		        SearchGUI.setVisible(true);
		    }
		});

		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnSearch.setBounds(65, 71, 117, 29);
		contentPane.add(btnSearch);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        BrowseGUI browseGUI = new BrowseGUI();
		        browseGUI.setVisible(true);
		    }
		});

		btnBrowse.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnBrowse.setBounds(65, 126, 117, 29);
		contentPane.add(btnBrowse);
		
	}
}
		
