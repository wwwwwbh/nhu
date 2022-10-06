package cn.nhu.domain;

//部门使用表

import java.io.Serializable;

public class DeptUsed implements Serializable {
    private Long deptusedid;
    private Long productid;
    private Long userid;
    private Double usedSL; //使用量,decimal(18,2)
    private String thedate;//用YY-MM-DD HH:mm:ss格式

    public Long getDeptusedid() {
        return deptusedid;
    }

    public void setDeptusedid(Long deptusedid) {
        this.deptusedid = deptusedid;
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

    public Double getUsedSL() {
        return usedSL;
    }

    public void setUsedSL(Double usedSL) {
        this.usedSL = usedSL;
    }

    public String getThedate() {
        return thedate;
    }

    public void setThedate(String thedate) {
        this.thedate = thedate;
    }

    @Override
    public String toString() {
        return "DeptUsed{" +
                "deptusedid=" + deptusedid +
                ", productid=" + productid +
                ", userid=" + userid +
                ", usedSL=" + usedSL +
                ", thedate='" + thedate + '\'' +
                '}';
    }
}
