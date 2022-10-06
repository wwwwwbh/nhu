package cn.nhu.service;

import cn.nhu.domain.Product;
import cn.nhu.domain.ProductInfo;
import cn.nhu.info.ColumnInfo;
import cn.nhu.info.ProductUnitInfo;
import cn.nhu.info.ProductUnitInfoPlus;
import org.apache.ibatis.executor.resultset.ResultSetHandler;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getProductList();

    List<ColumnInfo> getProductInfoListByType(int tpyeid);

    Set<String> findProductID(String typeid);

    List<ProductUnitInfoPlus> findProductInfo();

    int insertProduct(ProductInfo productInfo);

    int updateProduct(ProductInfo productInfo);

    List<ProductUnitInfo> selectProductAndUnit(String productid);
}
