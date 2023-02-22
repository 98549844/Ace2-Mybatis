package com.ace2.mybatis.mapper;

import com.ace2.mybatis.models.Function;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname: MpfaMapper
 * @Date: 2023/2/22 下午 05:02
 * @Author: kalam_au
 * @Description:
 */


//@Repository
@Mapper
//@Component
public interface MpfaMapper {

    boolean isAuthorized(String applId, String funcId, String userId);

    boolean isExist();

    boolean isNotExist();

    List<Function> isAuthorized2(String applId, String funcId, String userId);

    List<Function> getFunctions(@Param("applId") String applId, @Param("userId") String userId);

    List<Function> getChildFunctions(@Param("applId") String applId, @Param("funcId") String funcId, @Param("userId") String userId);


}


