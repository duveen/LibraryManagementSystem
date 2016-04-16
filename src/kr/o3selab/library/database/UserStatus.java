package kr.o3selab.library.database;

public class UserStatus {
	private static String userID;
	private static String userName;
	
	
	public static String getUserID() {
		return userID;
	}
	
	public static String getUserName() {
		return userName;
	}
	
	public static void setUserID(String id) {
		userID = id;
	}
	
	public static void setUserName(String username) {
		userName = username;
	}
	
}
