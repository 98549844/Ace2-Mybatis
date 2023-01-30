package com.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.models.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    int deleteByPrimaryKey(Long userid);

    int insertXML(Users record);

    int insertSelectiveXML(Users record);

    Users selectByPrimaryKey(Long userid);

    Users selectByAccount(String account);

    Users selectByAccountWithoutCommonColumn(String account);

    List<Map> findUserRolePermissionByMybatis(Long userid);

    List<Map> findAllUserRolePermissionByMybatis();

    List<Users> findAll();

    List<Users> selectAll(); // mapper and xml 不同名字

    List<Users> findUsersLikeNameByMybatis(String userName);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int updateByAccount(Users record);

}