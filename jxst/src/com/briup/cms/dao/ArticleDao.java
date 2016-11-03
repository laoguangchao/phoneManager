package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.common.ConnectionFactory;

public class ArticleDao {
	//通过栏目id查找文章
	public List<Article> query(Long id,String title,Long c_id){
		List<Article> list = new ArrayList<Article>();
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article where 1=1 ";
				if(id!=null){
					sql +="and id = "+id;
				}
				if(title!=null){
					sql += "and title like '%"+title+"%' ";
				}
				if(c_id!=null){
					sql += "and c_id = "+c_id;
				}
				System.out.println(sql);
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					long did = rs.getLong("id");
					String dtitle = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					Date date = rs.getDate("publisurDate");
					int clickTimes = rs.getInt("clickTimes");
					long dc_id = rs.getLong("c_id");
					
					Article article = new Article();
					article.setAuthor(author);
					article.setC_id(dc_id);
					article.setClickTimes(clickTimes);
					article.setContent(content);
					article.setId(did);
					article.setPublisurDate(date);
					article.setTitle(dtitle);
					
					list.add(article);
				}
				
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
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
		return list;
	}
	
	
	public Article findById(long id) {
	Article article=null;
	try{
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//1.注册驱动，获取连接
			conn = ConnectionFactory.getConn();
			String sql = "select * from t_article where id=?";
			//2. 预处理
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			//3.执行
			rs = pstmt.executeQuery();
			while(rs.next()){
			
				String title = rs.getString("title");
				String author=rs.getString("author");
				String content=rs.getString("content");
				article = new Article(title,author,content);
				article.setId(id);
			}
			
		}finally{
			//4.释放资源
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		return article;
	}
	
	/*public  Article findById(long id){
		Article article=null;
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article where id=?";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					String title = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					long c_id = rs.getLong("c_id");
					article = new Article(title,author,content);
					//title,author,content
					article.setC_id(c_id);
					article.setId(id);
					
					
				}
				
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return article;
		
	}*/
	
	public List<Article> findAll(){
		List<Article> list = new ArrayList<Article>();
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String content = rs.getString("content");
					Date date = rs.getDate("publisurDate");
					int clickTimes = rs.getInt("clickTimes");
					long c_id = rs.getLong("c_id");
					
					Article a = new Article();
					a.setAuthor(author);
					a.setC_id(c_id);
					a.setClickTimes(clickTimes);
					a.setContent(content);
					a.setId(id);
					a.setPublisurDate(date);
					a.setTitle(title);
					
					list.add(a);
				}
				
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
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
		return list;
	}
	/**
	 * 保存
	 * @param  文章
	 * */
	public void save(Article article){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_article(title,content,author"
						+ ",publisurDate,clickTimes,c_id) values(?,?,?,?,?,?)";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getContent());
				pstmt.setString(3, article.getAuthor());
				pstmt.setDate(4, new Date(article.getPublisurDate().getTime()));
				pstmt.setInt(5, article.getClickTimes());
				pstmt.setLong(6, article.getC_id());
				//3.执行sql
				pstmt.executeUpdate();
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
	
	
	public static void update(Article article) {
		// TODO Auto-generated method stub
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_article set title=?,author=?,content=?,c_id=? where id=?";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
                //替换占位符
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setString(3, article.getContent());
				pstmt.setLong(4,article.getC_id());
				pstmt.setLong(5,article.getId());
				//3.执行sql
				pstmt.executeUpdate();
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

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "delete from t_article where id = ?";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//3.执行sql
				pstmt.executeUpdate();
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
	
}
