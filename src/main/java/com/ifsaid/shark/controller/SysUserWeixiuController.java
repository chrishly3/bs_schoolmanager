package com.ifsaid.shark.controller;


import com.github.pagehelper.PageInfo;
import com.ifsaid.shark.common.controller.BaseController;

import com.ifsaid.shark.entity.TbSysUserWeixiu;
import com.ifsaid.shark.service.SysUserService;
import com.ifsaid.shark.service.TbSysUserWeixiuService;
import com.ifsaid.shark.util.JsonResult;
import com.ifsaid.shark.vo.TbSysUserWeixiuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ifsaid.shark.util.QueryParameter;

@Slf4j
@Api(tags = "[ 服务权限 ] 服务管理")
@RestController
@RequestMapping("/sys/userweixiu")
public class SysUserWeixiuController extends BaseController<TbSysUserWeixiu, Integer, TbSysUserWeixiuService> {


    @ApiOperation(value = "分页,获取服务报修详情", notes = "分页 查询所有，获取报修详情")
    @GetMapping("/info/page")
    public JsonResult findAllUserWeixiuPage(QueryParameter parameter) {
        PageInfo<TbSysUserWeixiuVo> page = baseService.findAllUserWeixiuPage(parameter);
        return JsonResult.success(page.getTotal(), page.getList());
    }


}
