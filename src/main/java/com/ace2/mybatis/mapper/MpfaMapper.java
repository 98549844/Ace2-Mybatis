package com.ace2.mybatis.mapper;

import com.ace2.mybatis.models.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname: MpfaMapper
 * @Date: 2023/2/22 下午 05:02
 * @Author: kalam_au
 * @Description:
 */

@Mapper
public interface MpfaMapper {

    boolean isAuthorized(String applId, String funcId, String userId);

    boolean isExist();
    boolean isNotExist();


    List<Function> isAuthorized2(String applId, String funcId, String userId);

}


