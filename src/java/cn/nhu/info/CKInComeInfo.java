package cn.nhu.info;

import cn.nhu.domain.CKInCome;

import java.io.Serializable;

public class CKInComeInfo extends CKInCome implements Serializable {
/*
    SELECT A.CKInComeID, A.ProductID, " +
            "B.ProductName, C.ProductTypeID, C.ProductTypeName," +
            "D.UnitID,D.UnitName,A.RuKu ,A.TheDate " +*/

    private String productname;
    private Long productTypeid;
    private String productTypeName;
    private Long unitid;
    private String unitname;

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

    @Override
    public String toString() {
        return "CKInComeInfo{" +
                "CKincomeid=" + getCKincomeid() +
                ", productid=" + getProductid() +
                ", productname='" + productname + '\'' +
                ", productTypeid=" + productTypeid +
                ", productTypeName='" + productTypeName + '\'' +
                ", unitid=" + unitid +
                ", unitname='" + unitname + '\'' +
                ", ruku=" + getRuku() +
                ", datetime='" + getThedate() + '\'' +
                '}';
    }
}
