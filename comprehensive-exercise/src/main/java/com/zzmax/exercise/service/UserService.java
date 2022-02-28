package com.zzmax.exercise.service;

import com.zzmax.exercise.enerty.User;
import com.zzmax.exercise.mapper.UserMapper;
import com.zzmax.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    /**
     *  1.获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public User login(String username,String password){
        // 2.获取获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4.调用方法
        User user = mapper.findUser(username,password);

        sqlSession.close();
        return user;
    }
}
