package cn.nhu.info;

import java.io.Serializable;

public class ProductUnitInfoPlus implements Serializable {

    private Long productid;
    private String productname;
    private String iseffective;
    private String productTypeid;
    private String productTypeName;
    private String unitid;
    private String unitname;

    public String getIseffective() {
        return iseffective;
    }

    public void setIseffective(String iseffective) {
        this.iseffective = iseffective;
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

    public String getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(String productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
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
        return "ProductUnitInfoPlus{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", iseffective='" + iseffective + '\'' +
                ", productTypeid='" + productTypeid + '\'' +
                ", productTypeName='" + productTypeName + '\'' +
                ", unitid='" + unitid + '\'' +
                ", unitname='" + unitname + '\'' +
                '}';
    }

}
