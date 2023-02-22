package com.ace2.mybatis.mapper;

import com.ace2.mybatis.models.Users;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;


@Mapper
public interface UsersMapper /*extends BaseMapper<Users>*/ {
    int deleteByPrimaryKey(Long userid);

    int insertXML(Users record);

    int insertSelectiveXML(Users record);

    Users selectByPrimaryKey(Long userid);

    Users selectById(Long userid);

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