package cn.nhu.test;

import cn.nhu.domain.Product;

import cn.nhu.domain.ProductInfo;
import cn.nhu.domain.ProductType;
import cn.nhu.info.*;
import cn.nhu.service.CKUsedService;
import cn.nhu.service.ProductService;
import cn.nhu.service.ProductTypeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TestSpring {

    @Test
    public void run1() throws SQLException {
        //加载配置文件，产生所有bean，扫描cn.nhu.domain
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:nhuApplicationContext.xml");
        //通过bean获得对象实体
        CKUsedService us = (CKUsedService) ac.getBean("ckUsedService");
        StartStopDate testDate = new StartStopDate("2019","12");
        System.out.println(testDate.getStartDate());
        System.out.println(testDate.getStopDate());
        System.out.println(StartStopDate.getMinMonthDate());
        System.out.println(StartStopDate.getNextMonthMinDate());
/*        for (CKUsedInfo info : us.findCKUsedInfo(3L, beginDate, endDate)
        ) {
            System.out.println(info);
        }*/
/*
        ProductService ps = (ProductService) ac.getBean("productService");
*/


      /*  List<ColumnInfo> list = ps.getProductInfoListByType(1);
        for (ColumnInfo info:list
             ) {
            System.out.println(info.getProductid());
            System.out.println(info.getProductunitname());
        }*/
/*
        for (int i = 1; i < 2; i++) {
            String json =ps.getProductInfoListByType(i);
            System.out.println(json);
        }*/

/*        List<ProductType> typeArrList = ps.getProductTypeList();

        for (ProductType list : typeArrList
        ) {
            System.out.println(list);
        }
        String[] typeArr = new String[4];
        for (int i = 0; i < 4; i++) {
            typeArr[i] = typeArrList.get(i).getProductTypeName();
            System.out.println(typeArr[i]);
        }*/

    }
}
