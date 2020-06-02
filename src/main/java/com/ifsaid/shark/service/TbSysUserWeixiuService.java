package com.ifsaid.shark.service;


import com.github.pagehelper.PageInfo;
import com.ifsaid.shark.entity.TbSysUserEvaluate;
import com.ifsaid.shark.entity.TbSysUserWeixiu;

public interface TbSysUserWeixiuService  {


    /*PageInfo<TbSysUserWeixiuVo> findAllUserWeixiuPage(QueryParameter parameter);*/

    int saveOrder(TbSysUserWeixiu schoolRepair);

    public PageInfo<TbSysUserWeixiu> selectOrderLike(String repairUserName,Integer page, Integer pageSize,String repairType);

    /**
     * 查询所有维修单
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<TbSysUserWeixiu> showOrders(Integer page, Integer pageSize);

    public Integer removeById(String id);

    PageInfo<TbSysUserWeixiu> getOrders(String loginUserName,Integer page, Integer pageSize);


    Integer addEvalatedata(TbSysUserEvaluate tbSysUserEvaluate);
}
