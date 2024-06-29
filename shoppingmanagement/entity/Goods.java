package entity;

public class Goods {
    private int gId;//主键
    private String gName;
    private double gPrice;
    private int gNum;




    /**
     * 添加商品信息
     */
    public Goods(String gName, double gPrice, int gNum) {
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNum = gNum;
    }
    /**
     * 展示商品所有信息
     */
    public Goods(int gId, String gName, double gPrice, int gNum) {
        this.gId = gId;
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNum = gNum;
    }
    
    /**
     * 根据id改价格
     * @param gid
     * @param gprice
     */
    public Goods(int gId, double gPrice) {
        this.gId = gId;
        this.gPrice = gPrice;
    }
    
    /**
     * 根据id改名字
     * @param gid
     * @param gname
     */
    public Goods(int gId, String gName) {
        this.gId = gId;
        this.gName = gName;
    }
    

    /**
     * 根据id改商品数量
     * @param gid
     * @param gnum
     */
    public Goods(int gId, int gNum) {
        this.gId = gId;
        this.gNum = gNum;
    }
    
    
    //get-set方法
    public int getgId() {
        return gId;
    }
    public void setgId(int gId) {
        this.gId = gId;
    }
    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
    }
    public double getgPrice() {
        return gPrice;
    }
    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }
    public int getgNum() {
        return gNum;
    }
    public void setgNum(int gNum) {
        this.gNum = gNum;
    }
}
