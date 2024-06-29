package page;

import java.util.Scanner;

public class MainPage extends ScannerC {
    public static void mianPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收银\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按0退出.");

        do {
            Scanner scanner = new Scanner(System.in);
            // Prompt the user to enter a string
            System.out.print("Enter a choice: ");
            String choice=scanner.nextLine();
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
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                
                    default:
                        break;
                }
            }

        } while ();
    }
}
