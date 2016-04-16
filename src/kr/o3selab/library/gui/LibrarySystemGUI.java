package kr.o3selab.library.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.o3selab.library.gui.child.AddBook;
import kr.o3selab.library.gui.child.AddUser;

public class LibrarySystemGUI extends JFrame implements ActionListener {
	private JDesktopPane desktopPane;
	private Container contentPane;
	
	public LibrarySystemGUI() {
		setSize(800, 700);
		setLocation(50,50);
		setTitle("도서관관리시스템");
		setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuItem = new JMenu("메뉴");
		JMenuItem exitProgram = new JMenuItem("종료");
		JMenu borrowBookItem = new JMenu("대출");
		JMenu returnBookItem = new JMenu("반납");
		JMenu userItem = new JMenu("사용자관리");
		JMenuItem userAddItem = new JMenuItem("사용자 등록");
		JMenuItem userSearchItem = new JMenuItem("사용자 조회");
		JMenu bookItem = new JMenu("도서관리");
		JMenuItem addBookItem = new JMenuItem("도서 등록");
		JMenuItem searchBookItem = new JMenuItem("도서 검색");
		
		menuItem.add(exitProgram);
		menuBar.add(menuItem);
		menuBar.add(borrowBookItem);
		menuBar.add(returnBookItem);
		userItem.add(userAddItem);
		userItem.add(userSearchItem);
		menuBar.add(userItem);
		bookItem.add(addBookItem);
		bookItem.add(searchBookItem);
		menuBar.add(bookItem);
		
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		exitProgram.addActionListener(this);
		addBookItem.addActionListener(this);
		searchBookItem.addActionListener(this);
		userAddItem.addActionListener(this);
		/*userSearchItem.addActionListener(this);유저검색*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch(cmd) {
			case "종료":
				int status = new JOptionPane().showOptionDialog(this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if(status == JOptionPane.OK_OPTION){
					System.exit(1);
				}				
				break;
			case "도서 등록":
				AddBook ab = new AddBook();
				mdiFormSetting(ab);
				break;
				
			case "도서 검색":
				
				break;
			case "사용자 등록":
				AddUser au = new AddUser();
				mdiFormSetting(au);
				break;
		}
	}
	
	public void mdiFormSetting(JInternalFrame oIframe) {
		boolean bObj= true;
		JInternalFrame[] allFrames = desktopPane.getAllFrames();
	       
		for(int i=0; i<allFrames.length; i++){
			if(allFrames[i].getClass() ==  oIframe.getClass()){
				bObj= false;
				break;
			}			
		}
		
		if(bObj){
			desktopPane.add(oIframe);
			oIframe.setVisible(true);
		}
	}
}
