package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.dbClose;
import db.dbConnect;
import entity.SalesMan;

public class SalesManDao {
     Connection        conn  = null;
	 PreparedStatement pstmt = null;
	 ResultSet 		res 	 	 = null;
	
	/**
	 * 1.前台收银登陆
	 */
 	public ArrayList<SalesMan> checkstandLog(String sName)
	{
 		ArrayList<SalesMan> salesMans = new ArrayList<SalesMan>();
		conn =dbConnect.getconn();
		String sql = "SELECT SID,SPASSWORD FROM SALESMAN WHERE SNAME=?";
				try
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,sName);
					
					res= pstmt.executeQuery();
					while (res.next())
					{
						String sPassWord = res.getString("spassword");
						int sId = res.getInt("sid");
						SalesMan salesMan = new SalesMan(sId,sPassWord); 
						salesMans.add(salesMan);						
					}
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}finally
				{
					dbClose.queryClose(pstmt, res, conn);
				}
	 return salesMans;
	}

}
