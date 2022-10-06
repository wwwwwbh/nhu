package cn.nhu.service;

import cn.nhu.domain.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> findAll();
    int updateUnit(Unit unit);
    int insertUnit(String unitname,String iseffective);
}
