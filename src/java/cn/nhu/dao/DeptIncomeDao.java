package cn.nhu.dao;

import cn.nhu.domain.DeptIncome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

//部门领用表
@Repository
public interface DeptIncomeDao {

    /**
     * 修改车间领用信息
     * @param deptIncome
     * @return
     */
    @Update("UPDATE TabDeptIncome SET ProductID = #{productid},IncomeSL = #{incomeSL} WHERE DeptIncomeID = #{deptIncomeid}")
    int updateDeptIncomeInfo(DeptIncome deptIncome);

    /**
     * 新增车间领用信息
     * @param deptIncome
     * @return
     */
    @Insert("INSERT INTO TabDeptIncome " +
            "(ProductID,UserID,IncomeSL,TheDate)" +
            "VALUES(#{productid},#{userid},#{incomeSL},#{thedate})")
    int addDeptIncomeInfo(DeptIncome deptIncome);

    /**
     * 1、车间接收仓库出库信息
     *
     * @param deptIncome
     * @return
     */
    @Insert("INSERT INTO TabDeptIncome " +
            "(ProductID,UserID,IncomeSL,TheDate,CKUsedID)" +
            "VALUES(#{productid},#{userid},#{incomeSL},#{thedate},#{CKusedid})")
    int ReceiveCKUsedInfo(DeptIncome deptIncome);

    @Update("UPDATE TabCKUsed SET IsReceived = 'Y' WHERE CKUsedID = #{CKusedid}")
    int updateCKInfo(@Param("CKusedid") String CKusedid);


}
