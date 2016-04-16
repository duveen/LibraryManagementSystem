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
		setTitle("�����������ý���");
		setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuItem = new JMenu("�޴�");
		JMenuItem exitProgram = new JMenuItem("����");
		JMenu borrowBookItem = new JMenu("����");
		JMenu returnBookItem = new JMenu("�ݳ�");
		JMenu userItem = new JMenu("����ڰ���");
		JMenuItem userAddItem = new JMenuItem("����� ���");
		JMenuItem userSearchItem = new JMenuItem("����� ��ȸ");
		JMenu bookItem = new JMenu("��������");
		JMenuItem addBookItem = new JMenuItem("���� ���");
		JMenuItem searchBookItem = new JMenuItem("���� �˻�");
		
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
		/*userSearchItem.addActionListener(this);�����˻�*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch(cmd) {
			case "����":
				int status = new JOptionPane().showOptionDialog(this, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if(status == JOptionPane.OK_OPTION){
					System.exit(1);
				}				
				break;
			case "���� ���":
				AddBook ab = new AddBook();
				mdiFormSetting(ab);
				break;
				
			case "���� �˻�":
				
				break;
			case "����� ���":
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
