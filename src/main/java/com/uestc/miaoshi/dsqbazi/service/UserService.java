package com.uestc.miaoshi.dsqbazi.service;

import com.alibaba.fastjson.JSONObject;
import com.uestc.miaoshi.dsqbazi.model.User;

/**
 * 用户信息
 *
 * @author luomouren
 */
public interface UserService {

    /**
     * 根据id查找用户
     *
     * @param id 用户主键
     * @return
     */
    User findById(String id);

    /**
     * 根据用户名查找用户
     *
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);


    void updatePassword(String userId, String oldPassword, String newPassword);

    /**
     * 重置用户密码
     *
     * @param userId
     * @param newPassword
     */
    void reSetPassword(String userId, String newPassword);


    /**
     * 注册用户
     *
     * @param userName    用户名
     * @param realName    真实姓名
     * @param cellphone   手机号
     * @param emodelId    区域id
     * @param password    密码
     * @param email       邮件
     * @param description 描述
     * @return 返回信息
     */
    JSONObject registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description);

    /**
     * 更新用户信息
     *
     * @param userId      用户主键
     * @param userName    用户名
     * @param realName    真实姓名
     * @param cellphone   手机号
     * @param emodelId    区域id
     * @param email       邮箱
     * @param description 描述
     * @return 返回信息
     */
    JSONObject modifyUserInfo(String userId, String userName, String realName, String cellphone, String emodelId, String email, String description);

    /**
     * 更新用户密码
     *
     * @param userId      用户主键
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 返回信息
     */
    JSONObject modifyUserPassword(String userId, String oldPassword, String newPassword);

    /**
     * 重置密码
     *
     * @param userId      用户主键
     * @param newPassword 新密码
     * @return 返回信息
     */
    JSONObject resetUserPassword(String userId, String newPassword);
}

