package com.ace2.mybatis.controller;

import com.ace2.mybatis.mapper.UsersMapper;
import com.ace2.mybatis.models.Users;
import com.ace2.mybatis.util.RandomUtil;
import com.ace2.mybatis.util.TypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Classname: UsersPointCutController
 * @Date: 2022/9/26 上午 10:48
 * @Author: kalam_au
 * @Description:
 */

@Controller
public class UsersPointCutController {
    private static final Logger log = LogManager.getLogger(UsersPointCutController.class.getName());

    private UsersMapper usersMapper;

    public UsersPointCutController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateAsp")
    public Users updateUserByMybatisPlus() {
        long id = 533;
        Users u = usersMapper.selectById(id);
        log.info("before getVersion: " + u.getVersion());
        log.info("before getLastUpdateDate: " + u.getLastUpdateDate());
        log.info("before getLastUpdatedBy: " + u.getLastUpdatedBy());

        String acc = "garlam";
        log.info("select statement MUST NOT include common column !!!");
        Users users = usersMapper.selectByAccountWithoutCommonColumn(acc);
        users.setMobile(TypeUtil.integerToString(RandomUtil.getRangeInt(0, 99999999)));
        log.info("自定义update, common field NOT managed !!!");
        usersMapper.updateByAccount(users);


        users = usersMapper.selectById(id);
        log.info("after getVersion: " + users.getVersion());
        log.info("after getLastUpdateDate: " + users.getLastUpdateDate());
        log.info("after getLastUpdatedBy: " + users.getLastUpdatedBy());

        log.info("COMPLETE !!!");
        return users;
    }
}

