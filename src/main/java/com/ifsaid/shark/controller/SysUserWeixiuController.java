package com.ifsaid.shark.controller;


import com.github.pagehelper.PageInfo;

import com.ifsaid.shark.entity.QueryOrder;
import com.ifsaid.shark.entity.TbComplete;
import com.ifsaid.shark.entity.TbSysUserEvaluate;
import com.ifsaid.shark.entity.TbSysUserWeixiu;
import com.ifsaid.shark.service.TbSysUserWeixiuService;
import com.ifsaid.shark.util.JsonResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "[ 服务权限 ] 服务管理")
@RestController
@RequestMapping("/order")
public class SysUserWeixiuController {

    @Autowired
    private TbSysUserWeixiuService tbSysUserWeixiuService;
    //private final Logger logger = LoggerFactory.getLogger(SchoolUserInfoController.class);

//    @ApiOperation(value = "分页,获取服务报修详情", notes = "分页 查询所有，获取报修详情")
//    @GetMapping("/info/page")
//    public JsonResult findAllUserWeixiuPage(QueryParameter parameter) {
//        PageInfo<TbSysUserWeixiuVo> page = baseService.findAllUserWeixiuPage(parameter);
//        return JsonResult.success(page.getTotal(), page.getList());
//    }

//    /**
//     * 根据id查询维修单
//     * @param id
//     * @return
//     */
//    @GetMapping("getOrder/{id}")
//    public R getOrder(@PathVariable String id) {
//        SchoolRepair order = orderService.getOrderById(id);
//        return R.ok().data("order",order);
//    }
//    /**
//     * 编辑维修单
//     * @param id
//     * @param schoolRepair
//     * @return
//     */
//    @PostMapping("updateOrder/{id}")
//    public R editOrder(@PathVariable String id,@RequestBody SchoolRepair schoolRepair){
//
//        int row=orderService.editOrder(schoolRepair);
//        if(row==1){
//            return R.ok();
//        }else {
//            return R.error();
//        }
//    }
//



    /**
     * 带条件分页查询
     *
     * @param queryOrder
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("moreCondtionPageList/{page}/{pageSize}")
    public JsonResult showOrders(@PathVariable Integer page, @PathVariable Integer pageSize,
                                 @RequestBody(required = false) QueryOrder queryOrder) {
        PageInfo<TbSysUserWeixiu> pageList = tbSysUserWeixiuService.showOrders(page, pageSize);
        System.out.println(pageList);
        String repairUserName = queryOrder.getRepairUserName();
        System.out.println(repairUserName);
        String repairType = queryOrder.getRepairType();
        if (repairUserName != null || repairType != null) {
            pageList = tbSysUserWeixiuService.selectOrderLike("%" + repairUserName + "%", page, pageSize, "%" + repairType + "%");
        }
        //System.out.println(pageList);
        return JsonResult.success(pageList);
    }

    @PostMapping("moreCondtionPageList2/{page}/{pageSize}/{loginUserName}")
    public JsonResult getOrders(@PathVariable Integer page, @PathVariable Integer pageSize,
                                @PathVariable String loginUserName) {

        PageInfo<TbComplete> pageList=tbSysUserWeixiuService.getOrders( loginUserName , page, pageSize);
        //System.out.println(pageList);
        return JsonResult.success(pageList);
    }

    @DeleteMapping("{id}")
    public JsonResult removeById(@PathVariable String id) {
        Integer delete = tbSysUserWeixiuService.removeById(id);
        System.out.println(delete);
        if (delete.equals(1)) {
            return JsonResult.success();
        } else {
            return JsonResult.error();
        }

        /**
         * 添加维修单的方法
         * @param schoolRepair
         * @return 是否添加成功
         */
        /*@RequestMapping(value = "/addOrder",method = RequestMethod.POST)
        public JsonResult addSchoolRepair(@RequestBody TbSysUserWeixiu tbSysUserWeixiu) {
            int save = tbSysUserWeixiuService.saveOrder(tbSysUserWeixiu);
            if(save==1) {
                return JsonResult.success();
            } else {
                return JsonResult.error();
            }
        }*/



//    /**
//     * 查询所有报修单（测试）
//     * @return
//     */
//    @GetMapping("/list")
//    public R getAllOrderList() {
//        //调用service的方法
//        List<SchoolRepair> list = orderService.listOrder();
//        return R.ok().data("items",list);
//    }
//
//    /**
//     * 添加维修单的方法
//     * @param schoolRepair
//     * @return 是否添加成功
//     */
//    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
//    public R addSchoolRepair(@RequestBody SchoolRepair schoolRepair) {
//        System.err.println(schoolRepair.getRepairUserName());
//        System.err.println(schoolRepair.getRepairType());
//        logger.info("SchoolUserInfoController-addSchoolRepair-schoolRepair",schoolRepair.getRepairUserName());
//        int save = orderService.saveOrder(schoolRepair);
//        if(save==1) {
//            return R.ok();
//        } else {
//            return R.error();
//        }
//    }



    }
    /**
     * 添加评论的方法
     * @param
     * @return 是否添加成功
     */
//        @RequestMapping(value = "/addEvalatedata",method = RequestMethod.POST)
       @PostMapping("/addEvaluatedata")
    public JsonResult addSchoolRepair(@RequestBody TbSysUserEvaluate tbSysUserEvaluate) {
        Integer status=1;
        tbSysUserEvaluate.setStatus(status);
        int save = tbSysUserWeixiuService.addEvalatedata(tbSysUserEvaluate);
        if(save==1) {
            return JsonResult.success();
        } else {
            return JsonResult.error();
        }
    }

    @GetMapping("/getEvaluate/"+"{id}")
    public JsonResult getEvaluate(@PathVariable String id) {
        List<TbComplete> list = tbSysUserWeixiuService.getEvaluate(id);

            return JsonResult.success(list);
    }

    @GetMapping("/updateOrderStatus/"+"{id}"+"/"+"{status}")
    public JsonResult updateOrderStatus(@PathVariable String id,@PathVariable String status) {
        System.out.println(id);
        System.out.println(status);
        Integer result = tbSysUserWeixiuService.updateOrderStatus(id,status);
        if(result==1){
            return JsonResult.success();
        }else{
            return JsonResult.error();
        }


    }
}
