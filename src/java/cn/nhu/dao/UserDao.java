package cn.nhu.dao;

import cn.nhu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface UserDao {

    //查询有效用户信息
    @Select("SELECT UserID,UserName,UserPwd FROM TabUsers WHERE IsEffective = 'Y'")
    List<User> findAll();

    //更新用户信息
    @Update("UPDATE TabUsers SET UserName=#{username},UserPwd=#{userpwd},IsEffective=#{iseffective} WHERE UserID = #{userid}")
    int updateUser(User user);

    //插入用户信息
    @Insert("INSERT INTO TabUsers(UserName,UserPwd,IsEffective,Flag)values('#{username}','#{userpwd}','#{iseffective}','#{flag}')")
    int insertUser(User user);

    //账号是否正确,1存在，0不存在
    @Select("SELECT COUNT(*)from TabUsers WHERE UserName = #{username}")
    int existUserName(@Param("username") String username);

    //账号是否有效
    @Select("SELECT IsEffective FROM TabUsers WHERE UserName = #{username}")
    String selectIsEffective(@Param("username") String username);

    //账号和密码是否正确，1登录成功，0密码错误
    @Select("SELECT COUNT(*)from TabUsers WHERE UserName=#{username} and UserPwd=#{userpwd}")
    int selectUserPwd(@Param("username") String username, @Param("userpwd") String userpwd);

    //查询账号的id来判断权限,返回userid
    @Select("SELECT UserID from TabUsers WHERE UserName=#{username}")
    long findUserId(@Param("username") String username);

    //查询单个用户
    @Select("SELECT * FROM TabUsers WHERE UserName=#{username}")
    User selectUser(@Param("username") String usrname);

    //查询用户名
    @Select("SELECT UserName FROM TabUsers WHERE IsEffective = 'Y'")
    String[] findDeptName();

}
