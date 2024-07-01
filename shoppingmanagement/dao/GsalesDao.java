package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.dbClose;
import db.dbConnect;
import entity.Gsales;

public final class GsalesDao {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    /**
	 *2.购物结算-向sales表中插入商品数据！
	 *@param gSales 售卖商品对象
	 *@return boolean
	 */
    public boolean shoppingSettlement(Gsales gsales){
        Boolean bool=false;
        conn=dbConnect.getconn();
        String sql="Insert Into Gsales(gid,sid,snum) Values(?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, gsales.getGid());
            pstmt.setInt(2, gsales.getSid());
            pstmt.setInt(3, gsales.getsNum());
            int rs=pstmt.executeUpdate();
            if (rs>0) {
                bool=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbClose.addClose(pstmt, conn);
        }
        return bool;
    }
}
