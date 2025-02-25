package com.yoyo.chilema_server.service.Impl;

import com.yoyo.chilema_server.common.R;
import com.yoyo.chilema_server.mapper.UserAccountMapper;
import com.yoyo.chilema_server.pojo.UserAccount;
import com.yoyo.chilema_server.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户账号服务
 * @Author: Shiro
 * @date: 2022/9/22 15:44
 * @package: com.yoyo.chilema_server.service.Impl
 * @Version: 1.0
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountMapper userAccountMapper;

    @Override
    public R addUserAccount(UserAccount userAccount) {
        if(userAccountMapper.insert(userAccount) > 0) {
            return  R.success("注册成功");
        } else {
            return  R.error("注册失败");
        }
    }

    @Override
    public R deleteUserAccount(int id) {
        if(userAccountMapper.deleteById(id) > 0) {
            return  R.success("删除成功");
        } else {
            return  R.error("删除失败");
        }
    }

    @Override
    public R updateUserAccount(UserAccount userAccount) {
        if(userAccountMapper.updateById(userAccount) > 0) {
            return  R.success("更新成功");
        } else {
            return  R.error("更新失败");
        }
    }

    @Override
    public R selectAllUserAccount() {
        return R.success("查询成功",userAccountMapper.selectList(null));
    }

    @Override
    public R selectUserAccountById(int id) {
        return R.success("查询成功",userAccountMapper.selectById(id));
    }
}
