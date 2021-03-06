package kr.o3selab.library.database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import kr.o3selab.library.SystemMain;
import kr.o3selab.library.conf.Book;

public class DBManager {
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://210.119.32.153:3306/duveen";
    private String userName = "duveen";
    private String userPassword = "o3selab";

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DBManager() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, userPassword);
            if(con != null) {
                System.out.println("Connect Success");
            }
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundError");
        } catch(SQLException e) {
            System.out.println("DataBaseLoadError");
        }
    }
    
    public boolean login(String id, String password) {
        String sql = "SELECT * FROM admin WHERE id = '"+ id + "' AND password = '" + password + "'";
        String rsId;
        String rsPw;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	rsId = rs.getString("id");
                rsPw = rs.getString("password");
                if(rsId.equals(id) && rsPw.equals(password)){
                	UserStatus.setUserID(rsId);
                	UserStatus.setUserName(getName(rsId));
                	SystemMain.currentLoginId = rsId;
                	return true;
                }
                else return false;
            } else {
            	return false;
            }
            
        } catch (SQLException e) {
            return false;
        }
    }
    
    public Vector<String> searchBookType() {
    	Vector<String> v = new Vector<String>();
    	String sql = "SELECT * FROM book_type;";
    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
 		
    		while(rs.next()) {
    			v.add(rs.getString("type_name"));
    		}
    		
    		
    	} catch (SQLException e) {
    		System.out.println("시스템 에러");
    	}
    	
    	return v;
    }
    
    public String getName(String id) {
    	String sql = "SELECT * FROM admin WHERE id = '"+id+"';";
    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			return rs.getString("username");
    		}
    		else {
    			return "에러";
    		}
    		
    	} catch (SQLException e) {
    		System.out.println("시스템 에러");
    	}
    	
    	return "에러";
    }
    
    public boolean addBook(String name, Integer type, String author, String publisher, Integer date, BigInteger isbn, Integer price, String commit) {
    	
    	String sql = "INSERT INTO book VALUES " + 
    				"(NULL, '"+ name + "', '" + type + "', '" + author + "', '" + publisher + "', '" + date  + "', '" + isbn + "', '" +
    			price + "', '" + commit + "');";
    	try {
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		if(rs == null) {
    			return false;
    		}
    		else
    			return true;
    	} catch (SQLException e) {
    		return false;
    	}
    }
    
    public Vector<Book> getBookList(String line) {
    	Vector<Book> v = new Vector<Book>();
    	
    	String sql = line;
    	try {
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			
    			int id = rs.getInt("id");
    	    	String name = rs.getString("name");
    	    	int type = rs.getInt("type");
    	    	String author = rs.getString("author");
    	    	String publisher = rs.getString("publisher");
    	    	int date = rs.getInt("date");
    	    	BigInteger isbn = new BigInteger(rs.getString("isbn"));
    	    	int price = rs.getInt("price");
    	    	String commit = rs.getString("commit");
    	    	
    			Book temp = new Book(id, name, type, author, publisher, date, isbn, price, commit);
    			
    			v.add(temp);
    		}
    	} catch (SQLException e) {
    		return null;
    	}
    	
    	return v;
    }
}
   