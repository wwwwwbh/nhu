package cn.nhu.service.impl;

import cn.nhu.dao.UserDao;
import cn.nhu.domain.User;
import cn.nhu.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交给IOC容器管理
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("业务层：查询所有用户信息");
        return userDao.findAll();
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean existUserName(String username) {
        return userDao.existUserName(username) == 1;
    }

    @Override
    public long findUserId(String username) {
        return userDao.findUserId(username);
    }

    @Override
    public boolean selectIsEffective(String username) {
        return userDao.selectIsEffective(username).equals("Y");
    }

    @Override
    public boolean selectUserPwd(String username, String userpwd) {
        return userDao.selectUserPwd(username, userpwd) == 1;
    }

    @Override
    public User selectUser(String username) {
        return userDao.selectUser(username);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public String[] findDeptName() {
        return userDao.findDeptName();
    }

    //转化为user对象
    @Override
    public User formatUser(Object jsonUser) {
        JSONObject userObject = JSONObject.fromObject(jsonUser);
        @SuppressWarnings("static-access")
        User userObj = (User) JSONObject.toBean(userObject, User.class);
        return userObj;
    }


}
