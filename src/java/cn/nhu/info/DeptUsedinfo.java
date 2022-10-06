package cn.nhu.info;

import java.io.Serializable;

public class DeptUsedinfo implements Serializable {
    private Long productid;
    private Double usedSL;
    private String thedate;
    private Long productTypeid;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
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

    public Long getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Long productTypeid) {
        this.productTypeid = productTypeid;
    }

    @Override
    public String toString() {
        return "DeptUsedinfo{" +
                "productid=" + productid +
                ", usedSL=" + usedSL +
                ", thedate='" + thedate + '\'' +
                ", productTypeid=" + productTypeid +
                '}';
    }
}
