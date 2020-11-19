package com.gs.mapper;

import com.gs.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    UserDTO queryUserRoleAndAuthByUserName(@Param("userName") String userName,@Param("tenantId") String tenantId);

}
