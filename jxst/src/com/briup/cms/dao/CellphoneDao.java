package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Cellphone;
import com.briup.cms.bean.Category;
import com.briup.cms.common.ConnectionFactory;

public class CellphoneDao {

	/**
	 * 保存 产品信息
	 * */
	public void save(Cellphone cellphone) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_cellphone(name,price,information"
						+ ",c_id) values(?,?,?,?)";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cellphone.getName());
				pstmt.setFloat(2, cellphone.getPrice());
				pstmt.setString(3, cellphone.getInformation());
				pstmt.setLong(4, cellphone.getC_id());

				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找所有手机产品信息
	 * */
	public List<Cellphone> findAll() {
		// TODO Auto-generated method stub
		List<Cellphone> list = new ArrayList<Cellphone>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_cellphone";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {
					long id = rs.getLong("id");
					String name = rs.getString("name");
					Float price = rs.getFloat("price");
					String information = rs.getString("information");
					long c_id = rs.getLong("c_id");

					Cellphone ce = new Cellphone();
					ce.setId(id);
					ce.setName(name);
					ce.setPrice(price);
					ce.setInformation(information);
					ce.setC_id(c_id);
					list.add(ce);
				}

			} finally {
				// 4.释放资源
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Cellphone findById(long id) {
		// TODO Auto-generated method stub
		Cellphone cellphone = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_cellphone where id=?";
				// 2. 预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 3.执行
				rs = pstmt.executeQuery();
				while (rs.next()) {

					String name = rs.getString("name");
					Float price = rs.getFloat("price");
					String information = rs.getNString("information");
					cellphone = new Cellphone(name, price, information);
					cellphone.setId(id);
				}

			} finally {
				// 4.释放资源
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cellphone;
	}

	/***
	 * 更改手机产品信息
	 * **/
	public void update(Cellphone cellphone) {
		// TODO Auto-generated method stub
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_cellphone set name=?,price=?,information=?,c_id=? where id=?";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				// 替换占位符
				pstmt.setString(1, cellphone.getName());
				pstmt.setFloat(2, cellphone.getPrice());
				pstmt.setString(3, cellphone.getInformation());
				pstmt.setLong(4, cellphone.getC_id());
				pstmt.setLong(5, cellphone.getId());
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过id删除手机产品信息
	 **/
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				// 1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "delete from t_cellphone where id = ?";
				// 2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				// 3.执行sql
				pstmt.executeUpdate();
			} finally {
				// 4.释放资源
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
