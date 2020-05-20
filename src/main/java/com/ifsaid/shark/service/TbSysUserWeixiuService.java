package com.ifsaid.shark.service;


import com.github.pagehelper.PageInfo;
import com.ifsaid.shark.common.service.BaseService;
import com.ifsaid.shark.entity.TbSysUserWeixiu;
import com.ifsaid.shark.util.QueryParameter;
import com.ifsaid.shark.vo.TbSysUserWeixiuVo;

public interface TbSysUserWeixiuService extends BaseService<TbSysUserWeixiu, Integer> {

    /**
     * 分页擦好像 获取用户详细信息
     *
     * @param parameter
     * @return PageInfo<TbSysUserWeixiuVo>
     */
    PageInfo<TbSysUserWeixiuVo> findAllUserWeixiuPage(QueryParameter parameter);
}
