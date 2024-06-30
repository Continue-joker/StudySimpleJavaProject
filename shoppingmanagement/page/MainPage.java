package page;

import java.util.ArrayList;

import dao.SalesManDao;
import entity.SalesMan;
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
            System.out.println("输入有误,重新输入或按 0 返回上一级菜单.");
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

                        break;
                    case 1:

                        break;
                    case 2:
                        int loginTimes = 3;// 3次登陆机会

                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("---用户名---");
                            String sName =ScannerChoice.ScannerInfoString();
                            System.out.println("---密码---");
                            String sPssWord =ScannerChoice.ScannerInfoString();

                            ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName); // 以用户名从数据库中获取用户密码.

                            if (salesManInfo == null || salesManInfo.size() == 0)// 没有此用户的情况！
                            {
                                System.err.println("\t!!用户名输入有误!!\n");
                                System.out.println("\n剩余登陆次数：" + loginTimes);
                            } else {
                                SalesMan salesMan = salesManInfo.get(0);// 此地，只返回了一组数值，只遍历1次即可

                                if (sPssWord.equals(salesMan.getsPassWord()))// 验证密码，登陆成功了！！
                                {
                                    System.out.println("\t  ---账户成功登陆---");
                                    //shoppingSettlementPage(salesMan.getsId());// 参数为营业员编号sId
                                } else {
                                    System.err.println("\t!!密码错误!!\n");
                                    System.out.println("\n剩余登陆次数：" + loginTimes);
                                }
                            }
                        }
                        // loginTimes = 0
                        System.out.println("------------------");
                        System.err.println("\t！！您已被强制退出系统！！");
                        System.exit(-1);
                        break;

                    default:
                        break;
                }
            }
        } while (true);
    }

    /**
     * 3.商品管理界面
     */
    public static void commodityManagePage() {

    }

    /**
     * 4.购物结算界面
     */
    public static void shoppingSettlementPage() {

    }

    /**
     * 5.售货员管理界面
     */
    public static void salesmanManagementPage() {

    }
}
