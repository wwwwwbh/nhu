package cn.nhu.info;

import java.io.Serializable;

public class CKUsedInfo implements Serializable {
/*    SELECT A.CKUsedID, A.UserID, B.UserName, A.ProductID, C.ProductName, " +
            "D.ProductTypeID, D.ProductTypeName, " +
            "E.UnitID, E.UnitName, " +
            "A.ChuKu, A.IsReceived, A.TheDate */

    private Long CKusedid;
    private Long userid;
    private String username;
    private Long productid;
    private String productname;
    private Long productTypeid;
    private String productTypeName;
    private Long unitid;
    private String unitname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "CKUsedInfo{" +
                "CKusedid=" + CKusedid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productTypeid=" + productTypeid +
                ", productTypeName='" + productTypeName + '\'' +
                ", unitid=" + unitid +
                ", unitname='" + unitname + '\'' +
                ", chuku=" + chuku +
                ", thedate='" + thedate + '\'' +
                ", isreceived='" + isreceived + '\'' +
                '}';
    }
}
