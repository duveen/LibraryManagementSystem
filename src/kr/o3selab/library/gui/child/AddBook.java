package kr.o3selab.library.gui.child;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTextField authorField;
	private JTextField supplyField;
	private JTextField isbnField;
	private JTextField priceField;
	private JTextField commitField;

	public AddBook() {
		setBounds(0, 0, 420, 300);
		setTitle("등록");
		setResizable(false);
		setMaximizable(false);
		
		setClosable(true);
		setBorder(new LineBorder(Color.BLACK, 1));
		getContentPane().setLayout(null);
		
		JLabel bookName = new JLabel("\uCC45 \uC774\uB984");
		bookName.setBounds(26, 30, 57, 15);
		getContentPane().add(bookName);
		
		JLabel bookType = new JLabel("\uC790\uB8CC\uC720\uD615");
		bookType.setBounds(26, 60, 57, 15);
		getContentPane().add(bookType);
		
		JLabel autor = new JLabel("\uC800\uC790");
		autor.setBounds(26, 90, 57, 15);
		getContentPane().add(autor);
		
		JLabel supply = new JLabel("\uCD9C\uD310\uC0AC");
		supply.setBounds(26, 120, 57, 15);
		getContentPane().add(supply);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(26, 150, 57, 15);
		getContentPane().add(lblIsbn);
		
		JLabel price = new JLabel("\uAC00\uACA9");
		price.setBounds(26, 180, 57, 15);
		getContentPane().add(price);
		
		JLabel commit = new JLabel("\uB4F1\uB85D\uC790");
		commit.setBounds(26, 210, 57, 15);
		getContentPane().add(commit);
		
		bookNameField = new JTextField();
		bookNameField.setBounds(95, 27, 270, 21);
		getContentPane().add(bookNameField);
		bookNameField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(95, 87, 270, 21);
		getContentPane().add(authorField);
		authorField.setColumns(10);
		
		supplyField = new JTextField();
		supplyField.setBounds(95, 117, 270, 21);
		getContentPane().add(supplyField);
		supplyField.setColumns(10);
		
		isbnField = new JTextField();
		isbnField.setBounds(95, 147, 270, 21);
		getContentPane().add(isbnField);
		isbnField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(95, 177, 270, 21);
		getContentPane().add(priceField);
		priceField.setColumns(10);
		
		commitField = new JTextField();
		commitField.setBounds(95, 207, 270, 21);
		getContentPane().add(commitField);
		commitField.setColumns(10);
		commitField.setText(UserStatus.getUserName());
		commitField.setEnabled(false);
		
		JButton input = new JButton("입력");
		input.setBounds(238, 238, 78, 23);
		getContentPane().add(input);
		
		JButton delete = new JButton("삭제");
		delete.setBounds(328, 238, 78, 23);
		getContentPane().add(delete);
		
		JComboBox comboBox = new JComboBox(SystemMain.db.searchBookType());
		comboBox.setBounds(95, 57, 270, 21);
	
		getContentPane().add(comboBox);
		
		input.addActionListener(this);
		delete.addActionListener(this);
		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		switch(str) {
			case "입력":
				if(bookNameField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "책 제목을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(authorField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "저자를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(supplyField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "출판사를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(isbnField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "ISBN을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(priceField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "가격을 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else if(commitField.getText().equals(""))
					JOptionPane.showMessageDialog(this, "작성자를 입력해주세요", "주의", JOptionPane.ERROR_MESSAGE);
				else {
					JOptionPane.showMessageDialog(this, "입력 성공!", "성공!", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case "삭제":
				bookNameField.setText("");
				authorField.setText("");
				supplyField.setText("");
				isbnField.setText("");
				priceField.setText("");
				break;
		}
	}
}
