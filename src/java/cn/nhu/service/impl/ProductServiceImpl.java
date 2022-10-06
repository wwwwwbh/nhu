package cn.nhu.service.impl;

import cn.nhu.dao.ProductDao;
import cn.nhu.domain.Product;
import cn.nhu.domain.ProductInfo;
import cn.nhu.info.ColumnInfo;
import cn.nhu.info.ProductUnitInfo;
import cn.nhu.info.ProductUnitInfoPlus;
import cn.nhu.service.ProductService;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    /**
     * typeid:1,2,3,4
     *
     *
     * @param typeid
     * @return
     */
    @Override
    public List<ColumnInfo> getProductInfoListByType(int typeid) {
/*    /1、/返回json格式,用于生成表列的数据,已测试
       String json = "";
        List<ProductUnitInfo> list = productDao.getProductInfoListByType(typeid);
        for (ProductUnitInfo info:list) {
            json +="{ title:\""+info.getProductname()+"("+info.getUnitname()+")"+
                    "\",data:\""+"Product"+info.getProductid()+"\" },";
        }
        return json.substring(0,json.length()-1);*/
     //2、返回一个list
        List<ColumnInfo> listResult = new ArrayList<>();
        ColumnInfo ci = new ColumnInfo();
        List<ProductUnitInfo> list = productDao.getProductInfoListByType(typeid);
        for (ProductUnitInfo info:list) {
            listResult.add(new ColumnInfo(info.getProductname()+"("+info.getUnitname()+")",info.getProductid()));
        }
        return listResult;
    }

    //返回有效产品id，参数有效产品类型id,1234,(根据日期和物料动态生成展示表,根据用户和物料动态生成展示表,用于被调用)
    public Set<String> findProductID(String typeid) {
        return productDao.findProductID(typeid);
    }

    //查询物料信息
    public List<ProductUnitInfoPlus> findProductInfo() {
        return productDao.findProductInfo();
    }

    //新增物料
    public int insertProduct(ProductInfo productInfo) {
        return productDao.insertProduct(productInfo);
    }

    //更新物料
    public int updateProduct(ProductInfo productInfo) {
        return productDao.updateProduct(productInfo);
    }

    //根据料品改变和显示物料类型和单位,参数产品id
    public List<ProductUnitInfo> selectProductAndUnit(String productid) {
        return productDao.selectProductAndUnit(productid);
    }


}
