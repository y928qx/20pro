

package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class JDBconne 
{
    
  private static Connection connection = null;
  
      public static Connection getConnetion()
      {	
          String url = "jdbc:mysql://localhost:3306/mybirger";
          String user = "root";
          String password = "root";

                    try
                    {
                            // ע������
                            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                            // ������Ӷ���
                            connection = DriverManager.getConnection(url, user, password);
                    }
                    catch (SQLException e)
                    {
                    }
                    return connection;
      }
      public static void closeConnection()
	{
		try
		{
			if(connection != null) connection.close();
		}
		catch (SQLException e)
		{
		}
	}
    
}
