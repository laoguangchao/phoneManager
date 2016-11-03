package com.briup.cms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.briup.cms.bean.User;
import com.briup.cms.common.ConnectionFactory;

public class UserDao {


	public void save(User User){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_user(username,nickname,password) values(?,?,?)";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, User.getUsername());
				pstmt.setString(2, User.getNickname());
				pstmt.setInt(3, User.getPassword());
				//3.执行sql
				pstmt.executeUpdate();
				while(pstmt.getUpdateCount()==1){
					JOptionPane.showMessageDialog(null,
							"注册成功!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
				}
			
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public User login(User user){
		User temp=null;
		try{
			
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from  t_user where username=? and password=? ";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,user.getUsername());
				pstmt.setInt(2, user.getPassword());
				rs=pstmt.executeQuery();
				
				if(rs.next()){
				temp =new User();
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getInt("password"));
				
				}
				
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return temp;
		
		
	}
}
