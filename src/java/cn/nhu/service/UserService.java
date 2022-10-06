package cn.nhu.service;

import cn.nhu.domain.User;

import java.util.List;

public interface UserService {

    //查询有效用户信息
    List<User> findAll();

    // 更新用户信息
    int updateUser(User user);

    //查询用户名是否存在
    boolean existUserName(String username);

    //查询用户id
    long findUserId(String username);

    //账号是否有效
    boolean selectIsEffective(String username);

    //查询用户账号密码是否正确
    boolean selectUserPwd(String username, String userpwd);

    //查询单个用户
    User selectUser(String username);

    int insertUser(User user);
    //查找部门用户名
    String[] findDeptName();

    User formatUser(Object jsonUser);
}
