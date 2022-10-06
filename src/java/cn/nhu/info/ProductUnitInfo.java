package cn.nhu.info;

import java.io.Serializable;

public class ProductUnitInfo implements Serializable {
    private String productname;
    private Long productid;
    private String unitname;

    public ProductUnitInfo(String productname, Long productid, String unitname) {
        super();
        this.productname = productname;
        this.productid = productid;
        this.unitname = unitname;
    }

    public ProductUnitInfo(){
        super();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    @Override
    public String toString() {
        return "ProductUnitInfo{" +
                "productname='" + productname + '\'' +
                ", productid=" + productid +
                ", unitname='" + unitname + '\'' +
                '}';
    }
}
