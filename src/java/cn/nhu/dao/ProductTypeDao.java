package cn.nhu.dao;

import cn.nhu.domain.ProductType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeDao {

    //找有效产品类型信息
    @Select("SELECT A.ProductTypeID,A.ProductTypeName,A.IsEffective FROM TabProductsType AS A WHERE IsEffective = 'Y'")
    List<ProductType> getProductTypeList();

    @Select("SELECT A.ProductTypeName FROM TabProductsType AS A WHERE IsEffective = 'Y'")
    List<String> getTypeList();
}
