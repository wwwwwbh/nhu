package cn.nhu.info;

import java.io.Serializable;

public class CKInComeInfoByType implements Serializable {
    /*    A.ProductID ,B.ProductName ," +
                "C.ProductTypeID ,C.ProductTypeName ," +
                "D.UnitID ,D.UnitName ," +
                "A.RuKu ,A.TheDate " +*/
    private Long productid;
    private String productname;
    private Long productTypeid;
    private String productTypename;
    private Long unitid;
    private String unitname;
    private Double ruku;//入库量
    private String datetime;

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

    public String getProductTypename() {
        return productTypename;
    }

    public void setProductTypename(String productTypename) {
        this.productTypename = productTypename;
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

    public Double getRuku() {
        return ruku;
    }

    public void setRuku(Double ruku) {
        this.ruku = ruku;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "CKInComeInfoByType{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productTypeid=" + productTypeid +
                ", productTypename='" + productTypename + '\'' +
                ", unitid=" + unitid +
                ", unitname='" + unitname + '\'' +
                ", ruku=" + ruku +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
