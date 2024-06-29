package entity;

public class Gsales {
    private int gsid;
    private int gid;
    private int sid;
    private int sNum;//购买商品的数量

    private String gname;
    private Double gprice;
    private int gnum;//商品库存
    private int allSnum;//单品商品销量总和

    /**
     * 展示商品列表
     */
    public Gsales(String gname, Double gprice, int gnum, int allSnum) {
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
        this.allSnum = allSnum;
    }
    /**
     * 订单-商品结算
     */
    public Gsales(int gid, int sid, int sNum) {
        this.gid = gid;
        this.sid = sid;
        this.sNum = sNum;
    }

     //get-set
    public int getGsid() {
        return gsid;
    }
    public void setGsid(int gsid) {
        this.gsid = gsid;
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getsNum() {
        return sNum;
    }
    public void setsNum(int sNum) {
        this.sNum = sNum;
    }
    public String getGname() {
        return gname;
    }
    public void setGname(String gname) {
        this.gname = gname;
    }
    public Double getGprice() {
        return gprice;
    }
    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }
    public int getGnum() {
        return gnum;
    }
    public void setGnum(int gnum) {
        this.gnum = gnum;
    }
    public int getAllSnum() {
        return allSnum;
    }
    public void setAllSnum(int allSnum) {
        this.allSnum = allSnum;
    }

   
    
    

    
}
