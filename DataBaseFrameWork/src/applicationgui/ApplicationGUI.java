package applicationgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Books.Book;
import controller.GetController;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ApplicationGUI {

	private JFrame frame;
	private JTextField BookIDTextField;
	private JTextField TitleTextField;
	private JTextField AuthorTextField;
	private JTextField PublisherTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGUI window = new ApplicationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BookIDTextField = new JTextField();
		BookIDTextField.setBounds(109, 39, 155, 20);
		frame.getContentPane().add(BookIDTextField);
		BookIDTextField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblId);
		
		TitleTextField = new JTextField();
		TitleTextField.setBounds(109, 70, 155, 20);
		frame.getContentPane().add(TitleTextField);
		TitleTextField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 76, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		AuthorTextField = new JTextField();
		AuthorTextField.setBounds(109, 101, 155, 20);
		frame.getContentPane().add(AuthorTextField);
		AuthorTextField.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 107, 46, 14);
		frame.getContentPane().add(lblAuthor);
		
		PublisherTextField = new JTextField();
		PublisherTextField.setBounds(109, 137, 155, 20);
		frame.getContentPane().add(PublisherTextField);
		PublisherTextField.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblPublisher);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Book bookItem = new Book();
				bookItem.setBookID(Integer.parseInt(BookIDTextField.getText()));
				bookItem.setBookName(TitleTextField.getText());
				bookItem.setBookAuthor(AuthorTextField.getText());
				bookItem.setBookPublisher(PublisherTextField.getText());
				
				GetController controller = new GetController();
				controller.insertBook(bookItem);
			}
		});
		
		btnInsert.setBounds(10, 184, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book bookItem = new Book();
				bookItem.setBookID(Integer.parseInt(BookIDTextField.getText()));
				
				GetController controller = new GetController();
				controller.deleteBook(bookItem);
			}
		});
		btnDelete.setBounds(109, 184, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book bookItem = new Book();
				bookItem.setBookID(Integer.parseInt(BookIDTextField.getText()));
				bookItem.setBookName(TitleTextField.getText());
				bookItem.setBookAuthor(AuthorTextField.getText());
				bookItem.setBookPublisher(PublisherTextField.getText());
				
				GetController controller = new GetController();
				controller.UpdateBook(bookItem);
				
			}
		});
		btnUpdate.setBounds(208, 184, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GetController controller = new GetController();
				ResultSet result = controller.retrieveBook();
				table.setModel(DbUtils.resultSetToTableModel(result));	
			}
		});
		btnRetrieve.setBounds(10, 221, 89, 23);
		frame.getContentPane().add(btnRetrieve);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 11, 388, 233);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetController controller = new GetController();
				controller.undo();
				
			}
		});
		btnUndo.setBounds(109, 221, 89, 23);
		frame.getContentPane().add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetController controller = new GetController();
				controller.redo();
				
			}
		});
		btnRedo.setBounds(208, 221, 89, 23);
		frame.getContentPane().add(btnRedo);
		
	}
}
