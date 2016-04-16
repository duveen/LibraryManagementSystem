package kr.o3selab.library.gui.child;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kr.o3selab.library.SystemMain;
import kr.o3selab.library.conf.Book;

public class SearchBook extends JInternalFrame implements ActionListener {
	private JTextField searchField;
	private JList<String> list;
	
	public SearchBook() {
		setBounds(0, 0, 510, 300);
		setTitle("검색");
		setResizable(false);
		setMaximizable(false);
		setClosable(true);
		setBorder(new LineBorder(Color.BLACK, 1));
		
		
		getContentPane().setLayout(null);
		
		String[] content = {"제목", "저자", "출판사", "ISBN", "출판년도" };
		
		JComboBox searchType = new JComboBox(content);
		searchType.setBounds(24, 26, 100, 23);
		getContentPane().add(searchType);
		
		searchField = new JTextField();
		searchField.setBounds(136, 26, 233, 23);
		getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("\uAC80\uC0C9");
		searchButton.setBounds(381, 26, 97, 23);
		getContentPane().add(searchButton);
		
		list = new JList<String>();
		JScrollPane jp = new JScrollPane(list);
		jp.setBounds(24, 59, 452, 186);
		list.setBounds(24, 59, 452, 186);
		getContentPane().add(jp);
		
		setVisible(true);
		
		searchButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM book";
		
		// list.
		
		Vector<Book> v = SystemMain.db.getBookList(sql);
		
		
	}
}
