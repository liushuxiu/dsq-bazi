package com.uestc.miaoshi.dsqbazi.dao;


import com.uestc.miaoshi.dsqbazi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息
 *
 * @author luomouren
 */
@Repository
public interface UserMapper  extends JpaRepository<User, Integer> {

    /**
     * 根据id查找用户
     *
     * @param userId 用户主键
     * @return
     */
    User findById(@Param("userId") String userId);

    /**
     * 根据用户名查找用户
     *
     * @param userName 用户名
     * @return
     */
    User findByUserName(@Param("userName") String userName);



    @Modifying
    @Query("update User u set u.userPassword = :newPassword where u.userId=:userId and u.userPassword = :oldPassword")
    void updatePassword(@Param("userId") String userId, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

    /**
     * 重置用户密码
     *
     * @param userId
     * @param newPassword
     */
    @Modifying
    @Query("update User u set u.userPassword = :newPassword where u.userId=:userId")
    void reSetPassword(@Param("userId") String userId, @Param("newPassword") String newPassword);
}
