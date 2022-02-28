package com.zzmax.exercise.mapper;

import com.zzmax.exercise.enerty.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password}; ")
    User findUser(@Param("username") String username, @Param("password") String password);
}
