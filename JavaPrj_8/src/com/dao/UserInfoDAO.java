package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.*;

public class UserInfoDAO {
	private BaseDAO dao = new BaseDAO();

	/**
	 * ����ע���û�
	 * 
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
	 * @param sex
	 *            �Ա�
	 * @param userFace
	 *            ͷ��ͼƬ��
	 * @return boolean ����true��ʾע��ɹ�
	 */
	public boolean checkReg(String userName, String passWord, boolean sex,
			String userFace) {
		String sql = "insert into userInfo(uName,uPassWord,uSex,uFace) values(?,?,?,?)";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { userName, passWord,
					sex, userFace });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	// ����
	public UserInfo getUserInfoByID(int uid) {
		UserInfo user = new UserInfo();
		String sql = "select * from userInfo where uId=?";
		ResultSet rs = null;
		try {
			rs = dao.executeQuery(sql, new Object[] { uid });
			if (rs != null && rs.next()) {
				user.setUid(rs.getInt("uId"));
				user.setUname(rs.getString("uName"));
				user.setUpassword(rs.getString("uPassWord"));
				user.setUsex(rs.getBoolean("uSex"));
				user.setUface(rs.getString("uFace"));
				user.setUregtime(rs.getDate("uRegTime"));
				user.setUtype(rs.getInt("uType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return user;
	}
	
	/**
	 * ����û���¼��������
	 * 
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
	 * @return boolean ����true��ʾ�û��Ϸ�
	 */
	public boolean checkLogin(String userName, String passWord) {
		String sql = "select * from userInfo where uName=? and uPassWord=? ";
		ResultSet rs = null;
		try {
			rs = dao.executeQuery(sql, new Object[] { userName, passWord, });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			return (rs != null && rs.next()) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return false;
	}

	/**
	 * �����û���������û���Ϣ
	 * 
	 * @param userName
	 *            �û���
	 * @return UserInfo ����һ������
	 */
	public UserInfo getUserInfo(String userName) {
		UserInfo user = new UserInfo();
		String sql = "select * from userInfo where uName=?";
		ResultSet rs = null;
		try {
			rs = dao.executeQuery(sql, new Object[] { userName });
			if (rs != null && rs.next()) {

				user.setUid(rs.getInt("uId"));
				user.setUname(rs.getString("uName"));
				user.setUpassword(rs.getString("uPassWord"));
				user.setUsex(rs.getBoolean("uSex"));
				user.setUface(rs.getString("uFace"));
				user.setUregtime(rs.getDate("uRegTime"));
				user.setUtype(rs.getInt("uType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return user;
	}

	/**
	 * �����û�����id���������
	 * 
	 * @param id
	 *            �û����ͱ��
	 * @return �����û���������
	 */
	public String getUserTypeNameById(Integer id) {
		switch (id) {
		case 0:
			return "��Ա";
		case 1:
			return "����";
		case 2:
			return "����Ա";
		}
		return "";
	}

	/**
	 * ���ݲ���ֵ����Ա�����
	 * 
	 * @param sex
	 *            ����ֵ true���� false��Ů
	 * @return �����Ա���
	 */
	public String getSexName(Boolean sex) {
		return sex ? "��" : "Ů";
	}
}
