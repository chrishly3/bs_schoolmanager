package com.ifsaid.shark.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifsaid.shark.entity.TbSysUserWeixiu;
import com.ifsaid.shark.mapper.TbSysUserWeixiuMapper;
import com.ifsaid.shark.service.TbSysUserWeixiuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TbSysUserWeixiuServiceImpl implements TbSysUserWeixiuService {

    @Autowired
    private TbSysUserWeixiuMapper orderMapper;

   /* @Override
    public PageInfo<TbSysUserWeixiuVo> findAllUserWeixiuPage(QueryParameter parameter) {
        return null;
    }*/

    @Override
    public int saveOrder(TbSysUserWeixiu schoolRepair) {
        return 0;
    }

    @Override
    public PageInfo<TbSysUserWeixiu> selectOrderLike(String repairUserName, Integer page, Integer pageSize, String repairType) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<TbSysUserWeixiu> list =orderMapper.selectOrderLike("%"+repairUserName+"%","%"+repairType+"%");
        //System.out.println("list  :  "+list);
        PageInfo<TbSysUserWeixiu> pageList = new PageInfo<TbSysUserWeixiu>(list);
        return pageList;
    }

    @Override
    public PageInfo<TbSysUserWeixiu> showOrders(Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        //System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<TbSysUserWeixiu> list = orderMapper.listOrder();
        //System.out.println("list  :  "+list);
        PageInfo<TbSysUserWeixiu> pageList = new PageInfo<TbSysUserWeixiu>(list);
        return pageList;
    }

    @Override
    public Integer removeById(String id) {
        return orderMapper.removeById(id);
    }

}
