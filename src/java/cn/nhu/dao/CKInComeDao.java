package cn.nhu.dao;

import cn.nhu.domain.CKInCome;
import cn.nhu.info.CKInComeInfo;
import cn.nhu.info.CKInComeInfoByType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//仓库入库表
@Repository
public interface CKInComeDao {

    /**
     * 动态获取仓库入库信息
     *
     * @param typeId:物料种类
     * @param beginDate:起始时间，当年当月第一天
     * @param endDate:当月最后一天
     * @return :返回该种产品类型的物料入库信息
     */
    @Select("SELECT ProductID ,ProductName ," +
            "ProductTypeID ,ProductTypeName ," +
            "UnitID ,UnitName ," +
            "RuKu ,TheDate " +
            "FROM vw_CKIncome"+
            "WHERE TheDate >= '#{beginDate}' AND TheDate < '#{endDate}' AND ProductTypeID = #{typeId}")
    List<CKInComeInfoByType> getCKIncomeInfoDynamics(@Param("typeId") String typeId,
                                                     @Param("beginDate") String beginDate,
                                                     @Param("endDate") String endDate);

    @Select("SELECT ProductID ,ProductName ," +
            "ProductTypeID ,ProductTypeName ," +
            "UnitID ,UnitName ," +
            "RuKu ,TheDate " +
            "FROM vw_CKIncome "+
            "WHERE TheDate >= '#{beginDate}' AND TheDate < '#{endDate}'")
    List<CKInComeInfoByType> getCKIncomeInfoAllDynamics(@Param("beginDate") String beginDate,
                                                        @Param("endDate") String endDate);

    /**
     * 查询仓库入库信息
     *
     * @param beginDate 当年当月第一天
     * @param endDate   当前时间，day+1,second-1
     * @return list
     */
    @Select("SELECT CKInComeID, ProductID, ProductName, " +
            "ProductTypeID ,ProductTypeName ," +
            "UnitID ,UnitName ," +
            "RuKu ,TheDate " +
            "FROM vw_CKIncome "+
            "WHERE TheDate >= '#{beginDate}' AND TheDate <= '#{endDate}'")
    List<CKInComeInfo> getCKIncomeInfo(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    /**
     * 新增入库信息
     *
     * @param ckInCome (产品id,入库量，时间)
     * @return
     */
    @Insert("INSERT INTO TabCKInCome(ProductID ,RuKu ,TheDate)VALUES (#{productId},#{ruku},'#{thedate}')")
    int AddCKIncomeInfo(CKInCome ckInCome);

    /**
     * 修改入库信息
     *
     * @param ckInCome (产品id,入库量，时间)
     * @return
     */
    @Update("UPDATE TabCKInCome SET ProductID = #{productId},RuKu = #{ruku},TheDate = '#{thedate}' WHERE CKInComeID = #{CKincomeid}")
    int updateCKIncomeInfo(CKInCome ckInCome);
}
