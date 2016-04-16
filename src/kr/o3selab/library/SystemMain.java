package kr.o3selab.library;

import kr.o3selab.library.database.DBManager;
import kr.o3selab.library.gui.LibrarySystemLogin;

public class SystemMain {
	public static DBManager db;
	public static String currentLoginId;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		db = new DBManager();
		new LibrarySystemLogin();
	}

}
