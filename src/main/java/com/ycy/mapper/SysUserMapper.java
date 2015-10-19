package com.ycy.mapper;

import com.ycy.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     *  根据用户查询用户系统信息
     * @param usercode
     * @return
     */
    List<SysUser> getSysUserByUserCode(String usercode);

}