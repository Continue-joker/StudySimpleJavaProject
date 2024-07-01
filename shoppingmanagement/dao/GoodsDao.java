package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.dbClose;
import db.dbConnect;
import entity.Goods;
import tools.ScannerChoice;

public final class GoodsDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 2.更改商品信息到数据库goods表
     * 
     * @param key   选择要更改商品信息
     * @param goods 商品对象
     * @return boolean
     */
    public boolean updateGoods(int key, Goods goods) {
        boolean bool = false;
        conn = dbConnect.getconn();
        switch (key) {
            case 1:// 改名
                String slqName = "Update Goods Set gname=? Where gid=?";
                try {
                    pstmt = conn.prepareStatement(slqName);
                    pstmt.setString(1, goods.getgName());
                    pstmt.setInt(2, goods.getgId());

                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.addClose(pstmt, conn);
                }
                break;
            case 2:// 改价
                String sqlPrice = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
                try {
                    pstmt = conn.prepareStatement(sqlPrice);
                    pstmt.setDouble(1, goods.getgPrice());
                    pstmt.setInt(2, goods.getgId());

                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.addClose(pstmt, conn);
                }
                break;
            case 3:// 改库存
                String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";
                try {
                    pstmt=conn.prepareStatement(sqlNum);
                    pstmt.setInt(1, goods.getgNum());
                    pstmt.setInt(2, goods.getgId());

                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        bool = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.addClose(pstmt, conn);
                }
                break;

            default:
                break;
        }
        return bool;
    }

    /**
     * 4.查询商品信息
     * 
     * @param key 查询方式
     * @return ArrayList<Goods>
     */
    public ArrayList<Goods> queryGoods(int key) {
        ArrayList<Goods> goodsList = new ArrayList<>();
        conn = dbConnect.getconn();

        switch (key) {
            case 1:// 查询所有商品，且按gnum升序
                String sql = "Select * From Goods OrderBy gnum ASC";
                try {
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int gid = rs.getInt(1);
                        String gname = rs.getString(2);
                        double gprice = rs.getDouble(3);
                        int gnum = rs.getInt(4);

                        Goods goods = new Goods(gid, gname, gprice, gnum);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.queryClose(pstmt, rs, conn);
                }
                break;
            case 2:// 查询所有商品，且按价格升序
                String sqlGprice = "SELECT * FROM GOODS ORDER BY GPRICE ASC";
                try {
                    pstmt = conn.prepareStatement(sqlGprice);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int gid = rs.getInt("gid");
                        String gname = rs.getString(2);
                        double gprice = rs.getDouble(3);
                        int gnum = rs.getInt(4);

                        Goods goods = new Goods(gid, gname, gprice, gnum);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.queryClose(pstmt, rs, conn);
                }
                break;
            case 3:// 根据输入的商品名进行模糊查询,
                String goodsName = ScannerChoice.ScannerInfoString();
                //注意mysql的连接方式
                String sqlSerch = "SELECT * FROM GOODS WHERE GNAME LIKE CONCAT('%', ?, '%')";
                try {
                    pstmt = conn.prepareStatement(sqlSerch);
                    System.out.println("Searching for goodsName: " + goodsName);
                    pstmt.setString(1, goodsName);
                    System.out.println("Executing SQL query: " + pstmt.toString());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int gid = rs.getInt("gid");
                        String gname = rs.getString(2);
                        double gprice = rs.getDouble(3);
                        int gnum = rs.getInt(4);

                        Goods goods = new Goods(gid, gname, gprice, gnum);
                        goodsList.add(goods);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    dbClose.queryClose(pstmt, rs, conn);
                }
                break;

            default:
                break;
        }
        return goodsList;
    }
}
