package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GoodsDao;
import db.dbClose;
import db.dbConnect;
import entity.Goods;
import entity.SalesMan;

/**
 * 查询&&打印 函数工具(后期优化可能会删)
 */
public final class QueryPrint {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 模糊查询并陈列查询信息函数小工具
     * 
     * @param oper 调用者
     * @return 查询到的信息的gid,如果返回值等于-1，则代表查询异常。
     */
    public static int query(String oper) {
        int gid = -1;
        String goodsName = ScannerChoice.ScannerInfoString();
        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(-1, goodsName);

        if (goodsList == null | goodsList.size() <= 0) {
            System.out.println("查询不到" + goodsName + "产品！！");
            // 选则下一步操作
            ScannerChoice.changedInfoNext(oper);
        } else {
            Goods goods = goodsList.get(0);// 因为gname是unique
            System.out.println("\t\t\t\t\t商品列表\n\n");
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
            System.out.print("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t" + goods.getgPrice() + "\t\t"
                    + goods.getgNum());
            if (goods.getgNum() == 0) {
                System.out.println("\t\t该商品已售空");
            } else if (goods.getgNum() < 10) {
                System.out.println("\t\t该商品已不足10件！！");
            }
            gid = goods.getgId();
        }
        return gid;
    }

    /**
     * 模糊查询函数小工具
     * 当查询到产品首先进行打印商品信息，然后进行对gid赋值
     * 
     * @return int 当商品件数有且只有一件时返回商品gid号，商品已售空时返回 -1. >1件时返回-2 . 查无此商品时返回-3
     * 
     */
    public static int querySettlement() {
        int gid = -1;
        ArrayList<Goods> goodsSettlement = new GoodsDao().queryGoods(3);
        if (goodsSettlement == null || goodsSettlement.size() <= 0) {
            System.out.println("查询不到产品！！");
            // 选则下一步操作
            gid = -3;
        } else {
            System.out.println("\t\t\t\t\t商品列表\n\n");
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
            for (Goods goods : goodsSettlement) {
                System.out.print("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t" + goods.getgPrice()
							+ "\t\t" + goods.getgNum());

                if (goods.getgNum()==0) {
                   System.out.println("\t\t此商品售空.");
                }else if (goods.getgNum()<10) {
                    System.out.println("\t\t此商品不足10件");
                }else{
                    System.out.println("\t\t-");
                }
            }
            if (goodsSettlement.size()==1) {
                gid=goodsSettlement.get(0).getgId();
            }else{
                gid=-2;
            }
        }
        return gid;
    }

    /**
     * 根据商品的gid或gname查询商品
     * 
     * @param gId
     * @param gNmae
     * @return
     */
    public ArrayList<Goods> queryGoodsKey(int gId, String gNmae) {
        ArrayList<Goods> goodsList = new ArrayList<>();
        conn = dbConnect.getconn();

        String sql = "Select * from Goods Where gid=? OR gname=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gId);
            pstmt.setString(2, gNmae);

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
        return goodsList;
    }

    public ArrayList<SalesMan> querySalesMan(String sName) {

    }
}
