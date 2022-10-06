package cn.nhu.domain;

import java.io.Serializable;

/**
 * 产品类型类，固定四种产品类型
 */
public class ProductType implements Serializable {
    private Long productTypeid;
    private String productTypeName;
    private String iseffective;

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

    public String getIseffective() {
        return iseffective;
    }

    public void setIseffective(String iseffective) {
        this.iseffective = iseffective;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeid=" + productTypeid +
                ", productTypeName='" + productTypeName + '\'' +
                ", iseffective='" + iseffective + '\'' +
                '}';
    }
}
