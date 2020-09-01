package com.smart.dancommon.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author WeiWei10
 * @Date 2020/9/1 14:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;
    String username;
    String password;
}
