package tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**  
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精  
 * 确的浮点数运算，包括加减乘除和四舍五入.
 * 
 * 注意：此代码将加减乘除四舍五入方法已实现，但本项目中并未全部使用.
 * 
 */ 
public class BigDecimalArith {
    private final static int DEF_DIV_SCALE=2;
    private BigDecimalArith(){}

    /**  
	* 提供精确的加法运算。  
	* @param v1 被加数  
	* @param v2 加数  
	* @return 两个参数的和  
	*/  
    public static double add(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));
        BigDecimal b2=new BigDecimal(Double.toString(v2));

        return b1.add(b2).doubleValue();
    }

     /**  
	* 提供精确的减法运算。  
	* @param v1 被减数  
	* @param v2 减数  
	* @return 两个参数的差  
	*/  
    public static double sub(double v1,double v2){
        BigDecimal b1=new BigDecimal(Double.toString(v1));
        BigDecimal b2=new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**  
	* 提供精确的乘法运算。  
	* @param v1 被乘数  
	* @param v2 乘数  
	* @return 两个参数的积  
	*/  
	public static double mul(double v1,double v2)
	{   
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));   
		return b1.multiply(b2).doubleValue();   
	}   

    /**  
	* 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指  
	* 定精度，以后的数字四舍五入。  
	* @param v1 被除数  
	* @param v2 除数  
	* @param scale 表示表示需要精确到小数点以后几位。  
	* @return 两个参数的商  
	*/  
	public static double div(double v1,double v2,int scale){
        if (scale<0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero....");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

        //银行家舍入法通常用于金融应用或其他需要避免偏向某一方向的舍入情况。 
        return b1.divide(b2,scale,RoundingMode.HALF_EVEN).doubleValue();
    }



}
