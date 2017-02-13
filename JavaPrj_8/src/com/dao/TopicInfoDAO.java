package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.page.*;
import com.entity.*;

public class TopicInfoDAO {

	private BaseDAO dao = new BaseDAO();
	private ResultSet rs = null;

	/**
	 * ���ݵ�ǰ���id�����ͬһ�����������������󷢱��¼
	 * 
	 * @param sId
	 *            ���id
	 * @return TopicInfo ����һ������
	 */
	public IndexPage getALLTopicLastTimeById(Integer sId) {
		IndexPage index_page = null;
		String sql = "select (select uName from userInfo where userInfo.uId= tb.tUid ) as author,tTopic as title,tPublishTime as publishTime,tid"
				+ " from"
				+ " (select * from topicInfo where tPublishTime =(select max(tPublishTime) from topicInfo where tSid = ?)) as tb";
		try {
			rs = dao.executeQuery(sql, new Object[] { sId });
			if (rs != null && rs.next()) {
				index_page = new IndexPage();
				//
				index_page.setAuthor(rs.getString("author"));
				index_page.setPublishtime(rs.getTimestamp("publishTime"));
				index_page.setTitle(rs.getString("title"));
				index_page.setTid(rs.getInt("tid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return index_page; 
	}

	/**
	 * ��������id��������û���Ϣ
	 * 
	 * @param tid
	 *            �������
	 * @return DetailPage ����һ������
	 */
	public DetailPage getTopicInfoAndUserInfoById(Integer tid) {
		DetailPage detail = null;
		String sql = "select tTopic,tContents,tPublishTime,tModifyTime,tId,tUid,"
				+ "(select uName from  userInfo where userInfo.uId = topicInfo.tuid) as tName,"
				+ "(select uFace from  userInfo where userInfo.uId = topicInfo.tuid) as tFace,"
				+ "(select uRegTime from  userInfo where userInfo.uId = topicInfo.tuid) as tRegTime,"
				+ "(select uType from  userInfo where userInfo.uId = topicInfo.tuid) as tUserType,"
				+ "(select uSex from  userInfo where userInfo.uId = topicInfo.tuid) as tSex"
				+ " from topicInfo where tid = ?";
		try {
			rs = dao.executeQuery(sql, new Object[] { tid });
			if (rs != null && rs.next()) {
				detail = new DetailPage();
				//
				detail.setContents(rs.getString("tContents"));
				detail.setFace(rs.getString("tFace"));
				detail.setModifytime(rs.getTimestamp("tModifyTime"));
				detail.setName(rs.getString("tName"));
				detail.setPublishtime(rs.getTimestamp("tPublishTime"));
				detail.setRegtime(rs.getDate("tRegTime"));
				detail.setTitle(rs.getString("tTopic"));
				detail.setType(rs.getInt("tUserType"));
				detail.setSex(rs.getBoolean("tSex"));
				detail.setId(rs.getInt("tId"));
				detail.setUid(rs.getInt("tUid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return detail;
	}

	/**
	 * ���ݰ��id��ð���Ӧ������������Ϣ���������⡢���ߡ��ظ�����
	 * 
	 * @param sId
	 *            ���id
	 * @return List<ListPage> ����һ������
	 */
	public List<ListPage> getTopicInfoById(Integer sId) {
		String sql = "select tId,tTopic,tReplyCount,(select uName from userInfo where uid = topicInfo.tuid) as tuid "
				+ "from topicInfo where tsid = ? order by tPublishTime desc";
		List<ListPage> list = null;
		try {
			rs = dao.executeQuery(sql, new Object[] { sId });
			if (rs != null) {
				list = new ArrayList<ListPage>();
				while (rs.next()) {
					ListPage temp = new ListPage();
					temp.setAuthor(rs.getString("tUId"));
					temp.setReplycount(rs.getInt("tReplyCount"));
					temp.setTitle(rs.getString("tTopic"));
					temp.setTid(rs.getInt("tId"));
					list.add(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return list;
	}

	/**
	 * ��������id�����Ҫ�޸ĵ���Ϣ
	 * 
	 * @param tid
	 *            �������
	 * @return TopicInfo ����һ������
	 */
	public TopicInfo getEditTopicInfoById(Integer tid) {
		TopicInfo topicinfo = null;
		String sql = "select * from topicInfo where tid = ?";
		String content = "";
		try {
			rs = dao.executeQuery(sql, new Object[] { tid });
			if (rs != null && rs.next()) {
				topicinfo = new TopicInfo();
				//
				topicinfo.setTclickcount(rs.getInt("tClickCount"));
				// <br>�滻��\r\n
				content = rs.getString("tContents").replace("<br>", "\r\n");
				content = content.replace("&gt;", ">");
				content = content.replace("&lt;", "<");
				content = content.replace("&nbsp", " ");
				
				topicinfo.setTcontents(content);
				topicinfo.setTid(rs.getInt("tId"));
				topicinfo.setTmodifytime(rs.getDate("tModifyTime"));
				topicinfo.setTpublishtime(rs.getDate("tPublishTime"));
				topicinfo.setTreplycount(rs.getInt("tReplyCount"));
				topicinfo.setTsid(rs.getInt("tSid"));
				topicinfo.setTtopic(rs.getString("tTopic"));
				topicinfo.setTuid(rs.getInt("tUid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return topicinfo;
	}

	/**
	 * ��������id�����������������
	 * 
	 * @param title
	 *            ����
	 * @param content
	 *            ����
	 * @param tid
	 *            �������
	 * @return Boolean ����һ��������
	 */
	public Boolean updateTopicInfoById(String title, String content, Integer tid) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = sdf.format(new Date());// ��õ�ǰ��ʱ��
		int result = -1;
		// ��\r\n�滻��<br>
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace(" ", "&nbsp");
		content = content.replace("\r\n", "<br>");
		
		String sql = "update topicInfo set tTopic = ?,tContents = ?,tModifyTime = ? where tid = ?";
		try {
			result = dao.executeUpdate(sql, new Object[] { title, content,
					time, tid });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	/**
	 * ��������idɾ����������
	 * 
	 * @param tid
	 *            �������
	 * @return Boolean ���ز����� true����ʾɾ���ɹ�
	 */
	public Boolean delTopicInfoById(Integer tid) {
		int result = -1;
		String sql = "delete from topicInfo where tid = ?";
		try {
			result = dao.executeUpdate(sql, new Object[] { tid });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	/**
	 * ����������Ϣ
	 * 
	 * @param title
	 *            ����
	 * @param content
	 *            ����
	 * @param sid
	 *            �����
	 * @param uid
	 *            �û����
	 * @return Boolean ���ز����� true����ʾ����ɹ�
	 */
	public Boolean insertTopicInfo(String title, String content, Integer sid,
			Integer uid) {
		int result = -1;
		String sql = "insert into topicInfo(tSid,tuid,tTopic,tContents)"
				+ " values(?,?,?,?)";
		// ��\r\n�滻��<br>
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace(" ", "&nbsp");
		content = content.replace("\r\n", "<br>");
		
		try {
			result = dao.executeUpdate(sql, new Object[] { sid, uid, title,
					content });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	/**
	 * ���ݰ��idͳ������������
	 * 
	 * @param sid
	 *            ���id
	 * @return Boolean ���ز����� true����ʾͳ�Ƴɹ�
	 */
	public Boolean getTopicCountById(Integer sid) {
		String sql = "update sectionInfo set sTopicCount = "
				+ " (select count(*) as topicCount from topicInfo where tsid = ?)"
				+ " where sid = ?";
		int result = -1;
		try {
			result = dao.executeUpdate(sql, new Object[] { sid, sid });
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.closeResultSet();
			dao.closeStatement();
			dao.closeConnection();
		}
		return result > 0 ? true : false;
	}

	// ����
	public static void main(String[] args) {
		TopicInfoDAO dao = new TopicInfoDAO();
		Boolean x = dao.insertTopicInfo("d", "d", 11, 1);
		System.out.print(x);
		// System.out.print(x);
		// System.out.print(dao.updateTopicInfoById("33", "dfdsfsdfs", 1));
	}
}
