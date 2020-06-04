package com.ifsaid.shark.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifsaid.shark.entity.TbComplete;
import com.ifsaid.shark.entity.TbSysUserEvaluate;
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

    @Override
    public PageInfo<TbComplete> getOrders(String loginUserName, Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<TbComplete> list =orderMapper.getOrders(loginUserName);
        //System.out.println("list  :  "+list);
        PageInfo<TbComplete> pageList = new PageInfo<TbComplete>(list);
        return pageList;
    }

    @Override
    public Integer addEvalatedata(TbSysUserEvaluate tbSysUserEvaluate) {
        return orderMapper.addEvalatedata(tbSysUserEvaluate);
    }

    @Override
    public List<TbComplete> getEvaluate(String id) {
        return orderMapper.getEvaluate(id);
    }

    @Override
    public Integer updateOrderStatus(String id, String status) {
        return  orderMapper.updateOrderStatus(id,status);
    }

}
