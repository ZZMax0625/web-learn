package com.zzmax.ajax.eneity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: User实体类
 * @author: mqxu
 * @date: 2022-02-28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
}
