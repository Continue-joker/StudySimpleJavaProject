package tools;

import java.util.Scanner;

import entity.Goods;
import page.GoodsPage;
import page.MainPage;
import page.SalsesManPage;

public class ScannerChoice {
    /**
     * 输入工具类：
     * 1.控制输入格式
     * 2.界面交互
     */

    /**
     * \. 和\\. 在正则表达式中是不同的。
     * \. - 这个正则表达式用来匹配一个点字符.。点字符在正则表达式中是特殊字符，它可以匹配除了换行符之外的任意字符。
     * 为了匹配一个真正的点号字符，我们需要使用反斜杠进行转义，即\.。 例如，a.、b.、c.等。
     * 
     * \\. - 这个正则表达式用来匹配一个带有反斜杠的点字符，即\.。在正则表达式中，反斜杠\是一个特殊字符，
     * 它用于转义其他字符，将其从特殊字符转变为普通字符。如果我们想要匹配一个真正的反斜杠加点号的组合，
     * 我们需要使用两个反斜杠进行转义，即\\.。 例如，a\.、b\.、c\.等。
     */

    // [1-9][0-9]* 和 ([1-9])|([1-9][0-9]+) 这两个正则表达式都用于匹配大于等于1的整数。

    /**
     * 键盘输入商品价格，输入格式小数点后2位小数
     * 不涉及计算，不考虑四舍五入
     * 
     * 可优化为键入的整数和1位小数自动后边补0！！！！！！！！！
     * @return double
     */
    public static double ScannerInfo() {
        double num = 0.00;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("保留小数点后两位,请输入：");
            String info = sc.next();

            String regex="(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//小数点后2位小数
            if (info.matches(regex)) {
                num=Double.parseDouble(info);
            }else{
                System.err.println("输入有误,重新输入xxxx.xx");
                continue;
            }
            break;
        } while (true);
        return num;
    }
    /**
     * 键入正整数，产品的数量
     */
    public static int ScannerNum(){
        int num=0;
       do {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入正整数：");
        String nums=sc.next();

        String regex="([1-9])|([1-9][0-9]+)";//商品数量

        if (nums.matches(regex)) {
            num=Integer.parseInt(nums);
        }else{
            System.err.println("输入有误,重新输入xxxx");
            continue;
        }
        break;
       } while (true);
       return num;
    }

    /**
	 * @return String 获取的键盘输入
	 */
	public static String ScannerInfoString()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入：");
		return scanner.next();
	}


    /**
	 * 获取用户-更改完商品-下一步
	 * 获取用户-删除完商品-下一步
	 * 获取用户-添加完商品-下一步
	 * 
	 * @param 调用者
	 */
    public static void changedInfoNext(String oper){
        do {
            System.out.println("是否继续当前操作：（Y/N）");
            String choice=ScannerInfoString();
            //在JAVA中: Equals比较的是值,==比较的是地址
            if (choice.equals("y")|choice.equals("Y")) {
                if (oper.equals("updateGoods")) {
                    GoodsPage.updateGoodsPage();
                }else if (oper.equals("deleteGoods")) {
                    GoodsPage.deleteGoodsPage();
                }else if (oper.equals("addGoods")) {
                    GoodsPage.addGoodsPage();
                }
            }else if (choice.equals("n")|choice.equals("N")) {
                MainPage.MaintenancePage();
            }
            System.err.println("输入错误，请重新输入：（Y/N）");
        } while (true);
    }

    public static void choiceSalsesManNext(String oper){
        do {
            System.out.println("是否继续当前操作：（Y/N）");
            String choice=ScannerInfoString();
            if (choice.equals("y")|choice.equals("Y")) {
                if (oper.equals("updateSalesMan")) {
                    SalsesManPage.updateSalesManPage();
                }else if (oper.equals("deleteSalesMan")) {
                    SalsesManPage.deleteSalesManPage();
                }else if (oper.equals("addSalesMan")) {
                    SalsesManPage.addSalesManPage();
                }else if (oper.equals("querySalesMan")) {
                    SalsesManPage.querySalesManPage();
                }
            }else if (choice.equals("n")|choice.equals("N")) {
                MainPage.MaintenancePage();
            }
            System.err.println("输入错误，请重新输入：（Y/N）");
        } while (true);
    }



}
