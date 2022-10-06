package cn.nhu.info;

import java.io.Serializable;

public class ColumnInfo implements Serializable {
    private String productunitname;
    private Long productid;

    public ColumnInfo() {
    }

    public ColumnInfo(String name, Long id) {
        this.productunitname = name;
        this.productid = id;
    }

    public String getProductunitname() {
        return productunitname;
    }

    public void setProductunitname(String productunitname) {
        this.productunitname = productunitname;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "productunitname='" + productunitname + '\'' +
                ", productid=" + productid +
                '}';
    }
}
