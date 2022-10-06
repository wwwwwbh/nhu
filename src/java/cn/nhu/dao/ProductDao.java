package cn.nhu.dao;

import cn.nhu.domain.Product;
import cn.nhu.domain.ProductInfo;
import cn.nhu.info.ProductUnitInfo;
import cn.nhu.info.ProductUnitInfoPlus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductDao {
    //找有效产品信息
    @Select("SELECT ProductID,ProductName FROM TabProducts WHERE IsEffective = 'Y'")
    List<Product> getProductList();

    //根据危险品类型返回四种,typeid:1,2,3,4
    @Select("SELECT A.ProductName,A.ProductID,C.UnitName " +
            "FROM TabProducts AS A " +
            "LEFT JOIN TabProductsType AS B ON B.ProductTypeID = A.ProductTypeID " +
            "LEFT JOIN TabUnit AS C ON C.UnitID = A.UnitID " +
            "WHERE A.IsEffective = 'Y' " +
            "AND B.IsEffective = 'Y' " +
            "AND B.ProductTypeID = #{typeid} " +
            "ORDER BY A.ProductID")
    List<ProductUnitInfo> getProductInfoListByType(@Param("typeid") int tpyeid);

    //返回有效产品id，参数有效产品类型id,1234,(根据日期和物料动态生成展示表,根据用户和物料动态生成展示表,用于被调用)
    @Select("SELECT A.ProductID FROM FROM TabProducts AS A " +
            "LEFT JOIN TabProductsType AS B ON B.ProductTypeID = A.ProductTypeID " +
            "WHERE A.IsEffective = 'Y' " +
            "AND B.IsEffective ='Y' " +
            "AND B.ProductTypeID = #{typeid} " +
            "ORDER BY A.ProductID")
    Set<String> findProductID(@Param("typeid") String typeid);

    //查询物料信息
    @Select("SELECT A.ProductID,A.ProductName,A.IsEffective,A.ProductTypeID," +
            "B.ProductTypeName,A.UnitID,C.UnitName " +
            "FROM TabProducts AS A " +
            "LEFT JOIN TabProductsType AS B ON B.ProductTypeID = A.ProductTypeID " +
            "LEFT JOIN TabUnit AS C ON C.UnitID = A.UnitID")
    List<ProductUnitInfoPlus> findProductInfo();

    //新增物料
    @Insert("INSERT INTO TabProducts(ProductName,Reamrk,IsEffective,ProductTypeID,UnitID) " +
            "VALUES('#{productname}','#{remark}','#{iseffective}','#{productTypeid}','#{unitid}')")
    int insertProduct(ProductInfo productInfo);

    //更新物料
    @Update("UPDATE TabProducts SET " +
            "ProductName = '#{productname}' " +
            "Remark = '#{remark}' " +
            "IsEffective = '#{iseffective}' " +
            "ProductTypeID= '#{productTypeid}' " +
            "UnitID = '#{unitid}' " +
            "WHERE ProductID= '#{productid}'")
    int updateProduct(ProductInfo productInfo);

    //根据料品改变和显示物料类型和单位,参数产品id
    @Select("Select A.ProductID,A.ProductName,B.ProductTypeID,B.ProductTypeName,C.UnitID,C.UnitName " +
            "FROM TabProducts AS A " +
            "LEFT JOIN TabProductsType AS B ON B.ProductTypeID = A.ProductTypeID " +
            "LEFT JOIN dbo.TabUnit AS C ON C.UnitID = A.UnitID " +
            "WHERE A.IsEffective = 'Y' AND B.IsEffective = 'Y' AND C.IsEffective = 'Y' " +
            "AND A.ProductID = #{productid}")
    List<ProductUnitInfo> selectProductAndUnit(@Param("productid") String productid);
}
