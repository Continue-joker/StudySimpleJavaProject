package page;

import tools.ScannerChoice;
/*
 * 购物管理系统，首页
 */
public final class MainPage{
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
            String choice=ScannerChoice.ScannerInfoString();
            String regex="[0-3]";
            if (choice.matches(regex)) {
                int info=Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(-1);//退出程序，返回值随便设置
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

        } while (true);
    }

    /**
     * 1.商品维护界面
     */
    public static void MaintenancePage() {

    }

    /**
     * 2.前台收银登录界面
     */
    public static void checkStandLogPage() {

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
