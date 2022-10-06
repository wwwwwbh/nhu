package cn.nhu.info;

import java.io.Serializable;

public class DeptUsedInfoPlus implements Serializable {
    private Long deptusedid;
    private Long productid;
    private String productname;
    private Long productTypeid;
    private String productTypeName;
    private Long unitid;
    private String unitname;
    private Long userid;
    private String username;
    private Double usedSL;
    private String thedate;

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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Long getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Long productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Long getUnitid() {
        return unitid;
    }

    public void setUnitid(Long unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "DeptUsedInfoPlus{" +
                "deptusedid=" + deptusedid +
                ", productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productTypeid=" + productTypeid +
                ", productTypeName='" + productTypeName + '\'' +
                ", unitid=" + unitid +
                ", unitname='" + unitname + '\'' +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", usedSL=" + usedSL +
                ", thedate='" + thedate + '\'' +
                '}';
    }
}
