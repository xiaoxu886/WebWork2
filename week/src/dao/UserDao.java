package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.User;

public class UserDao {
	public User get(String userName){
		User user = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/week?useunicode=true&character=utf-8",
					"root","123456");
			
			String sql = "select * from t_user where userName=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				 user = new User(rs.getString("userName"),
						 rs.getString("password"),
						 rs.getString("chrName"),
						 rs.getString("role"));
				
			 }
			 con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

}
