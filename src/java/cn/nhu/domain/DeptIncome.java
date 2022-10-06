package cn.nhu.domain;

import java.io.Serializable;

//部门领用表
public class DeptIncome implements Serializable {

    private Long deptIncomeid;
    private Long productid;
    private Long userid;
    private Double incomeSL;//领用量
    private String datetime;
    private Long CKusedid; //CK:仓库

    public Long getDeptIncomeid() {
        return deptIncomeid;
    }

    public void setDeptIncomeid(Long deptIncomeid) {
        this.deptIncomeid = deptIncomeid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Double getIncomeSL() {
        return incomeSL;
    }

    public void setIncomeSL(Double incomeSL) {
        this.incomeSL = incomeSL;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Long getCKusedid() {
        return CKusedid;
    }

    public void setCKusedid(Long CKusedid) {
        this.CKusedid = CKusedid;
    }

    @Override
    public String toString() {
        return "DeptIncome{" +
                "deptIncomeid=" + deptIncomeid +
                ", productid=" + productid +
                ", userid=" + userid +
                ", incomeSL=" + incomeSL +
                ", datetime='" + datetime + '\'' +
                ", CKusedid=" + CKusedid +
                '}';
    }
}
