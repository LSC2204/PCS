package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */

public interface UserService extends IService<User> {

    User login(User user);

}
