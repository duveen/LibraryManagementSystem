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
public class AddUser extends JInternalFrame implements ActionListener{
	//private JTextField userIdField;
	private final short  ADMIN = 1;
	private final short  MEMBER = 0;
	private JTextField userNumbField;
	private JTextField userNameField;
	private JTextField telNumbField;
	
	Integer uNumb;
	String uName;
	String tNumb;
	
	public AddUser(){
		setBounds(0, 0, 420, 300);
		setTitle("회원등록");
		setResizable(false);
		setMaximizable(false);
		
		setClosable(true);
		setBorder(new LineBorder(Color.BLACK, 1));
		getContentPane().setLayout(null);
		
		JLabel userNumblbl = new JLabel("회원번호");
		userNumblbl.setBounds(26, 40, 57, 15);
		getContentPane().add(userNumblbl);
		
		JLabel userNamelbl = new JLabel("성명");
		userNamelbl.setBounds(26, 85, 57, 15);
		getContentPane().add(userNamelbl);
		
		JLabel telNumblbl = new JLabel("전화번호");
		telNumblbl.setBounds(26, 125, 57, 15);
		getContentPane().add(telNumblbl);
		
		userNumbField = new JTextField();
		userNumbField.setBounds(150, 37, 138, 21);
		getContentPane().add(userNumbField);
		userNumbField.setColumns(10);
		userNumbField.setEnabled(false);
		
		userNameField = new JTextField();
		userNameField.setBounds(150, 82, 138, 21);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		telNumbField = new JTextField();
		telNumbField.setBounds(150, 122, 138, 21);
		getContentPane().add(telNumbField);
		telNumbField.setColumns(10);
		
		JButton input = new JButton("입력");
		input.setBounds(238, 238, 78, 23);
		getContentPane().add(input);
		
		JButton delete = new JButton("삭제");
		delete.setBounds(328, 238, 78, 23);
		getContentPane().add(delete);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}


}
