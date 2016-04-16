package kr.o3selab.library.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.o3selab.library.SystemMain;
import kr.o3selab.library.database.UserStatus;

public class LibrarySystemLogin extends JFrame implements ActionListener {
	@SuppressWarnings("deprecation")
	
	private JTextField textField;
	private JPasswordField passwordField;
	private String id;
	private String pw;
	private Dimension frameSize;
	private Dimension windowSize;
	
	public LibrarySystemLogin() {

		getContentPane().setBackground(Color.WHITE);
		setSize(380,150);
		setTitle("로그인");
		frameSize = getSize();
		windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width)/2, (windowSize.height - frameSize.height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("\uC544\uC774\uB514");
		lblId.setBounds(35, 35, 57, 15);
		getContentPane().add(lblId);
		
		JLabel lblpw = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblpw.setBounds(35, 60, 57, 15);
		getContentPane().add(lblpw);
		
		textField = new JTextField();
		textField.setBounds(104, 32, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 57, 116, 21);
		getContentPane().add(passwordField);
		
		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.setBounds(232, 31, 89, 47);
		getContentPane().add(button);
		
		textField.setNextFocusableComponent(passwordField);
		passwordField.setNextFocusableComponent(button);
		button.setNextFocusableComponent(textField);
		
		button.addActionListener(this);
		
		
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		id = textField.getText();
		pw = passwordField.getText();
		
		System.out.println(id + ", " + pw);
		if(SystemMain.db.login(id, pw)) {
			String username = UserStatus.getUserName();
			new JOptionPane().showMessageDialog(this,  username + " 님! 반갑습니다!", "환영", JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
			new LibrarySystemGUI();
		} else {
			JOptionPane.showMessageDialog(this,  "아이디나 비밀번호가 일치하지 않습니다!", "경고", JOptionPane.WARNING_MESSAGE);
		}
	}
}
