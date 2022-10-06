package cn.nhu.domain;


import java.io.Serializable;

/**
 * 单元类
 */
public class Unit implements Serializable {
    private Long unitid;
    private String unitname;
    private String isiseffective;

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

    public String getIsiseffective() {
        return isiseffective;
    }

    public void setIsiseffective(String isiseffective) {
        this.isiseffective = isiseffective;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitid=" + unitid +
                ", unitname='" + unitname + '\'' +
                ", isiseffective='" + isiseffective + '\'' +
                '}';
    }
}
