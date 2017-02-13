

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;


public class SchedDao 
{
    // inset ��Sched�����е�ֵ���뵽������Ϣ����
        public int inset(Connection connection,Sched sch)
	{
		int value=-1;
		PreparedStatement statement=null;
		String sql="insert into sch(Hao,Qifei,Mudi,Jiage,Piaosu) value(?,?,?,?,?)";
		try
		{
			statement=connection.prepareStatement(sql);
			statement.setString(1,sch.getHao());
			statement.setString(2,sch.getQifei());
			statement.setString(3,sch.getMudi());
			statement.setInt(4,sch.getJiage());
			statement.setInt(5,sch.getPiaosu());
			value=statement.executeUpdate();
                        return value;
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement!=null)statement.close();
			}
			catch (SQLException ee)
			{
			}
		}
		return value;
	}
        // check �޸ĸú���ŵ�����ʱ��
         public int check(Connection connection,Anpai anpai)
	{
		int value=-1;
		PreparedStatement statement=null;
		String sql="update sch set Rqi=? where Hao=?";
		try
		{
			statement=connection.prepareStatement(sql);
			statement.setDate(1,anpai.getRqi());
			statement.setString(2,anpai.getHao());
			value=statement.executeUpdate();
                        return value;
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement!=null)statement.close();
			}
			catch (SQLException ee)
			{
			}
		}
		return value;
	}
         // quest ������к������Ϣ
        public ArrayList quest(Connection connection)
        {
            ArrayList array=new ArrayList();
            //��ѯ���ж��ƺ������Ϣ
            // ����ѯ����ֵ����ArrayList��̬�����з���
            String sql="select Hao,Qifei,Rqi,Mudi,Jiage,Piaosu from sch ";
            Statement statement=null;
            ResultSet resultset=null;
            try
            {
                    statement=connection.createStatement();
                    resultset=statement.executeQuery(sql);
                    while(resultset.next())
                    {
                        Sched sch=new Sched();
                        sch.setHao(resultset.getString("Hao"));  
                         sch.setRqi(resultset.getString("Rqi"));
                        sch.setQifei(resultset.getString("Qifei"));
                        sch.setMudi(resultset.getString("Mudi"));
                        sch.setJiage(resultset.getInt("Jiage"));
                        sch.setPiaosu(resultset.getInt("Piaosu"));
                        array.add(sch);
                    }
                    return array;
                    
            }
            catch(SQLException e)
            {
                
            }
            finally
            {
                try
                {
                    if(statement!=null) statement.close();
                    if(resultset!=null) resultset.close();
                }
                catch(SQLException ee)
                {
                    
                }
            }
            return array;
            
        }
        // descry ��ѯ�Ѿ��������ڵĺ���
        // ��������Ϣ���� ArrayList��̬������
        public ArrayList descry(Connection connection)
        {
            ArrayList array=new ArrayList();
            String sql="select Hao,Qifei,Rqi,Mudi,Jiage,Piaosu from sch where Rqi is not null";
            Statement statement=null;
            ResultSet resultset=null;
            try
            {
                    statement=connection.createStatement();
                    resultset=statement.executeQuery(sql);
                    while(resultset.next())
                    {
                        Sched sch=new Sched();
                        // ��÷�������ǰ����
                        Calendar day=Calendar.getInstance();
                        Date date=Date.valueOf(day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1)+"-"+day.get(Calendar.DATE));
                        Date rqi=Date.valueOf(resultset.getString("Rqi"));
                        // �ȽϺ������ں͵�ǰ����
                        boolean i=rqi.after(date);
                        // ������������ڵ�ǰ����������֮�� ����ѯ����ֵ����Sched������
                        if(i==true)
                        {
                          sch.setHao(resultset.getString("Hao"));  
                          sch.setRqi(resultset.getString("Rqi"));
                          sch.setQifei(resultset.getString("Qifei"));
                          sch.setMudi(resultset.getString("Mudi"));
                          sch.setJiage(resultset.getInt("Jiage"));
                          sch.setPiaosu(resultset.getInt("Piaosu"));
                          array.add(sch);  
                        }
                        //������������ڵ�ǰ����������֮�� �򲻽���ѯ��ֵ����Sched������
                        else
                        {
                        }
                        
                        
                    }
                    return array;
                    
            }
            catch(SQLException e)
            {
                
            }
            finally
            {
                try
                {
                    if(statement!=null) statement.close();
                    if(resultset!=null) resultset.close();
                }
                catch(SQLException ee)
                {
                    
                }
            }
            return array;
            
        }
        

  
}
