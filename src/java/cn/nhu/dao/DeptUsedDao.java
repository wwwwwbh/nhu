package cn.nhu.dao;

import cn.nhu.domain.DeptUsed;
import cn.nhu.info.DeptUsedInfoPlus;
import cn.nhu.info.DeptUsedinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//部门使用表
@Repository
public interface DeptUsedDao {

    /**
     * 新增车间使用信息
     *
     * @param deptUsed
     * @return
     */
    @Insert("INSERT INTO TabDeptUsed(ProductID, UserID, UsedSL, TheDate)" +
            "VALUES (#{productid},#{userid},#{usedSL},'#{thedate}')")
    int addDeptUsedInfo(DeptUsed deptUsed);

    /**
     * 修改车间使用信息
     *
     * @param deptUsed
     * @return
     */
    @Update("UPDATE TabDeptUsed SET ProductID = #{productid},UsedSL = #{usedSL} " +
            "WHERE DeptUsedID = #{userid}")
    int updateDeptUsedInfo(DeptUsed deptUsed);

    /**
     * 2019-08-01 00:00:00 2019-08-31 23:59:59
     * 查询车间使用信息
     *
     * @param userId
     * @param beginDate
     * @param endDate
     * @return
     */
    @Select("SELECT DeptUsedID,ProductID,ProductName," +
            "ProductTypeID,ProductTypeName,UnitID,UnitName," +
            "UserID,UserName,UsedSL,TheDate " +
            "FROM vw_DeptUsed " +
            "WHERE UserID = #{userId} AND TheDate >= '#{beginDate}' AND TheDate <'#{endDATE}'")
    List<DeptUsedInfoPlus> findDeptUsedInfo(@Param("userId") String userId,
                                            @Param("beginDate") String beginDate,
                                            @Param("endDate") String endDate);

    /**
     * 获取车间使用信息并动态展示(供保卫科和车间查看)
     * 根据typeId四个界面
     *
     * @param userId
     * @param typeId
     * @param beginDate
     * @param endDate
     * @return
     */
    @Select("SELECT ProductID,UsedSL,TheDate,ProductTypeID " +
            "FROM vw_DeptUsed " +
            "WHERE UserID = #{userId} " +
            "AND UsedSL > 0 AND ProductTypeID = {typeId} " +
            "AND TheDate >= '#{beginDate}' AND TheDate < '#{endDate}'")
    List<DeptUsedinfo> findDeptUsedInfoDynamics(@Param("userId") String userId,
                                                @Param("typeId") String typeId,
                                                @Param("beginDate") String beginDate,
                                                @Param("endDate") String endDate);

    /**
     * 获取车间使用信息并动态展示(供保卫科和车间查看)
     *
     * @param userId
     * @param beginDate
     * @param endDate
     * @return
     */
    @Select("SELECT ProductID,UsedSL,TheDate,ProductTypeID " +
            "FROM vw_DeptUsed " +
            "WHERE UserID = #{userId} " +
            "AND UsedSL > 0 " +
            "AND TheDate >= '#{beginDate}' AND TheDate < '#{endDate}'")
    List<DeptUsedinfo> findDeptUsedInfoALLDynamics(@Param("userId") String userId,
                                                   @Param("beginDate") String beginDate,
                                                   @Param("endDate") String endDate);
}
