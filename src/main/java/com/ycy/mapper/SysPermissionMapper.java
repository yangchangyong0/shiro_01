package com.ycy.mapper;

import com.ycy.model.SysPermission;

import java.util.List;

/**
 *
 * <p>Title: SysPermissionMapperCustom</p>
 * <p>Description: 权限mapper</p>
 * Created by Administrator on 2015/10/14 0014.
 */
public interface SysPermissionMapper {

    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限url
    public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

}
