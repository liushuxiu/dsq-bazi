package com.uestc.miaoshi.dsqbazi.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.miaoshi.dsqbazi.annotaition.CurrentUser;
import com.uestc.miaoshi.dsqbazi.annotaition.LoginRequired;
import com.uestc.miaoshi.dsqbazi.model.User;
import com.uestc.miaoshi.dsqbazi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author luomouren
 * @date 2017/6/4
 */
@RestController
@RequestMapping({"/user"})
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService sysUserServices;

    @ResponseBody
    @RequestMapping(value = "/registeredUser")
    public Object registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description) {
        logger.info("registeredUser:userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",password" + password + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.registeredUser(userName, realName, cellphone, emodelId, password, email, description);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/modifyUserPassword")
    public Object modifyUserPassword(String userId, String oldPassword, String newPassword) {
        JSONObject jsonObject = sysUserServices.modifyUserPassword(userId, oldPassword, newPassword);
        return jsonObject;
    }


    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/modifyUserInfo")
    public Object modifyUserInfo(@CurrentUser User user, String userId, String userName, String realName, String cellphone, String emodelId,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "description", required = false) String description) {
        logger.info(user.getUserName());
        logger.info("registeredUser:userId:" + userId + ",userName:" + userName + ",realName:" + realName + ",cellphone:" + cellphone + ",emodelId:" + emodelId + ",email" + email + ",description:" + description);
        JSONObject jsonObject = sysUserServices.modifyUserInfo(userId, userName, realName, cellphone, emodelId, email, description);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/resetUserPassword")
    public Object resetUserPassword(String userId, String newPassword) {
        JSONObject jsonObject = sysUserServices.resetUserPassword(userId, newPassword);
        return jsonObject;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/getUserInfo")
    public Object getUserInfo(@CurrentUser User user) {
        return user;
    }


}


