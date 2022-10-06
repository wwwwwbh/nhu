package cn.nhu.service.impl;

import cn.nhu.dao.ProductTypeDao;
import cn.nhu.domain.ProductType;
import cn.nhu.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    //返回四种危险品类型
    public String[] getProductTypeList() {
        List<ProductType> typeArrList = productTypeDao.getProductTypeList();
        String[] typeArr = new String[4];
        for (int i = 0; i < 4; i++) {
            typeArr[i] = typeArrList.get(i).getProductTypeName();
        }
        return typeArr;
    }

    //存放12个月份
    public Map<String, String> getMonthMap() {
        //LinkedHashMap有序，HashMap无序
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 1; i < 13; i++) {
            map.put(String.valueOf(i), i + "月");
        }
        return map;
    }
}
