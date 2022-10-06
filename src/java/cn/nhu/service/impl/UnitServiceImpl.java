package cn.nhu.service.impl;
import cn.nhu.dao.UnitDao;
import cn.nhu.domain.Unit;
import cn.nhu.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UnitService")
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    public List<Unit> findAll(){
        return unitDao.findAll();
    }

    public int updateUnit(Unit unit){
        return unitDao.updateUnit(unit);
    }
    public int insertUnit(String unitname,String iseffective){
        return unitDao.insertUnit(unitname,iseffective);
    }



}
