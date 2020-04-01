package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
     /*   User user = new User();
        user.setId(1);
        user.setUsername("lucy");
        User user2 = sqlSession.selectOne("com.lagou.dao.IUserDao.selectOne", user);

        System.out.println(user2);*/

     //普通调用
     /*   List<User> users = sqlSession.selectList("com.lagou.dao.IUserDao.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

     //代理模式调用

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }



}
