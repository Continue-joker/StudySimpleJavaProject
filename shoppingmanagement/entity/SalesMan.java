package entity;

public class SalesMan {
    private int sId;
    private String sName;
    private String sPassWord;
    /**
     * 登录
     */
    public SalesMan(int sId, String sPassWord) {
        this.sId = sId;
        this.sPassWord = sPassWord;
    }
    /**
     * 根据id修改用户名及密码
     */
    public SalesMan(int sId, String sName, String sPassWord) {
        this.sId = sId;
        this.sName = sName;
        this.sPassWord = sPassWord;
    }
    /**
     * 添加用户
     */
    public SalesMan(String sName, String sPassWord) {
        this.sName = sName;
        this.sPassWord = sPassWord;
    }

    //get-set
    public int getsId() {
        return sId;
    }
    public void setsId(int sId) {
        this.sId = sId;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public String getsPassWord() {
        return sPassWord;
    }
    public void setsPassWord(String sPassWord) {
        this.sPassWord = sPassWord;
    }

    
}
