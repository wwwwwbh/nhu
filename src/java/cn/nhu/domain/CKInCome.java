package cn.nhu.domain;

import java.io.Serializable;

//仓库入库表
public class CKInCome implements Serializable {
    private Long CKincomeid;
    private Long productid;
    private Double ruku;//入库量
    private String thedate;

    public Long getCKincomeid() {
        return CKincomeid;
    }

    public void setCKincomeid(Long CKincomeid) {
        this.CKincomeid = CKincomeid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Double getRuku() {
        return ruku;
    }

    public void setRuku(Double ruku) {
        this.ruku = ruku;
    }

    public String getThedate() {
        return thedate;
    }

    public void setThedate(String thedate) {
        this.thedate = thedate;
    }

    @Override
    public String toString() {
        return "CKInCome{" +
                "CKincomeid=" + CKincomeid +
                ", productid=" + productid +
                ", ruku=" + ruku +
                ", thedate='" + thedate + '\'' +
                '}';
    }
}
