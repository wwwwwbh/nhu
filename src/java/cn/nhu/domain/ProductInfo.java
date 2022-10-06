package cn.nhu.domain;


/**
 * 完整的产品信息类
 */
public class ProductInfo extends Product {

    private String remark;
    private String iseffective;
    private Long productTypeid;
    private Long unitid;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIseffective() {
        return iseffective;
    }

    public void setIseffective(String iseffective) {
        this.iseffective = iseffective;
    }

    public Long getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Long productTypeid) {
        this.productTypeid = productTypeid;
    }

    public Long getUnitid() {
        return unitid;
    }

    public void setUnitid(Long unitid) {
        this.unitid = unitid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + getProductid() +
                ", productname='" + getProductname() + '\'' +
                ", remark='" + remark + '\'' +
                ", iseffective='" + iseffective + '\'' +
                ", productTypeid=" + productTypeid +
                ", unitid=" + unitid +
                '}';
    }
}
