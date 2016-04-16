package kr.o3selab.library;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import kr.o3selab.library.database.DBManager;
import kr.o3selab.library.gui.LibrarySystemLogin;

public class SystemMain {
	public static DBManager db;
	public static String currentLoginId;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db = new DBManager();
		new LibrarySystemLogin();
	}

}
