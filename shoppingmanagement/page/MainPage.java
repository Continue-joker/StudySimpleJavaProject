package page;

import java.util.ArrayList;

import dao.GoodsDao;
import dao.GsalesDao;
import dao.SalesManDao;
import entity.Goods;
import entity.Gsales;
import entity.SalesMan;
import tools.BigDecimalArith;
import tools.QueryPrint;
import tools.ScannerChoice;

/*
 * 购物管理系统，首页 
 */
public final class MainPage {
    /*
     * 主页
     */
    public static void mianPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收银\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按0退出.");

        do {
            // Prompt the user to enter a string
            System.out.print("Enter a choice: ");
            String choice = ScannerChoice.ScannerInfoString();
            String regex = "[0-3]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(-1);// 退出程序，返回值随便设置
                        break;
                    case 1:
                        MaintenancePage();
                        break;
                    case 2:
                        checkStandLogPage();
                        break;
                    case 3:
                        commodityManagePage();
                        break;
                    default:
                        break;
                }
            }
            System.out.println("输入有误,重新输入或按 0 返回上一级菜单.");
        } while (true);
    }

    /**
     * 1.商品维护界面
     */
    public static void MaintenancePage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.添加商品\n");
        System.out.println("\t 2.更改商品\n");
        System.out.println("\t 3.删除商品\n");
        System.out.println("\t 4.查询商品\n");
        System.out.println("\t 5.显示所有商品\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        do {
            String choice = ScannerChoice.ScannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mianPage();
                        break;
                    case 1:
                        GoodsPage.addGoodsPage();
                        break;
                    case 2:
                        GoodsPage.updateGoodsPage();
                        break;
                    case 3:
                        GoodsPage.deleteGoodsPage();
                        break;
                    case 4:
                        GoodsPage.queryGoodsPage();
                        break;
                    case 5:
                        GoodsPage.displayGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("输入有误,重新输入或按 0 返回上一级菜单.");
        } while (true);

    }

    /**
     * 2.前台收银登录界面
     */
    public static void checkStandLogPage() {
        System.out.println("\n*******欢迎使用商超购物管理系统*******\n");
        System.out.println("\t 1.登录系统\n");
        System.out.println("\t 2.退出\n");
        System.out.println("-----------------------------");
        System.out.println("请输入选项,或者按 0 返回上一级菜单.");
        do {
            String choice = ScannerChoice.ScannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mianPage();
                        break;
                    case 1:
                        int loginTimes = 3;// 3次登陆机会

                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("---用户名---");
                            String sName = ScannerChoice.ScannerInfoString();
                            System.out.println("---密码---");
                            String sPssWord = ScannerChoice.ScannerInfoString();

                            ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName); // 以用户名从数据库中获取用户密码.

                            if (salesManInfo == null || salesManInfo.size() == 0)// 没有此用户的情况！
                            {
                                System.err.println("\n用户名输入有误,剩余登陆次数：" + loginTimes);
                            } else {
                                SalesMan salesMan = salesManInfo.get(0);// 此地，只返回了一组数值，只遍历1次即可

                                if (sPssWord.equals(salesMan.getsPassWord()))// 验证密码，登陆成功了！！
                                {
                                    System.out.println("\t  ---账户成功登陆---");
                                    shoppingSettlementPage(salesMan.getsId());// 参数为营业员编号sId
                                } else {
                                    System.err.println("\n密码错误，剩余登陆次数：" + loginTimes);
                                }
                            }
                        }
                        // loginTimes = 0
                        System.out.println("------------------");
                        System.err.println("\t！！您已被强制退出系统！！");
                        System.exit(-1);
                        break;
                    case 2:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(-1);
                        break;

                    default:
                        break;
                }
            }
            System.err.println("输入有误,重新输入或按 0 返回上一级菜单.");
        } while (true);
    }

    /**
     * 3.商品管理界面
     */
    public static void commodityManagePage() {
        System.out.println("***************************\n");
		System.out.println("\t 1.售货员管理\n");
		System.out.println("\t 2.列出当日卖出列表\n");
		System.out.println("***************************");

		System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
		do {
			String choice =ScannerChoice.ScannerInfoString();
			String regex = "[0-2]";
			if (choice.matches(regex)) {
				int info = Integer.parseInt(choice);
				switch (info) {
					case 0:
						mianPage();
						break;
					case 1:
						salesmanManagementPage();
						break;
					case 2:
						GsalesPage.dailySaleGoodsPage();
						break;
					default:
						break;
				}
    }

    /**
     * 4.购物结算界面
     * 注意：一次只能结算一款产品，可以优化为一个订单多个产品
     * 其中是以收银员角度的结算，类似商场用“扫码枪”一个一个录入系统结算的模式
     */
    public static void shoppingSettlementPage(int salesManId) {
        System.out.println("\n\t*******购物结算*******\n");
        do {
            System.out.println("按 S 开始购物结算.按 0 返回账户登录界面");
            String choice = ScannerChoice.ScannerInfoString();
            if (choice.equals("0")) {
                checkStandLogPage();
            } else if (choice.equals("s") | choice.equals("S")) {
                System.out.println("\n--请输入商品名关键字--");
                int gid = QueryPrint.querySettlement();
                switch (gid) {
                    case -3:
                        // 查询不到产品继续循环
                        break;
                    case -1:
                        System.err.println("\t--抱歉，该商品已售空--");
                        break;
                    default:// 模糊查询到产品，进行准确搜索，进行进一步操作
                        System.out.println("--按商品编号选择商品--");
                        // 传参gid，调用精确查询商品
                        int gidagain = ScannerChoice.ScannerNum();
                        ArrayList<Goods> goods = new QueryPrint().queryGoodsKey(gidagain, null);
                        if (goods == null | goods.size() == 0) {
                            System.err.println("--查无此产品--");
                        } else {
                            Goods tmpGoods = goods.get(0);// -----实际下单的单个产品
                            int gnum = tmpGoods.getgNum();
                            double gprice = tmpGoods.getgPrice();
                            System.out.println("--请输入购买数量--");
                            do {
                                int choiceGoodsNums = ScannerChoice.ScannerNum();
                                if (choiceGoodsNums > gnum) {
                                    System.err.println("\t！！仓库储备不足！！");
                                    System.out.println("--请重新输入购买数量--");
                                } else {
                                    Double allPrice = BigDecimalArith.mul(gprice, choiceGoodsNums);
                                    System.out.println("\t\t\t  购物车结算\n");
                                    System.out.println("\t\t商品名称\t商品单价\t购买数量\t总价\n");
                                    System.out.println("\t\t" + tmpGoods.getgName() + "\t" + gprice + " $\t"
                                            + choiceGoodsNums + "\t" + allPrice + " $\n");
                                    do {
                                        System.out.println("确认购买：Y/N");
                                        String choiceBuy = ScannerChoice.ScannerInfoString();
                                        if (choiceBuy.equals("y") | choiceBuy.equals("Y")) {
                                            System.out.println("\n总价：" + allPrice + " $");
                                            System.out.println("\n实际缴费金额");
                                            do {
                                                double amount = ScannerChoice.ScannerInfo();
                                                double balance = BigDecimalArith.sub(amount, choiceGoodsNums);
                                                if (balance < 0) {
                                                    System.err.println("\t--缴纳金额不足，请重新输入缴纳金额($)");
                                                } else {
                                                    /*
                                                     * 这里是购物结算操作数据库！！！！！！----------------------
                                                     * 1.更改goods表数量
                                                     * 2.增加gsales表数量
                                                     * 原商品数量gNum。 结算员Id salesManSid
                                                     */

                                                    // 对gsales表操作
                                                    Gsales gsales = new Gsales(gid, salesManId, choiceGoodsNums);
                                                    boolean update = new GsalesDao().shoppingSettlement(gsales);

                                                    // 对goods表操作
                                                    int nowNum = tmpGoods.getgNum() - choiceGoodsNums;
                                                    Goods updateGoods = new Goods(gidagain, nowNum);
                                                    boolean updateNum = new GoodsDao().updateGoods(3, updateGoods);

                                                    if (update && updateNum) {
                                                        System.out.println("找零：" + balance);
                                                        System.out.println("\n谢谢光临，欢迎下次惠顾");
                                                    } else {
                                                        System.err.println("！支付失败！"); // 出现这个错误一定是数据库操作有问题！
                                                    }
                                                    shoppingSettlementPage(salesManId);// 最后跳转到到购物结算页面
                                                    // 结束购物结算操作数据库！！！！！！-----------------------------------

                                                }
                                            } while (true);
                                        } else if (choiceBuy.equals("y") | choiceBuy.equals("Y")) {
                                            shoppingSettlementPage(salesManId);
                                        }
                                        System.err.println("\t！！请确认购物意向！！");
                                    } while (true);
                                }
                            } while (true);
                        }

                        break;
                }
            } else {
                System.err.println("\t!!请输入合法字符!!\n");
            }
        } while (true);
    }

    /**
     * 5.售货员管理界面
     */
    public static void salesmanManagementPage() {

    }
}
