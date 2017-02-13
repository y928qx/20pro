

package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class DinDao
{

   // inset �����û���ѡ�񺽰����Ϣ
        public int inset(Connection connection,Sched sch, int dal,String id)
	{
		int value=-1;
                int var=-1;
                int i=0;
		PreparedStatement statement=null;
                PreparedStatement stat=null;
                PreparedStatement state=null;
                //��ѯ���ݿ����Ƿ��иú����¼
		String sql2="select Hao,Piao from din where Hao=? and id=?";
                // �����û���ѡ�񺽰����Ϣ
                String sql="insert into din(Id,Hao,Qifei,Mudi,Rqi,Jiage,Piao) value(?,?,?,?,?,?,?)";
		//  �����û����ͺ�����޸�Ʊ��
                String sql3="update din set Piao=? where Hao=? and id=?";
                ResultSet result=null;
                
                try
		{
                    // �������ݿ��ѯ
                        stat=connection.prepareStatement(sql2);
                        stat.setString(1,sch.getHao());
                        stat.setString(2,id);
                        result=stat.executeQuery();
                        //�ж��Ƿ��иú���ŵļ�¼
                        while(result.next())
                        {
                            // �ж��Ƿ��иú����¼,�����,var=1;
                            
                            var=1;
                            
                            i=result.getInt("Piao");
                        }
                        if(var==-1)
                        {
                            // ���var=-1���ʾû�иĺ���ļ�¼,���û�����������Ϣ�������ݿ���
                            statement=connection.prepareStatement(sql);
                            statement.setString(1,id);
                            statement.setString(2,sch.getHao());
                            statement.setString(3,sch.getQifei());
                            statement.setString(4,sch.getMudi());
                            statement.setString(5,sch.getRqi());
                            statement.setInt(6,sch.getJiage());
                            statement.setInt(7,dal);
                            value=statement.executeUpdate();
                            return value;
                        }
                        if(var==1)
                        {
                           //���var=1���ʾ�иĺ����¼,�õ���¼�е�Ʊ��+�����û�����Ʊ��
                            // �������ݿ���޸�
                            int j=i+dal;
                            state=connection.prepareStatement(sql3);
                            state.setInt(1,j);
                            state.setString(2,sch.getHao());
                            state.setString(3,id);
                             value=state.executeUpdate();
                             return value;
                        }
			
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
        // �޸Ĺ���Ա���ƶ��ĺ����Ʊ��
        public int update(Connection connection,Sched sch,int dal)
        {
            int wat=-1;
            int i=0;
            int j=0;
            PreparedStatement statement=null;
            PreparedStatement state=null;
            // ��ú���� , ��ѯ�ú����Ʊ��
            String sql="select Piaosu from sch where Hao=?";
            // �޸ĸú����Ʊ��
            String sql2="update sch set Piaosu=? where Hao=?";
            ResultSet resultset=null;
            try
            {
                //��ѯ����
                statement=connection.prepareStatement(sql);
                statement.setString(1,sch.getHao());
                resultset=statement.executeQuery();
                if(resultset.next())
                {
                    // ��ú���Ʊ��
                    i=resultset.getInt("Piaosu"); 
                }
                // ����Ʊ�����û�������Ʊ�� �õ�ʣ��Ʊ��
               j=i-dal;
               // �޸ĸú���Ŀɶ�Ʊ��
               state=connection.prepareStatement(sql2);
               
               state.setInt(1,j);
               state.setString(2,sch.getHao());
               wat=state.executeUpdate();
               return wat;              
            }
          
            catch(SQLException e)
            {
            }
            finally
            {
                try
                {
                    if(resultset!=null) resultset.close();
                    if(statement!=null) statement.close();
                }
                catch(SQLException e)
                {
                    
                }  
            }
            return wat;
        }
        //check ��ú���� ���в�ѯ�������Ϣ
        public Sched check(Connection connection,String str)
        {
            Sched sch=new Sched();
            String sql="select Hao,Rqi, Qifei,Mudi,Jiage,Piaosu from sch where Hao=? ";
            PreparedStatement statement=null;
            ResultSet resultset=null;
             try
            {
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,str);
                    resultset=statement.executeQuery();
                    while(resultset.next())
                    {  
                        sch.setHao(resultset.getString("Hao"));
                        sch.setRqi(resultset.getString("Rqi"));   
                        sch.setQifei(resultset.getString("Qifei"));
                        sch.setMudi(resultset.getString("Mudi"));
                        sch.setJiage(resultset.getInt("Jiage"));  
                        sch.setPiaosu(resultset.getInt("Piaosu"));
                    }
                    return sch;
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
            return sch;        
        }
        // quest �����û�������ø��û������������к���
        public ArrayList quest(Connection connection, String id)
        {
            ArrayList ary=new ArrayList();
            // ��ѯ�û���Ʊ��Ϣ
            String sql="select * from din where Id=?";
            PreparedStatement statement=null;
            ResultSet resultset=null;
            try
            {
                statement=connection.prepareStatement(sql);
                statement.setString(1,id);
                resultset=statement.executeQuery();
                while(resultset.next())
                {
                    Sched sch=new Sched();
                    sch.setHao(resultset.getString("Hao"));
                    sch.setQifei(resultset.getString("Qifei"));
                    sch.setMudi(resultset.getString("Mudi"));
                    sch.setRqi(resultset.getString("Rqi"));
                    sch.setJiage(resultset.getInt("Jiage"));
                    sch.setPiaosu(resultset.getInt("Piao"));
                    //�����������Ʊ������0 ��ô�򲻽��ú�����Ϣ����ArrayList��̬������
                    //��JSPҳ����ʡ����Ʊ��Ϊ0�ĺ���
                    if(resultset.getInt("Piao")!=0)
                    {
                        ary.add(sch);
                    }
                    
                }
                return ary;
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
            return ary;
        }

     
//examine ��ѯ���ú���ĺ����
    public ArrayList examine(Connection connection)
    {
            String sql="select Hao from sch";
            ArrayList tes=new ArrayList();
            Statement statement=null;
            ResultSet result=null;
            try
            {
                statement=connection.createStatement();
                result=statement.executeQuery(sql);
                if(result.next())
                {
                   Anpai anpai=new Anpai();
                   anpai.setHao(result.getString("Hao"));
                   tes.add(anpai);
                }
                return tes;
            }
            catch(SQLException e)
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
            return tes;
    }
    // reced ����û���Ҫ��Ʊ�ĺ�����Ϣ
    public Sched reced(Connection connection,String hao,String id)
    {
            Sched sch=new Sched();
            String sql="select Hao,Rqi, Qifei,Mudi,Jiage,Piao from din where Hao=?  and id=?";
            PreparedStatement statement=null;
            ResultSet resultset=null;
             try
            {
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,hao);
                    statement.setString(2,id);
                    resultset=statement.executeQuery();
                    while(resultset.next())
                    {  
                        sch.setHao(resultset.getString("Hao"));
                        sch.setRqi(resultset.getString("Rqi"));   
                        sch.setQifei(resultset.getString("Qifei"));
                        sch.setMudi(resultset.getString("Mudi"));
                        sch.setJiage(resultset.getInt("Jiage"));  
                        sch.setPiaosu(resultset.getInt("Piao"));
                    }
                    return sch;
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
            return sch;     
    }
    // amendReced ����û���id ����ѡ��ĺ���� �޸��û���Ҫ�˵�Ʊ��
    public int amendReced(Connection connection,Sched sch,int rec , String id)
    {
        int value=-1;
        PreparedStatement statement=null;
        String sql="update din set Piao=? where Hao=? and id=?";
        
        int i=0,j=0;
        
        try
        {
            // ���û�ԭ������������Ʊ������i��
            i=sch.getPiaosu();
            // ��i��ȥ�û���Ҫ�˵�Ʊ�� �õ��Ľ������j��
            j=i-rec;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,j);
            statement.setString(2,sch.getHao());
            statement.setString(3,id);      
            value=statement.executeUpdate();
           return value;
        }
        catch(SQLException e)
        {
        }
        finally
        {
          try
         {
                   
               if(statement!=null) statement.close();
          } 
         catch(SQLException e)
         {
                    
         }  
        }
            return value;
      }
    // Upreced �û���Ʊ�� �޸ĸú������Ʊ��
    public int Upreced(Connection connection ,Sched sch,int dal)
    {
        int wat=-1;
            int i=0;
            int j=0;
            PreparedStatement statement=null;
            PreparedStatement state=null;
            //  �Ȳ�ѯ�û���Ҫ��Ʊ�ĸú����Ʊ��
            String sql="select Piaosu from sch where Hao=?";
            // �޸ĸú����Ʊ��
            String sql2="update sch set Piaosu=? where Hao=?";
            ResultSet resultset=null;
            try
            {
                statement=connection.prepareStatement(sql);
                statement.setString(1,sch.getHao());
                resultset=statement.executeQuery();
                if(resultset.next())
                {
                    // ����û���Ʊǰ�ú����Ʊ��
                    i=resultset.getInt("Piaosu"); 
                }
                // �����Ʊ�������û����˵�Ʊ�� �õ���Ʊ��ú����Ʊ��
               j=i+dal;
              
               state=connection.prepareStatement(sql2);
               
               state.setInt(1,j);
               state.setString(2,sch.getHao());
               wat=state.executeUpdate();
               return wat;              
            }
          
            catch(SQLException e)
            {
            }
            finally
            {
                try
                {
                    if(resultset!=null) resultset.close();
                    if(statement!=null) statement.close();
                }
                catch(SQLException e)
                {
                    
                }  
            }
            return wat;
    }
    //��ÿͻ��˵�ǰ����ʱ��
    public Date getDate(Connection connection)
    {
        Statement statement=null;
         Date date=null;
         ResultSet result=null;
         // ��ȡ���ݿ⵱ǰ����ʱ�� 
        String sql="select current_date() as newdate";
        try
        {
           statement=connection.createStatement();
            result=statement.executeQuery(sql);
            while(result.next())
            {
               date=result.getDate("newdate");
               return date;
            }
        }
         catch(SQLException e)
            {
            }
            finally
            {
                try
                {
                    if(result!=null) result.close();
                    if(statement!=null) statement.close();
                }
                catch(SQLException e)
                {
                    
                }  
            }
            return date;
    }
    // compareDate�Ƚ��������������Ƿ����������ĺ�������ǰһ��
    public boolean compareDate(String str)
    {
        // ��÷���������
         Calendar day=Calendar.getInstance();
	 Date date=Date.valueOf(day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1)+"-"+(day.get(Calendar.DATE)));
	 Date rqi=Date.valueOf(str);
         // �жϺ��������Ƿ��ڷ���������֮��
         boolean i=rqi.after(date);
         return i;
         
    }
    
}
