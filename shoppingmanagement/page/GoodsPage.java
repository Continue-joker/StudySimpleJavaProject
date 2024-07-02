package page;

import java.util.ArrayList;

import dao.GoodsDao;
import entity.Goods;
import tools.ScannerChoice;

/**
 * 商品操作页
 */
public final class GoodsPage {
    /**
     * 添加商品
     */
    public static void addGoodsPage() {
        System.out.println("\t正在执行添加商品操作\n");

        System.out.println("\n請輸入添加商品-名称");
        String goodsName = ScannerChoice.ScannerInfoString();

        System.out.println("\n請輸入添加商品-价格");
        double goodsPrice = ScannerChoice.ScannerInfo();

        System.out.println("\n請輸入添加商品-数量");
        int goodsNum = ScannerChoice.ScannerNum();

        Goods goods = new Goods(goodsName, goodsPrice, goodsNum);

        boolean bool = new GoodsDao().addGoods(goods);
        if (bool) {
            System.out.println("\n\t!您已成功添加商品到数据库!");
        } else {
            System.out.println("添加商品失败");
        }
        ScannerChoice.changedInfoNext("addGoodsPage");// 选择下一步,继续添加下一个产品

    }

    /**
     * 更新商品
     */
    public static void updateGoodsPage() {

    }

    /**
     * 删除商品
     */
    public static void deleteGoodsPage() {

    }

    /**
     * 查询商品
     */
    public static void queryGoodsPage() {

    }

    /**
     * 展示商品
     */
    public static void displayGoodsPage() {
        System.out.println("\t\t\t\t\t所有商品列表\n\n");
        ArrayList<Goods> goodsList = new GoodsDao().display();
        if (goodsList.size() <= 0) {
            System.out.println("--库存为空，自动跳转商品管理界面--");
            MainPage.MaintenancePage();
        } else {
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
            for (Goods goods : goodsList) {
                System.out.print("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t"
                        + goods.getgPrice() + "￥\t\t" + goods.getgNum() + "\t\t");

                if (goods.getgNum() == 0) {
                    System.out.println("该商品已售罄");
                } else if (goods.getgNum() < 10) {
                    System.out.println("该商品已不足10件");
                } else {
                    System.out.println("--");
                }

                // 下一步
                System.out.println("---------------------");
                do {
                    System.out.println("输入 0 返回上一级菜单");
                    String choice = ScannerChoice.ScannerInfoString();
                    if (choice.equals("0")) {
                        MainPage.MaintenancePage();
                    }
                    System.out.println("输入有误！");
                } while (true);
            }
        }

    }
}
