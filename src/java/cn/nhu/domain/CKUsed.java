package cn.nhu.domain;

import java.io.Serializable;

//仓库出库表
public class CKUsed implements Serializable {
    private Long CKusedid;
    private Long userid;
    private Long productid;
    private Double chuku;//出库量
    private String thedate;
    private String isreceived;

    public Long getCKusedid() {
        return CKusedid;
    }

    public void setCKusedid(Long CKusedid) {
        this.CKusedid = CKusedid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Double getChuku() {
        return chuku;
    }

    public void setChuku(Double chuku) {
        this.chuku = chuku;
    }

    public String getThedate() {
        return thedate;
    }

    public void setThedate(String thedate) {
        this.thedate = thedate;
    }

    public String getIsreceived() {
        return isreceived;
    }

    public void setIsreceived(String isreceived) {
        this.isreceived = isreceived;
    }

    @Override
    public String toString() {
        return "CKUsed{" +
                "CKusedid=" + CKusedid +
                ", userid=" + userid +
                ", productid=" + productid +
                ", chuku=" + chuku +
                ", thedate='" + thedate + '\'' +
                ", isreceived='" + isreceived + '\'' +
                '}';
    }
}
