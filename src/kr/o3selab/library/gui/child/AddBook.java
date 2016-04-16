package kr.o3selab.library.gui.child;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kr.o3selab.library.SystemMain;
import kr.o3selab.library.database.UserStatus;

public class AddBook extends JInternalFrame implements ActionListener{
	private JTextField bookNameField;
	private JComboBox<String> bookTypeBox;
	private JTextField authorField;
	private JTextField publisherField;
	private JTextField isbnField;
	private JTextField priceField;
	private JTextField commitField;
	
	String name;
	String type;
	String author;
	String supply;
	String publisher;
	Integer date;
	BigInteger isbn;
	Integer price;
	String commit;	
	private JTextField dateField;

	public AddBook() {
		setBounds(0, 0, 405, 350);
		setTitle("등록");
		setResizable(false);
		setMaximizable(false);
		
		setClosable(true);
		setBorder(new LineBorder(Color.BLACK, 1, true));
		getContentPane().setLayout(null);
		
		JLabel bookNamelbl = new JLabel("\uCC45 \uC774\uB984");
		bookNamelbl.setBounds(26, 30, 57, 15);
		getContentPane().add(bookNamelbl);
		
		JLabel bookTypelbl = new JLabel("\uC790\uB8CC\uC720\uD615");
		bookTypelbl.setBounds(26, 60, 57, 15);
		getContentPane().add(bookTypelbl);
		
		JLabel authorlbl = new JLabel("\uC800\uC790");
		authorlbl.setBounds(26, 90, 57, 15);
		getContentPane().add(authorlbl);
		
		JLabel supplylbl = new JLabel("\uCD9C\uD310\uC0AC");
		supplylbl.setBounds(26, 120, 57, 15);
		getContentPane().add(supplylbl);
		
		JLabel datelbl = new JLabel("\uCD9C\uD310\uB144\uB3C4");
		datelbl.setBounds(26, 150, 57, 15);
		getContentPane().add(datelbl);
		
		JLabel isbnlbl = new JLabel("ISBN");
		isbnlbl.setBounds(26, 180, 57, 15);
		getContentPane().add(isbnlbl);
		
		JLabel pricelbl = new JLabel("\uAC00\uACA9");
		pricelbl.setBounds(26, 210, 57, 15);
		getContentPane().add(pricelbl);
		
		JLabel commitlbl = new JLabel("\uB4F1\uB85D\uC790");
		commitlbl.setBounds(26, 240, 57, 15);
		getContentPane().add(commitlbl);
		
		bookNameField = new JTextField();
		bookNameField.setBounds(95, 27, 270, 21);
		getContentPane().add(bookNameField);
		bookNameField.setColumns(10);
		
		bookTypeBox = new JComboBox<String>(SystemMain.db.searchBookType());
		bookTypeBox.setBounds(95, 57, 270, 21);
		getContentPane().add(bookTypeBox);
		
		authorField = new JTextField();
		authorField.setBounds(95, 87, 270, 21);
		getContentPane().add(authorField);
		authorField.setColumns(10);
		
		publisherField = new JTextField();
		publisherField.setBounds(95, 117, 270, 21);
		getContentPane().add(publisherField);
		publisherField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setBounds(95, 148, 270, 21);
		getContentPane().add(dateField);
		dateField.setColumns(10);
		
		isbnField = new JTextField();
		isbnField.setBounds(95, 177, 270, 21);
		getContentPane().add(isbnField);
		isbnField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(95, 207, 270, 21);
		getContentPane().add(priceField);
		priceField.setColumns(10);
		
		commitField = new JTextField();
		commitField.setBounds(95, 237, 270, 21);
		getContentPane().add(commitField);
		commitField.setColumns(10);
		commitField.setText(UserStatus.getUserName());
		commitField.setEnabled(false);
		
		JButton input = new JButton("입력");
		input.setBounds(196, 275, 78, 23);
		getContentPane().add(input);
		
		JButton delete = new JButton("삭제");
		delete.setBounds(286, 275, 78, 23);
		getContentPane().add(delete);
		
		input.addActionListener(this);
		delete.addActionListener(this);
		
	}	
	
	public int convertBookTypeToInt(String type) {
		Vector<String> v = SystemMain.db.searchBookType();
		int count = 1;
		for (int i = 0; i < v.size(); i++){
			if(v.get(i).equals(type)){
				return count;
			}
			count++;
		}
		return 0;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		
		name = bookNameField.getText();
		type = bookTypeBox.getSelectedItem().toString();
		author = authorField.getText();
		publisher = publisherField.getText();
		if(dateField.getText().equals(""))  date = 0;
		else {
			try {
				date = Integer.parseInt(dateField.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "출판년도는 숫자로만 입력 가능합니다.", "주의", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(isbnField.getText().equals("")) isbn = new BigInteger("0");
		else
			try {
				isbn = new BigInteger(isbnField.getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "ISBN은 숫자로만 입력 가능합니다.", "주의", JOptionPane.ERROR_MESSAGE);
				return;
			}
		if(priceField.getText().equals(""))  price = 0;
		else 
			try {
				price = Integer.parseInt(priceField.getText());
			} catch (NumberFormatException e3) {
				JOptionPane.showMessageDialog(this, "가격은 숫자로만 입력 가능합니다.", "주의", JOptionPane.ERROR_MESSAGE);
				return;
			}
		commit = commitField.getText();
		
		
		switch(str) {
			case "입력":
				if(name.equals(""))
					JOptionPane.showMessageDialog(this, "책 제목을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(author.equals(""))
					JOptionPane.showMessageDialog(this, "저자를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(publisher.equals(""))
					JOptionPane.showMessageDialog(this, "출판사를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(date == 0)
					JOptionPane.showMessageDialog(this, "출판년도를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(isbn == new BigInteger("0"))
					JOptionPane.showMessageDialog(this, "ISBN을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(price == 0)
					JOptionPane.showMessageDialog(this, "가격을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else {
					
					if(SystemMain.db.addBook(name, convertBookTypeToInt(type), author, publisher, date, isbn, price, commit)) {
						JOptionPane.showMessageDialog(this, "입력 성공!", "성공!", JOptionPane.INFORMATION_MESSAGE);
						contentClear();
					} else {
						JOptionPane.showMessageDialog(this, "입력 실패!", "실패!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				break;
			case "삭제":
				contentClear();
				break;
		}
	}
	
	public void contentClear() {
		bookNameField.setText("");
		authorField.setText("");
		publisherField.setText("");
		dateField.setText("");
		isbnField.setText("");
		priceField.setText("");
	}
}
