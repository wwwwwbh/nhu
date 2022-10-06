package cn.nhu.dao;

import cn.nhu.domain.Unit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitDao {

    @Select("SELECT A.UnitID,A.UnitName,A.IsEffective FROM TabUnit  AS A WHERE A.IsEffective = 'Y'")
    List<Unit> findAll();

    @Update("UPDATE TabUnit set UnitName=#{unitname},IsEffective=#{iseffective} where UnitID = #{unitid}")
    int updateUnit(Unit unit);

    @Insert("INSERT TabUnit(UnitName,IsEffective)values('#{unitname}','#{iseffective}')")
    int insertUnit(@Param("unitname")String unitname,@Param("iseffective")String iseffective);


}
