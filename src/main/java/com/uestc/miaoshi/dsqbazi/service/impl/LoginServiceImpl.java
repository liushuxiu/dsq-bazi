package com.uestc.miaoshi.dsqbazi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.uestc.miaoshi.dsqbazi.dao.UserMapper;
import com.uestc.miaoshi.dsqbazi.model.User;
import com.uestc.miaoshi.dsqbazi.service.LoginService;
import com.uestc.miaoshi.dsqbazi.util.AppResultConstants;
import com.uestc.miaoshi.dsqbazi.util.TokenUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:登录接口实现
 * @author:@luomouren.
 * @Date:2017-12-10 12:00
 */
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject login(String userName, String password) {
        JSONObject jsonObject = new JSONObject();

        // 判断【用户名】、【密码】参数合法性
        if (null == userName || "".equalsIgnoreCase(userName)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, UserServiceImpl.USER_NAME_ERROR);
        } else if (null == password || "".equalsIgnoreCase(password)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, UserServiceImpl.PASSWORD_ERROR);
        } else {
            // 查找用户，判断用户账号密码是否正确
            User sysUser = userMapper.findByUserName(userName);
            if (null == sysUser) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, UserServiceImpl.USER_ERROR);
            } else if (!password.equalsIgnoreCase(sysUser.getUserPassword())) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, UserServiceImpl.PASSWORD_WRONG_ERROR);
            } else {
                // 账号密码正确，生成token
                String accessToken = TokenUtils.createJwtToken(userName);
                jsonObject.put(AppResultConstants.DATA, accessToken);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                jsonObject.put(AppResultConstants.MSG, UserServiceImpl.LOGIN_SUCCESS);
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject logout(String userName) {
        return null;
    }
}
