package cn.nhu.dao;

import cn.nhu.domain.CKUsed;
import cn.nhu.info.CKUsedInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//仓库出库表
@Repository
public interface CKUsedDao {

    /**
     * 新增出库信息，isreceived 默认N
     *
     * @param ckUsed
     * @return
     */
    @Insert("INSERT INTO TabCKUsed(UserID,ProductID,ChuKu,TheDate,IsReceived)" +
            "VALUES(#{userid},#{productid},#{chuku},'#{thedate}','#{isreceived}')")
    int addCKUsedInfo(CKUsed ckUsed);

    /**
     * 修改仓库出库表时，同时修改车间领用表信息
     *
     * @param ckUsed
     * @return
     */
    @Update("UPDATE TabCKUsed T,TabDeptIncome TT " +
            "SET T.UserID = #{userid},T.ProductID = #{productid},T.ChuKu = #{chuku},T.TheDate = '#{thedate}', " +
            "TT.IncomeSL = #{chuku} " +
            "WHERE T.CKUsedID = #{CKusedid},TT.CKUsedID = #{CKusedid}")
    int updateCKUsedInfo(CKUsed ckUsed);


    /**
     * 查询车间待接受信息,isReceived = 'N'
     * 已测试
     *
     * @param userid    领用的用户id
     * @param beginDate 当年当月第一天
     * @param endDate   当前时间，day+1,second-1
     * @return
     */
    @Select("SELECT CKUsedID, UserID, UserName, ProductID, ProductName, " +
            "ProductTypeID, ProductTypeName, UnitID, UnitName, ChuKu, IsReceived, TheDate " +
            "FROM  vw_CKUsed WHERE IsReceived = 'N' And UserID = #{userid} " +
            "AND TheDate >= '${beginDate}' AND TheDate < '${endDate}'")
    List<CKUsedInfo> findCKUsedInfoNotReceived(@Param("userid") Long userid,
                                               @Param("beginDate") String beginDate,
                                               @Param("endDate") String endDate);

    /**
     * 查询仓库出库信息
     * 已测试
     *
     * @param userid    领用的部门id
     * @param beginDate 当年当月第一天
     * @param endDate   当前时间，day+1,second-1
     * @return
     */
    @Select("SELECT UserID, UserName, ProductID, ProductName, " +
            "ProductTypeID, ProductTypeName, UnitID, UnitName, ChuKu, IsReceived, TheDate " +
            "FROM vw_CKUsed WHERE UserID = #{userid} " +
            "AND TheDate >= '${beginDate}' AND TheDate < '${endDate}'")
    List<CKUsedInfo> findCKUsedInfo(@Param("userid") Long userid,
                                    @Param("beginDate") String beginDate,
                                    @Param("endDate") String endDate);


    /**
     *
     * @param typeId
     * @param beginDate
     * @param endDate
     * @return
     */
    @Select("SELECT UserID, UserName, ProductID, ProductName, " +
            "ProductTypeID, ProductTypeName, UnitID, UnitName, ChuKu, IsReceived, TheDate " +
            "FROM vw_CKUsed WHERE ProductTypeID = #{typeId} " +
            "AND TheDate >= '${beginDate}' AND TheDate < '${endDate}'")
    List<CKUsedInfo> findCKUsedInfoByType(@Param("typeId") Integer typeId,
                                    @Param("beginDate") String beginDate,
                                    @Param("endDate") String endDate);


}
