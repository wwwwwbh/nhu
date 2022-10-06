package cn.nhu.test;

import cn.nhu.dao.UserDao;
import cn.nhu.dao.ProductTypeDao;
import cn.nhu.domain.ProductType;
import cn.nhu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestMybatis {

    private UserDao userDao;
    private InputStream in;
    //private SqlSessionFactoryBuilder builder;
    private SqlSession sqlsession;



    @Before
    public void init() throws IOException {
        //加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        sqlsession = factory.openSession();
        //获取代理对象
        userDao = sqlsession.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        //sqlsession.commit();
        //回滚不插入数据库
        sqlsession.rollback();
        //log.info("为了保持测试数据的干净，这里选择回滚,不写入mysql,请观察日志，回滚完成");
        sqlsession.close();
        in.close();
    }

    @Test
    public void run1() throws SQLException {
        //加载配置文件
/*        ResultSet rs = userDao.selectUser("testwu");
        while(rs.next()){
            System.out.println(rs.next());
        }*/
    }

}
