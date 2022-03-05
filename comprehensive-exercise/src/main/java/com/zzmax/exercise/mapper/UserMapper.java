package com.zzmax.exercise.mapper;

import com.zzmax.exercise.enerty.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password};")
    User findUser(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM tb_user WHERE username = #{username} ")
    User selectByUsername(String username);

    @Insert("INSERT INTO tb_user VALUES (null,#{username},#{password}) ")
    void add(User user);
}
